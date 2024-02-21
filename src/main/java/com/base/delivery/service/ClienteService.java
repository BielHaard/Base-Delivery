package com.base.delivery.service;

import com.base.delivery.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listarClientes();

    Cliente buscarClientePorId(Long id);

    Cliente adicionarCliente(Cliente cliente);

    Cliente atualizarCliente(Long id, Cliente cliente);

    void deletarCliente(Long id);

}
