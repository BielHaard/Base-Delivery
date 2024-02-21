package com.base.delivery.service.impl;

import com.base.delivery.entity.Entrega;
import com.base.delivery.exception.IdNotFoundException;
import com.base.delivery.repository.EntregaRepository;
import com.base.delivery.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Override
    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    @Override
    public Entrega buscarEntregaPorId(Long id) {
        return entregaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Entrega não encontrada com ID: " + id));
    }

    @Override
    public Entrega adicionarEntrega(Entrega entrega) {
        try {
            return entregaRepository.save(entrega);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao adicionar a entrega. Verifique as restrições de integridade de dados.", e);
        }
    }

    @Override
    public Entrega atualizarEntrega(Long id, Entrega entrega) {
        entregaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Entrega não encontrada com ID: " + id));
        return entregaRepository.save(entrega);
    }

    @Override
    public void deletarEntrega(Long id) {
        entregaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Entrega não encontrada com ID: " + id));
        entregaRepository.deleteById(id);
    }
}
