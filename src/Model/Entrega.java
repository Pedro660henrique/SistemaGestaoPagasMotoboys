package Model;

import java.math.BigDecimal;

public class Entrega {

    private Comanda comanda;

    public Entrega(Comanda comanda) {
        this.comanda = comanda;
    }

    public BigDecimal getValor(){
        return comanda.getValorEntrega();
    }

    @Override
    public String toString() {
        return comanda.toString();
    }
}
