import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Entrega> entregas = new ArrayList<>();

        char continuarMotoboy;

        System.out.println("Digite o nome do motoboy: ");
        String nomeMotoboy = sc.next();

        System.out.println("Digite o numero da comanda: ");
        int numeroComanda = sc.nextInt();

        System.out.println("Digite o valor da entrega: ");
        double valorEntrega = sc.nextDouble();

        Entrega NovaEntrega= new Entrega(nomeMotoboy, numeroComanda, valorEntrega){

        }

    }
}