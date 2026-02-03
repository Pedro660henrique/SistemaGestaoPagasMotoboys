package view;

import Model.*;
import Model.Exceptions.FechamentoInvalidoException;
import Model.Repository.CadastrarBairro;
import Model.Repository.CadastrarMotoboy;
import Model.Utils.InputUtils;
import Service.FechamentoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CadastrarBairro cadastrarBairro = new CadastrarBairro();
        CadastrarMotoboy cadastrarMotoboy = new CadastrarMotoboy();

        List<FechamentoMotoboy> fechamentosDia = new ArrayList<>();

        System.out.println("=== SISTEMA DE CONTROLE DE ENTREGAS ===");

        char continuarSistema;

        do {
            System.out.println("\n--- IDENTIFICAÇÃO DO MOTOBOY ---");

            int idMotoboy = InputUtils.lerInt(sc, "ID do motoboy: ");
            String nomeMotoboy = InputUtils.lerString(sc, "Nome do motoboy: ");

            Motoboy motoboy = new Motoboy(idMotoboy, nomeMotoboy);
            cadastrarMotoboy.cadastrar(motoboy);

            System.out.println("\n--- HORÁRIO DE TRABALHO ---");

            String horarioEntrada = InputUtils.lerHorario(sc, "Horário de entrada (HH:mm): ");
            String horarioSaida   = InputUtils.lerHorario(sc, "Horário de saída   (HH:mm): ");

            BigDecimal pagaDia = InputUtils.lerBigDecimal(sc, "Valor da paga do dia: R$ ");

            FechamentoService fechamentoService = new FechamentoService();

            FechamentoMotoboy fechamento = fechamentoService.iniciarFechamento(
                    motoboy,
                    horarioEntrada,
                    horarioSaida,
                    pagaDia
            );

            System.out.println("\n--- REGISTRO DE ENTREGAS ---");

            char continuarEntrega;
            do {
                int numeroComanda = InputUtils.lerInt(sc, "Número da comanda: ");

                Entrega entrega = EntregaMenu.configurarEntrega(
                        sc,
                        numeroComanda,
                        cadastrarBairro
                );

                if (entrega != null) {
                    fechamento.adicionarEntrega(entrega);
                    System.out.println("Entrega registrada com sucesso!");
                } else {
                    System.out.println("Entrega cancelada.");
                }

                continuarEntrega = InputUtils.lerSN(
                        sc,
                        "Registrar outra entrega para este motoboy? (s/n): "
                );

            } while (continuarEntrega == 's');

            // Caixinha opcional
            char adicionarCaixinha = InputUtils.lerSN(
                    sc,
                    "Deseja adicionar caixinha para o motoboy? (s/n): "
            );

            if (adicionarCaixinha == 's') {
                BigDecimal caixinha = InputUtils.lerBigDecimal(sc, "Valor da caixinha: R$ ");
                fechamento.adicionarCaixinha(caixinha);
            }

            // Alterar paga antes do fechamento
            char alterarPaga = InputUtils.lerSN(
                    sc,
                    "Deseja alterar a paga do dia antes do fechamento? (s/n): "
            );

            if (alterarPaga == 's') {
                BigDecimal novaPaga = InputUtils.lerBigDecimal(sc, "Nova paga do dia: R$ ");
                fechamento.alterarPagaPeriodo(novaPaga);
            }

            // Validação e fechamento
            try {
                fechamento.validarFechamento();

                System.out.println("\n--- FECHAMENTO DO MOTOBOY ---");
                fechamento.imprimirRelatorio();

                fechamentosDia.add(fechamento);

            } catch (FechamentoInvalidoException e) {
                System.out.println("Erro no fechamento: " + e.getMessage());
            }

            continuarSistema = InputUtils.lerSN(
                    sc,
                    "\nDeseja registrar outro motoboy? (s/n): "
            );

        } while (continuarSistema == 's');

        // RELATÓRIO FINAL DO DIA
        System.out.println("\n=== RELATÓRIO FINAL DO DIA ===");

        int totalEntregasDia = 0;
        BigDecimal totalMovimentadoDia = BigDecimal.ZERO;

        for (FechamentoMotoboy f : fechamentosDia) {
            totalEntregasDia += f.getQuantidadeEntregas();
            totalMovimentadoDia = totalMovimentadoDia.add(
                    f.totalReceberMotoboy()
            );
        }

        System.out.println("-------------------------------------");
        System.out.println("Total de entregas no dia: " + totalEntregasDia);
        System.out.println("Valor total movimentado: R$ " + totalMovimentadoDia);

        sc.close();
        System.out.println("\nSistema finalizado.");
    }
}