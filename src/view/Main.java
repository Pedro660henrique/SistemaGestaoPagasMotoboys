package view;

import Model.*;
import Service.FechamentoService;
import Service.InputUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);

            // Cadastros em memória
            CadastrarBairro cadastrarBairro = new CadastrarBairro();
            CadastrarMotoboy cadastrarMotoboy = new CadastrarMotoboy();

            // Lista de fechamentos do dia
            List<FechamentoMotoboy> fechamentos = new ArrayList<>();

            System.out.println("=== SISTEMA DE CONTROLE DE ENTREGAS ===");

            char continuarSistema;

            do {
                System.out.println("\n--- IDENTIFICAÇÃO DO MOTOBOY ---");
                int idMotoboy = InputUtils.lerInt(sc, "ID do Motoboy: ");
                System.out.print("Nome do Motoboy: ");
                String nomeMotoboy = sc.nextLine();

                Motoboy motoboy = new Motoboy(idMotoboy, nomeMotoboy);
                cadastrarMotoboy.cadastrar(motoboy);

                FechamentoMotoboy fechamento = new FechamentoMotoboy(motoboy);

                System.out.println("\n--- REGISTRO DE ENTREGAS ---");

                char continuarEntrega;
                do {
                    int numeroComanda = InputUtils.lerInt(sc, "Número da comanda: ");

                    Entrega entrega = EntregaMenu.configurarEntrega(sc, numeroComanda, cadastrarBairro);

                    if (entrega != null) {
                        fechamento.adicionarEntrega(entrega);
                        System.out.println("Entrega registrada com sucesso!");
                    } else {
                        System.out.println("Entrega cancelada.");
                    }

                    continuarEntrega = InputUtils.lerSN(sc,
                            "Registrar outra entrega para este motoboy? (s/n): ");

                } while (continuarEntrega == 's');

                // Caixinha opcional
                char adicionarCaixinha = InputUtils.lerSN(sc,
                        "Deseja adicionar caixinha para o motoboy? (s/n): ");

                if (adicionarCaixinha == 's') {
                    var valorCaixinha = InputUtils.lerBigDecimal(sc, "Valor da caixinha: ");
                    fechamento.adicionarCaixinha(valorCaixinha);
                }

                // Relatório individual
                System.out.println("\n--- FECHAMENTO DO MOTOBOY ---");
                fechamento.imprimirRelatorio();

                fechamentos.add(fechamento);

                continuarSistema = InputUtils.lerSN(sc,
                        "\nDeseja registrar outro motoboy? (s/n): ");

            } while (continuarSistema == 's');

            // Relatório final do dia
            System.out.println("\n=== RELATÓRIO FINAL DO DIA ===");

            int totalEntregasDia = 0;
            var totalGeralDia = java.math.BigDecimal.ZERO;

            for (FechamentoMotoboy f : fechamentos) {
                totalEntregasDia += f.getQuantidadeEntregas();
                totalGeralDia = totalGeralDia.add(f.totalGeral());
            }

            System.out.println("-------------------------------------");
            System.out.println("Total de entregas no dia: " + totalEntregasDia);
            System.out.println("Valor total movimentado: R$ " + totalGeralDia);

            sc.close();
            System.out.println("\nSistema finalizado.");
        }
    }