public class Entrega {

    int numeroComanda;
    double valorEntrega;

    public Entrega(int numeroComanda, double valorEntrega) {
        this.numeroComanda = numeroComanda;
        this.valorEntrega = valorEntrega;
    }

    public double getValorEntrega() {
        return valorEntrega;
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

}
