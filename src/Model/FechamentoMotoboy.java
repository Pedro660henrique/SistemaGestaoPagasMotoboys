package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FechamentoMotoboy {

    private Motoboy motoboy;
    private String horarioEntrada;
    private String horarioSaida;
    private BigDecimal paga;
    private BigDecimal caixinha = BigDecimal.ZERO;
    private List<Entrega> entregas = new ArrayList<>();
    private boolean fechado = false;

    public FechamentoMotoboy(
            Motoboy motoboy,
            String horarioEntrada,
            String horarioSaida,
            BigDecimal paga
    ) {
        this.motoboy = motoboy;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.paga = paga;
    }

    public void adicionarEntrega(Entrega entrega) {
        if (fechado) {
            throw new IllegalStateException("Fechamento já realizado");
        }
        entregas.add(entrega);
    }

    public void fechar() {
        if (entregas.isEmpty()) {
            throw new IllegalStateException("Não é possível fechar sem entregas");
        }
        this.fechado = true;
    }

    // AÇÕES PÓS-FECHAMENTO
    public void adicionarCaixinha(BigDecimal valor) {
        if (!fechado) {
            throw new IllegalStateException("Fechamento ainda não realizado");
        }
        this.caixinha = this.caixinha.add(valor);
    }

    public void alterarPaga(BigDecimal novaPaga) {
        if (!fechado) {
            throw new IllegalStateException("Fechamento ainda não realizado");
        }
        this.paga = novaPaga;
    }

    public int getQuantidadeEntregas() {
        return entregas.size();
    }

    public BigDecimal getTotalReceber() {
        return paga.add(caixinha);
    }

    public Motoboy getMotoboy() {
        return motoboy;
    }

    public boolean isFechado() {
        return fechado;
    }
}