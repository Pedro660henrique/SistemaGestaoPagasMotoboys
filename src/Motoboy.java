import java.util.ArrayList;

public class Motoboy {

    private final String nomeMotoboy;
    private final ArrayList<Entrega> entregas = new ArrayList<>();

    public Motoboy(String nomeMotoboy) {
        this.nomeMotoboy = nomeMotoboy;
    }

    public void adicionarEntrega(Entrega e){
        if(e == null) throw new IllegalArgumentException("Entrega não pode ser nula");
        entregas.add(e);
    }

    public double calcularTotalEntregas(){
        double total = 0;
        for(Entrega e : entregas){
            total += e.getValorEntrega();
        }
        return total;
    }

    public int getQuantidadeEntregas(){
        return entregas.size();
    }

    public String getNomeMotoboy(){
        return nomeMotoboy;
    }

    public void mostrarResumo(){
        System.out.println("\nMotoboy: " + nomeMotoboy);
        System.out.println("Entregas Realizadas: " + getQuantidadeEntregas());
        System.out.println("Total a raceber: R$ " + calcularTotalEntregas());
    }
}
