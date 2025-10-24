import java.math.BigDecimal;

public enum PagaPeriodo {

    Manha(new BigDecimal("30.00")),
    Tarde(new BigDecimal("50.00")),
    Noite(new BigDecimal("40.00")),
    ;

    private BigDecimal pagaMotoboy;

    PagaPeriodo(BigDecimal pagaMotoboy){
        this.pagaMotoboy = pagaMotoboy;
    }

}


