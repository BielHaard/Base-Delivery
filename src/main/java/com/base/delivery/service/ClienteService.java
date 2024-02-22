package com.base.delivery.service;

import com.base.delivery.dto.ClienteDTO;
import com.base.delivery.dto.PedidoDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> getAllClientes();

    ClienteDTO getClienteById(Long id);

    ClienteDTO createCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    void deleteCliente(Long id);

    ClienteDTO relacionarPedidoAoCliente(Long clienteId, PedidoDTO pedidoDTO);
}
