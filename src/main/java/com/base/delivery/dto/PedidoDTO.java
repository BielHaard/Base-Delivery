package com.base.delivery.dto;

import com.base.delivery.entity.Pedido;

public record PedidoDTO(String descricao, double valorTotalPedido, ClienteDTO cliente) {

    public static PedidoDTO fromEntity(Pedido pedido) {
        return new PedidoDTO(
                pedido.getDescricao(),
                pedido.getValorTotalPedido(),
                ClienteDTO.fromEntity(pedido.getCliente())
        );
    }

    public Pedido toEntity() {
        return new Pedido(
                null,
                this.descricao(),
                this.valorTotalPedido(),
                this.cliente().toEntity(),
                null
        );
    }
}
