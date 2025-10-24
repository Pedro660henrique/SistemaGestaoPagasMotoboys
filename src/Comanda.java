import java.math.BigDecimal;

public class Comanda {

    private int numeroComanda;
    private String EndercoEntrega;
    private int numeroResidencia;
    private int Cep;
    private BigDecimal valorTaxaEntrega;
    private Bairro bairro;

    public Comanda(int numeroComanda, String endercoEntrega, int numeroResidencia, int cep, BigDecimal valorTaxaEntrega, Bairro bairro) {
        this.numeroComanda = numeroComanda;
        EndercoEntrega = endercoEntrega;
        this.numeroResidencia = numeroResidencia;
        Cep = cep;
        this.valorTaxaEntrega = valorTaxaEntrega;
        this.bairro = bairro;
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public BigDecimal getValorTaxaEntrega() {
        return valorTaxaEntrega;
    }

    public Bairro getBairro() {
        return bairro;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "Numero Comanda=" + numeroComanda +
                ", Enderco Entrega='" + EndercoEntrega + '\'' +
                ", Numero Residencia=" + numeroResidencia +
                ", Cep=" + Cep +
                ", Valor da Taxa de Entrega=" + valorTaxaEntrega +
                ", Bairro=" + bairro +
                '}';
    }
}
