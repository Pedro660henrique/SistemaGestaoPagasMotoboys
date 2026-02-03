package Model;

public class Comanda {

    private Integer numeroComanda;
    private Bairro bairro;
    private String observacao;

    public Comanda(Integer numeroComanda, Bairro bairro) {

        if (numeroComanda == null || numeroComanda <= 0)
            throw new IllegalArgumentException("Número da comanda inválido");

        if (bairro == null)
            throw new IllegalArgumentException("Bairro não informado");

        this.numeroComanda = numeroComanda;
        this.bairro = bairro;
    }

    public Integer getNumeroComanda() {
        return numeroComanda;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void alterarBairro(Bairro novoBairro) {
        if (novoBairro == null)
            throw new IllegalArgumentException("Novo bairro inválido");
        this.bairro = novoBairro;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Comanda " + numeroComanda +
                " | Bairro: " + bairro +
                (observacao != null ? " | Obs: " + observacao : "");
    }
}