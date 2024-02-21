package com.base.delivery.entity;

import com.base.delivery.enumaration.StatusEntrega;
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
    private Long id;

    @Column(name = "status", nullable = false)
    private StatusEntrega status;

    @OneToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "entrega_pedido",
            joinColumns = @JoinColumn(name = "entrega_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private Pedido pedido;

}