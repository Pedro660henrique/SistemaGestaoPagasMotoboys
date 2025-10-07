import java.util.Scanner;

public class Entrega {

    String nomeMotoboy;
    int numeroComanda;
    double valorEntrega;

    static int totalEntregasRealizadas = 0;
    static double valorTotalEntregas = 0;

    public Entrega(String nomeMotoboy, int numeroComanda, double valorEntrega) {
        this.nomeMotoboy = nomeMotoboy;
        this.numeroComanda = numeroComanda;
        this.valorEntrega = valorEntrega;
        //Calculando total de entrega do motoboy, toda vez que cria uma nova entrega imcrementa no contador
        totalEntregasRealizadas++;
        valorTotalEntregas += valorEntrega;
    }

    public void mostrarDados(){
         System.out.println("Motoboy: " + nomeMotoboy);
         System.out.println("Comanda: " + numeroComanda);
         System.out.println("valor Entrega R$: " + valorEntrega);
         System.out.println("---------------------------------------------");
    }

    public static void mostrarResumo(){
        System.out.println("Total Entregas Realizadas: " + totalEntregasRealizadas);
        System.out.println("Valor Total Recebido: " + valorTotalEntregas);
        System.out.println("---------------------------------------------");
    }
}
