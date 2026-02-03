package Model;

import Model.Exceptions.BairroInvalidoException;
import java.math.BigDecimal;

public class Bairro {

    private Integer id;
    private String nome;
    private BigDecimal valorTaxa;

    public Bairro(Integer id, String nome, BigDecimal valorTaxa) {

        if (nome == null || nome.isBlank())
            throw new BairroInvalidoException("Nome do bairro inválido");

        if (valorTaxa == null || valorTaxa.compareTo(BigDecimal.ZERO) <= 0)
            throw new BairroInvalidoException("Valor do bairro inválido");

        this.id = id;
        this.nome = nome;
        this.valorTaxa = valorTaxa;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorTaxa() {
        return valorTaxa;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + valorTaxa + ")";
    }
}