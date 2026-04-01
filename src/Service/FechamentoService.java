package Service;

import Model.Entrega;
import Model.FechamentoMotoboy;
import Model.Motoboy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FechamentoService {

    private List<FechamentoMotoboy> fechamentos = new ArrayList<>();

    public FechamentoMotoboy iniciarFechamento(
            Motoboy motoboy,
            String horaEntrada,
            String horaSaida,
            BigDecimal paga
    ) {
        FechamentoMotoboy fechamento = new FechamentoMotoboy(
                motoboy, horaEntrada, horaSaida, paga
        );
        fechamentos.add(fechamento);
        return fechamento;
    }

    public void registrarEntrega(FechamentoMotoboy fechamento, Entrega entrega) {
        fechamento.adicionarEntrega(entrega);
    }

    public void fecharMotoboy(FechamentoMotoboy fechamento) {
        fechamento.fechar();
    }


    public void alterarPaga(Motoboy motoboy, BigDecimal novaPaga) {
        FechamentoMotoboy fechamento = buscarFechamento(motoboy);
        fechamento.alterarPaga(novaPaga);
    }

    private FechamentoMotoboy buscarFechamento(Motoboy motoboy) {
        return fechamentos.stream()
                .filter(f -> f.getMotoboy().equals(motoboy) && f.isFechado())
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("Fechamento não encontrado")
                );
    }
}
