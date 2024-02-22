package com.base.delivery.service.impl;

import com.base.delivery.dto.ClienteDTO;
import com.base.delivery.dto.PedidoDTO;
import com.base.delivery.entity.Cliente;
import com.base.delivery.entity.Pedido;
import com.base.delivery.exception.IdNotFoundException;
import com.base.delivery.repository.ClienteRepository;
import com.base.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(ClienteDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ClienteDTO getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Cliente não encontrado com ID: " + id));
        return ClienteDTO.fromEntity(cliente);
    }

    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteDTO.toEntity();
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteDTO.fromEntity(clienteSalvo);
    }

    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Cliente não encontrado com ID: " + id));

        cliente.setNome(clienteDTO.nome());
        cliente.setNumeroTelefone(clienteDTO.numeroTelefone());

        return ClienteDTO.fromEntity(clienteRepository.save(cliente));
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteDTO relacionarPedidoAoCliente(Long clienteId, PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IdNotFoundException("Cliente não encontrado com ID: " + clienteId));
        Pedido pedido = pedidoDTO.toEntity();
        pedido.setCliente(cliente);
        cliente.getPedidos().add(pedido);
        return ClienteDTO.fromEntity(clienteRepository.save(cliente));
    }
}
