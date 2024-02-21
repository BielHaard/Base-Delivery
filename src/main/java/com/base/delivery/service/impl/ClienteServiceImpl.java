package com.base.delivery.service.impl;

import com.base.delivery.entity.Cliente;
import com.base.delivery.repository.ClienteRepository;
import com.base.delivery.repository.EntregaRepository;
import com.base.delivery.repository.PedidoRepository;
import com.base.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    EntregaRepository entregaRepository;

    @Override
    public List<Cliente> listarClientes() {
        return null;
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return null;
    }

    @Override
    public Cliente adicionarCliente(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente atualizarCliente(String id, Cliente cliente) {
        return null;
    }

    @Override
    public void deletarCliente(Long id) {

    }
}
