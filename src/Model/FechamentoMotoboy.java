package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FechamentoMotoboy {

    private Motoboy motoboy;
    private List<Entrega> entregas;
    private BigDecimal caixinha;


    public FechamentoMotoboy(Motoboy motoboy) {
        this.motoboy = motoboy;
        this.entregas = new ArrayList<Entrega>();
        this.caixinha = BigDecimal.ZERO;
    }

    public void adicionarEntrega(Entrega entrega){
        if(entrega == null) throw new IllegalArgumentException("Model.Entrega não pode ser nula");
        entregas.add(entrega);
    }

    public void adicionarCaixinha(BigDecimal valor){
        if(valor == null) throw new IllegalArgumentException("Caixinha não pode ser nula");
        this.caixinha = this.caixinha.add(valor);
    }

    public BigDecimal totalEntregas(){
        BigDecimal total = BigDecimal.ZERO;
        for(Entrega e : entregas){
            total = total.add(e.getValor());
        }
        return total;
    }

    public BigDecimal totalGeral(){
        return totalEntregas().add(caixinha);
    }

    public int getQuantidadeEntregas() {
        return entregas.size();
    }

    public void imprimirRelatorio(){
        System.out.println("Model.Motoboy: " + motoboy.getNome());
        System.out.println("Entregas: " + entregas.size());

        for (Entrega e : entregas) {
            System.out.println(e);
        }

        System.out.println("Total entregas: R$ " + totalEntregas());
        System.out.println("Caixinha: R$ " + caixinha);
        System.out.println("TOTAL GERAL: R$ " + totalGeral());
        }
    }
