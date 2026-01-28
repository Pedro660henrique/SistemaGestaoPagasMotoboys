package Model;

public class Bairro {

    private int id;
    private String nome;
    private Double valorTaxa;

    public Bairro(int id, String nome, Double valorTaxa) {
        this.id = id;
        this.nome = nome;
        this.valorTaxa = valorTaxa;
    }

    public String getNome() {
        return nome;
    }

    public Double getValorTaxa() {
        return valorTaxa;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + valorTaxa + ")";
    }
}
