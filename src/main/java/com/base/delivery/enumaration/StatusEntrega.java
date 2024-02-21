package com.base.delivery.enumaration;

import lombok.Getter;

@Getter
public enum StatusEntrega {
    PREPARACAO("Pedido em Preparação"),
    EM_ROTA("Rota de Entrega"),
    ENTREGUE("Pedido Entregue");

    private final String statusEntrega;

    StatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }
}
