package com.base.delivery.entity;

import com.base.delivery.enumaration.StatusEntrega;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Column(name = "endereco")
    private String endereco;

}
