package com.base.delivery.dto;

import com.base.delivery.entity.Entrega;
import com.base.delivery.enumaration.StatusEntrega;

public record EntregaDTO(StatusEntrega status, PedidoDTO pedido, String endereco) {

    public static EntregaDTO fromEntity(Entrega entrega) {
        return new EntregaDTO(
                entrega.getStatus(),
                PedidoDTO.fromEntity(entrega.getPedido()),
                entrega.getEndereco()
        );
    }

    public Entrega toEntity() {
        return new Entrega(
                null,
                this.status(),
                this.pedido().toEntity(),
                this.endereco()
        );
    }
}
