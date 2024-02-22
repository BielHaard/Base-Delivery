package com.base.delivery.service.impl;

import com.base.delivery.dto.PedidoDTO;
import com.base.delivery.entity.Pedido;
import com.base.delivery.exception.IdNotFoundException;
import com.base.delivery.repository.PedidoRepository;
import com.base.delivery.service.ClienteService;
import com.base.delivery.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    public List<PedidoDTO> getAllPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(PedidoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public PedidoDTO getPedidoById(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Pedido não encontrado com ID: " + id));
        return PedidoDTO.fromEntity(pedido);
    }

    public PedidoDTO createPedido(PedidoDTO pedidoDTO, Long clienteId) {

        Pedido pedido = pedidoDTO.toEntity();
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        clienteService.relacionarPedidoAoCliente(clienteId, PedidoDTO.fromEntity(pedidoSalvo));

        return PedidoDTO.fromEntity(pedidoSalvo);
    }

    public PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Pedido não encontrado com ID: " + id));

        pedido.setDescricao(pedidoDTO.descricao());
        pedido.setValorTotalPedido(pedidoDTO.valorTotalPedido());

        return PedidoDTO.fromEntity(pedidoRepository.save(pedido));
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
