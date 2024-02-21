package com.base.delivery.service;

import com.base.delivery.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> listarPedidos();

    Pedido buscarPedidoPorId(Long id);

    Pedido adicionarPedido(Pedido cliente);

    Pedido atualizarPedido(Long id, Pedido cliente);

    void deletarPedido(Long id);

}
