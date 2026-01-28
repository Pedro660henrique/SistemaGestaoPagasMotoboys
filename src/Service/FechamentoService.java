package Service;

import Model.Entrega;
import Model.FechamentoMotoboy;
import Model.Motoboy;

import java.math.BigDecimal;

public class FechamentoService {
    public FechamentoMotoboy iniciarFechamento(Motoboy motoboy){
        return new FechamentoMotoboy(motoboy);
    }

    public void registrarEntrega(FechamentoMotoboy fechamento, Entrega entrega){
        fechamento.adicionarEntrega(entrega);
    }

    public void adicionarCaixinha(FechamentoMotoboy fechamento, BigDecimal valor){
        fechamento.adicionarCaixinha(valor);
    }
}
