package Model;

import Model.Exceptions.EntregaInvalidaException;
import java.math.BigDecimal;

public class Entrega {

    private Comanda comanda;
    private BigDecimal valor;

    public Entrega(Comanda comanda) {

        if (comanda == null)
            throw new EntregaInvalidaException("Comanda não pode ser nula");

        this.comanda = comanda;
        this.valor = comanda.getBairro().getValorTaxa();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Comanda getComanda() {
        return comanda;
    }

    @Override
    public String toString() {
        return comanda + " | Valor: R$ " + valor;
    }
}