package com.base.delivery.entity;

import com.base.delivery.enumaration.StatusEntrega;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(position = 1)
    private Long idEntrega;

    @Column(name = "status", nullable = false)
    @ApiModelProperty(position = 2)
    private StatusEntrega status;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "entrega_pedido",
            joinColumns = @JoinColumn(name = "entrega_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    @ApiModelProperty(position = 3)
    private Endereco endereco;

}