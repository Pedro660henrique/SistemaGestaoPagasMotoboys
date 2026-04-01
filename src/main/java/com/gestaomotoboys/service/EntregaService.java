package com.gestaomotoboys.service;

import com.gestaomotoboys.model.Bairro;
import com.gestaomotoboys.model.Comanda;
import com.gestaomotoboys.model.Entrega;

public class EntregaService {
    public Entrega criarEntrega(Comanda comanda) {
        return new Entrega(comanda);
    }

    public void alterarBairroEntrega(Entrega entrega, Bairro novoBairro) {
        entrega.getComanda().alterarBairro(novoBairro);
    }

    public void adicionarObservacao(Entrega entrega, String obs) {
        entrega.getComanda().setObservacao(obs);
    }

    public Entrega repetirEntrega(Entrega entregaOriginal) {
        Comanda c = entregaOriginal.getComanda();
        Comanda nova = new Comanda(c.getNumeroComanda(), c.getBairro());
        return new Entrega(nova);
    }
}
