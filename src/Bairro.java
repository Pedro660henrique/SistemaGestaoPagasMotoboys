import java.math.BigDecimal;

public enum Bairro {

    CENTRO(new BigDecimal("4.00")),
    ITARARE(new BigDecimal("4.00")),
    JARDIM_INDEPENCENCIA(new BigDecimal("4.00")),
    VILA_VALENCA(new BigDecimal("4.00")),
    BOA_VISTA(new BigDecimal("4.00")),
    VILA_CASCATINHA(new BigDecimal("4.00")),
    CATIAPOA(new BigDecimal("4.00")),
    JARDIM_GUASSU(new BigDecimal("4.00")),
    PARQUE_BITARU(new BigDecimal("4.00")),
    VILA_MELO(new BigDecimal("4.00")),
    JARDIM_NOSSO_LAR(new BigDecimal("4.00")),
    VILA_VOTURUA(new BigDecimal("4.00")),
    ILHA_PORCHAT(new BigDecimal("4.00")),
    CASCATINHA(new BigDecimal("4.00")),
    VILA_SAO_JORGE_SAO_VICENTE(new BigDecimal("4.00")),
    VILA_SAO_JORGE_SANTOS(new BigDecimal("5.00")),
    BEIRAMAR(new BigDecimal("5.00")),
    CIDADE_NAUTICA(new BigDecimal("5.00")),
    ESPLANADA_DOS_BARREIROS(new BigDecimal("5.00")),
    PARQUE_SAO_VICENTE(new BigDecimal("5.00")),
    PLANALTO_BELA_VISTA(new BigDecimal("5.00")),
    VILA_MARGARIDA(new BigDecimal("5.00")),
    NOSSA_SENHORA_DE_FATIMA(new BigDecimal("5.00")),
    AREIA_BRANCA(new BigDecimal("5.00")),
    CASTELO(new BigDecimal("5.00")),
    RADIO_CLUBE(new BigDecimal("5.00")),
    SANTA_MARIA(new BigDecimal("5.00")),
    JOSE_MENINO_SANTOS(new BigDecimal("5.00")),
    MEXICO_70(new BigDecimal("5.00")),
    MORRO_DOS_BARBOSAS(new BigDecimal("5.00")),
    JOCKEY_CLUB(new BigDecimal("5.00")),
    VILA_MATEO_BEI(new BigDecimal("5.00")),
    CANELEIRA(new BigDecimal("6.00")),
    PARQUE_PRAINHA(new BigDecimal("6.00")),
    JOSE_MENINO_MORRO(new BigDecimal("6.00")),
    BOM_RETIRO(new BigDecimal("6.00")),
    CHICO_DE_PAULA(new BigDecimal("7.00")),
    CONJUNTO_TANCREDO_NEVES(new BigDecimal("7.00")),
    JAPUI(new BigDecimal("7.00")),
    ALEMOA(new BigDecimal("10.00")),
    SABOO(new BigDecimal("10.00")),
    ;

    private BigDecimal taxaEntrega;

    Bairro(BigDecimal taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public BigDecimal getTaxaEntrega() {
        return taxaEntrega;
    }
}
