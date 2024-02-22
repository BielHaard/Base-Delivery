package com.base.delivery.dto;

import com.base.delivery.entity.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public record ClienteDTO(Long id, String nome, String numeroTelefone, List<PedidoDTO> pedidos) {

    public static ClienteDTO fromEntity(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getNumeroTelefone(),
                cliente.getPedidos().stream()
                        .map(PedidoDTO::fromEntity)
                        .collect(Collectors.toList())
        );
    }

    public Cliente toEntity() {
        return new Cliente(
                this.id(),
                this.nome(),
                this.numeroTelefone(),
                this.pedidos().stream()
                        .map(PedidoDTO::toEntity)
                        .collect(Collectors.toList())
        );
    }
}
