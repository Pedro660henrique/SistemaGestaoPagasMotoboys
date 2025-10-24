import java.util.ArrayList;
import java.util.List;

public class FechamentoMotoboy {

    Motoboy motoboy;
    private List<Entrega> entregas;
    private PagaPeriodo pagaPeriogdo;


    public FechamentoMotoboy(Motoboy motoboy) {
        this.motoboy = motoboy;
        this.entregas = new ArrayList<Entrega>();
        this.pagaPeriogdo = pagaPeriogdo;
    }

    public void adicionarEntrega(Entrega e){
        if(e == null) throw new IllegalArgumentException("Entrega não pode ser nula");
        entregas.add(e);
    }

    public void calcularPagamento(){
        this.pagaPeriogdo = pagaPeriogdo.add(calcularPagamento());
    }

    public PagaPeriodo getPagaPeriogdo() {
        return pagaPeriogdo;
    }

    public String getNomeMotoboy(){
        return nomeMotoboy;
    }

    @Override
    public String toString() {
        return "Fechamento Motoboy{" +
                "Motoboy=" + motoboy +
                ", Entregas Realizadas=" + entregas.size() +
                ", Paga Periogdo =" + pagaPeriogdo +
                ", Total =" + pagaPeriogdo + entregas.size() +
                '}';
    }
}
