package com.gestaomotoboys.service;

import com.gestaomotoboys.gestaopagas.exception.ResourceNotFoundException;
import com.gestaomotoboys.gestaopagas.exception.ValidationException;
import com.gestaomotoboys.gestaopagas.model.*;
import com.gestaomotoboys.gestaopagas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Service
public class FechamentoService {

    @Autowired
    private FechamentoMotoboyRepository fechamentoRepository;

    @Autowired
    private MotoboyRepository motoboyRepository;

    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional(readOnly = true)
    public List<FechamentoMotoboy> findAll() {
        return fechamentoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<FechamentoMotoboy> findFechados() {
        return fechamentoRepository.findByFechadoTrueOrderByHoraEntradaDesc();
    }

    @Transactional(readOnly = true)
    public List<FechamentoMotoboy> findByMotoboy(Long motoboyId) {
        Motoboy motoboy = motoboyRepository.findById(motoboyId)
                .orElseThrow(() -> new ResourceNotFoundException("Motoboy", motoboyId));
        return fechamentoRepository.findByMotoboyOrderByHoraEntradaDesc(motoboy);
    }

    @Transactional(readOnly = true)
    public FechamentoMotoboy getFechamentoById(Long id) {
        return fechamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fechamento", id));
    }

    @Transactional
    public FechamentoMotoboy create(Motoboy motoboy, LocalTime horaEntrada,
                                    LocalTime horaSaida, BigDecimal paga) {
        if (motoboy == null) {
            throw new ValidationException("Motoboy é obrigatório");
        }
        if (horaEntrada == null || horaSaida == null) {
            throw new ValidationException("Horários de entrada e saída são obrigatórios");
        }
        if (paga == null || paga.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Paga deve ser zero ou positivo");
        }

        // Verificar se motoboy existe
        Motoboy motoboyExistente = motoboyRepository.findById(motoboy.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Motoboy", motoboy.getId()));

        FechamentoMotoboy fechamento = new FechamentoMotoboy(
                motoboyExistente, horaEntrada, horaSaida, paga
        );

        return fechamentoRepository.save(fechamento);
    }

    @Transactional
    public void adicionarEntrega(Long fechamentoId, Long entregaId) {
        FechamentoMotoboy fechamento = getFechamentoById(fechamentoId);

        if (fechamento.isFechado()) {
            throw new ValidationException("Fechamento já está encerrado");
        }

        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new ResourceNotFoundException("Entrega", entregaId));

        entrega.setFechamento(fechamento);
        entregaRepository.save(entrega);
        fechamento.adicionarEntrega(entrega);
    }

    @Transactional
    public void adicionarCaixinha(Long fechamentoId, BigDecimal valor) {
        FechamentoMotoboy fechamento = getFechamentoById(fechamentoId);

        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Valor da caixinha deve ser positivo");
        }

        fechamento.adicionarCaixinha(valor);
        fechamentoRepository.save(fechamento);
    }

    @Transactional
    public void alterarPaga(Long fechamentoId, BigDecimal novaPaga) {
        FechamentoMotoboy fechamento = getFechamentoById(fechamentoId);

        if (novaPaga == null || novaPaga.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Paga deve ser zero ou positivo");
        }

        fechamento.alterarPaga(novaPaga);
        fechamentoRepository.save(fechamento);
    }

    @Transactional
    public FechamentoMotoboy fechar(Long fechamentoId) {
        FechamentoMotoboy fechamento = getFechamentoById(fechamentoId);
        fechamento.fechar();
        return fechamentoRepository.save(fechamento);
    }

    @Transactional
    public void delete(Long id) {
        FechamentoMotoboy fechamento = getFechamentoById(id);
        if (fechamento.isFechado()) {
            throw new ValidationException("Não é possível excluir um fechamento já encerrado");
        }
        fechamentoRepository.deleteById(fechamentoId);
    }
}

