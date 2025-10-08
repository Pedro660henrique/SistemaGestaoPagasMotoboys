import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //metodo para tratar exceção ao ler o numero da comanda.
    private static int lerInt(Scanner sc, String prompt){
        while (true){
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try{
                return Integer.parseInt(s);
            }catch (NumberFormatException e){
                System.out.print("Valor inválido. Digite um numero inteiro: ");
            }
        }
    }

    //metodo para tratar exceção ao ler o valor da comanda.
    private static double lerDouble(Scanner sc, String prompt) {
        while (true){
            System.out.print(prompt);
            String s = sc.nextLine().trim().replace(",", "."); //aceita virgula
            try {
             return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Ex.: 12,50 ");
            }
        }
    }
    //metodo para tratar exceção ao ler a respostas com s ou n.
    private static char lerSN(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("s") || s.equals("n")) {
                return s.charAt(0);
            }
            System.out.println("Responda com 's' ou 'n'.");
        }
    }
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            List<Motoboy> motoboys = new ArrayList<>();

            char continuarMotoboy;
            System.out.println("==Sistema de Controle de Entregas==");

            do {
                System.out.print("\nNome do Motoboy: ");
                String nomeMotoboy = sc.nextLine();
                Motoboy motoboy = new Motoboy(nomeMotoboy);

                System.out.print("\n---Registro de entregas para " + nomeMotoboy + "---\n");

                while (true) {
                    int numeroComanda = lerInt(sc,"Numero da Comanda: ");
                    double valorEntrega = lerInt(sc,"Valor da entrega: ");
                    motoboy.adicionarEntrega(new Entrega(numeroComanda, valorEntrega));
                    System.out.println("Entrega Registrada com Sucesso!!\n");
                    System.out.print("\nDeseja registrar outra entrega para esse motoboy? (s/n): ");
                    char continuarEntregas = sc.next().toLowerCase().charAt(0);
                    sc.nextLine(); // limpa o buffer
                    if (continuarEntregas != 's') break;
                }

                motoboy.mostrarResumo();
                motoboys.add(motoboy);
                System.out.print("\nDeseja registrar outra entrega para outro motoboy? (s/n): ");
                continuarMotoboy = sc.next().toLowerCase().charAt(0);
                sc.nextLine();

            } while (continuarMotoboy == 's');
                System.out.println("==RELATORIO FINAL DO DIA==");
                double totalGeral = 0;
                int totalEntregasDia = 0;
                for (Motoboy m : motoboys) {
                    m.mostrarResumo();
                    totalGeral += m.calcularTotalEntregas();
                    totalEntregasDia += m.getQuantidadeEntregas();
                }

            System.out.println("---------------------------------------------");
            System.out.println("Total Entregas realizadas no dia: " + totalEntregasDia);
            System.out.printf("Valor Total Movimentado: R$ %.2f%n" , totalGeral);
            sc.close();

        }
    }