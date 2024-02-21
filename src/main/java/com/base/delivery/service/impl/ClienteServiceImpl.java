package com.base.delivery.service.impl;

import com.base.delivery.entity.Cliente;
import com.base.delivery.exception.IdNotFoundException;
import com.base.delivery.repository.ClienteRepository;
import com.base.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Cliente não encontrado com ID: " + id));
    }

    @Override
    public Cliente adicionarCliente(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao adicionar o cliente. Verifique as restrições de integridade de dados.", e);
        }
    }

    @Override
    public Cliente atualizarCliente(Long id, Cliente cliente) {
        clienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Cliente não encontrado com ID: " + id));
        return clienteRepository.save(cliente);
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Cliente não encontrado com ID: " + id));
        clienteRepository.deleteById(id);
    }
}
