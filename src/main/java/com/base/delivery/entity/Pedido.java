package com.base.delivery.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(position = 1)
    @Schema(description = "ID do pedido", example = "1")
    private Long idPedido;

    @Column(name = "descricao", nullable = false)
    @ApiModelProperty(position = 2)
    @Schema(description = "Descrição do pedido", example = "Pedido de exemplo")
    private String descricao;

    @Column(name = "valor", nullable = false)
    @ApiModelProperty(position = 3)
    @Schema(description = "Valor total do pedido", example = "100.0")
    private double valorTotalPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @ApiModelProperty(position = 4)
    @Schema(description = "Cliente associado ao pedido")
    private Cliente cliente;

    @OneToOne(mappedBy = "pedido", orphanRemoval = true)
    @ApiModelProperty(position = 5)
    @Schema(description = "Entrega associada ao pedido")
    private Entrega entrega;

}