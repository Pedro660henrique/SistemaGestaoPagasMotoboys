import java.math.BigDecimal;

public enum Bairro {

    CENTRO(new BigDecimal("4.00")),
    ITARARE(new BigDecimal("4.00")),
    JARDIM_INDEPENCENCIA(new BigDecimal("4.00")),
    VILA_VALENCA(new BigDecimal("4.00")),
    BOA_VISTA(new BigDecimal("4.00")),
    VILA_CASCATINHA(new BigDecimal("4.00")),
    
    ;

    private BigDecimal taxaEntrega;

    Bairro(BigDecimal taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public BigDecimal getTaxaEntrega() {
        return taxaEntrega;
    }
}
