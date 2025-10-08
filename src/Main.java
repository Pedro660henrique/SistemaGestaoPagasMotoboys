import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Motoboy> motoboys = new ArrayList<>();

        char continuarMotoboy;
        System.out.println("==Sistema de Controle de Entregas==");

        
        do {
            System.out.print("\nNome do Motoboy: ");
            String nomeMotoboy = sc.next();

            Motoboy motoboy = new Motoboy(nomeMotoboy);

            System.out.print("\n---Registro de entregas para " + nomeMotoboy + "--- ");

            while (true) {
                System.out.print("Numero da Comanda: ");
                int numeroComanda = sc.nextInt();

                System.out.print("Valor da entrega: ");
                double valorEntrega = sc.nextDouble();

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
        } while (continuarMotoboy  == 's');

        System.out.println("==RELATORIO FINAL DO DIA==");

        double totalGeral = 0;
        int totalEntregasDia = 0;

        for(Motoboy m : motoboys){
            m.mostrarResumo();
            totalGeral += m.calcularTotalEntregas();
        }

        System.out.println("---------------------------------------------");
        System.out.println("Total Entregas realizadas no dia: " + totalEntregasDia);
        System.out.println("Valor Total Movimentado: R$ %.2F\n" + totalGeral);

        sc.close();

    }
}