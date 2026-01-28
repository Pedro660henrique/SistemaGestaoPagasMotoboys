package Model;

import java.math.BigDecimal;

public class Comanda {

    private int numeroComanda;
    private Bairro bairro;
    private BigDecimal valorEntrega;
    private String observacao;

    public Comanda(int numeroComanda, Bairro bairro) {
        this.numeroComanda = numeroComanda;
        this.bairro = bairro;
        this.valorEntrega = valorEntrega;
    }

    public BigDecimal getValorEntrega() {
        return valorEntrega;
    }

    public void alterarBairro(Bairro novoBairro){
        this.bairro = novoBairro;
        this.valorEntrega = BigDecimal.valueOf(novoBairro.getValorTaxa());
    }

    public void  setObservacao(String observacao){
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Model.Comanda " + numeroComanda + "| Model.Bairro: " + bairro + (observacao != null ? " | Obs: " + observacao : "");
    }

}
