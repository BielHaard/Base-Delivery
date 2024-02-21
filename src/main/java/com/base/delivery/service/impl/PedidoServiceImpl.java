package com.base.delivery.service.impl;

import com.base.delivery.entity.Pedido;
import com.base.delivery.exception.IdNotFoundException;
import com.base.delivery.repository.PedidoRepository;
import com.base.delivery.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Pedido não encontrado com ID: " + id));
    }

    public Pedido adicionarPedido(Pedido pedido) {
        try {
            return pedidoRepository.save(pedido);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao adicionar o pedido. Verifique as restrições de integridade de dados.", e);
        }
    }

    @Override
    public Pedido atualizarPedido(Long id, Pedido pedido) {
        pedidoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Pedido não encontrado com ID: " + id));
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deletarPedido(Long id) {
        pedidoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Pedido não encontrado com ID: " + id));
        pedidoRepository.deleteById(id);
    }
}
