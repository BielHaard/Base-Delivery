package com.base.delivery.service;
import com.base.delivery.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {

    List<PedidoDTO> getAllPedidos();

    PedidoDTO getPedidoById(Long id);

    PedidoDTO createPedido(PedidoDTO pedidoDTO, Long clienteId);

    PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO);

    void deletePedido(Long id);
}
