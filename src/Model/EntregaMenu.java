package Model;

import Model.Exceptions.BairroInvalidoException;
import Model.Repository.CadastrarBairro;
import Model.Utils.InputUtils;

import java.util.Scanner;

public class EntregaMenu {

    public static Entrega configurarEntrega(Scanner sc, int numeroComanda, CadastrarBairro cadastrarBairro){
        Comanda comanda;

        try{
            System.out.println("Escolha o bairro da entrega:");
            cadastrarBairro.listarBairros();

            int idBairro = InputUtils.lerInt(sc, "ID do bairro: ");
            Bairro bairro = cadastrarBairro.buscarPorId(idBairro);

            comanda = new Comanda(numeroComanda, bairro);

        } catch (BairroInvalidoException e) {
            System.out.println(e.getMessage());
            return null;
        }

        boolean configurando = true;

        while (configurando) {
            System.out.println("\n--- MENU DA ENTREGA ---");
            System.out.println("1 - Alterar bairro");
            System.out.println("2 - Adicionar observação");
            System.out.println("3 - Repetir comanda");
            System.out.println("4 - Confirmar entrega");

            int opcao = InputUtils.lerInt(sc, "Opção: ");

            switch (opcao) {
                case 1 -> {
                    cadastrarBairro.listarBairros();
                    int novoId = InputUtils.lerInt(sc, "Novo bairro: ");
                    try {
                        Bairro novoBairro = cadastrarBairro.buscarPorId(novoId);
                        comanda.alterarBairro(novoBairro);
                        System.out.println("Bairro alterado com sucesso!");
                    } catch (BairroInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Observação: ");
                    comanda.setObservacao(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Comanda será repetida.");
                    return new Entrega(comanda); // retorna entrega extra
                }
                case 4 -> configurando = false;
                default -> System.out.println("Opção inválida.");
            }
        }

        return new Entrega(comanda);
    }
}
