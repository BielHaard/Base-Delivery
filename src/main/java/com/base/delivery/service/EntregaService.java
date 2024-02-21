package com.base.delivery.service;

import com.base.delivery.entity.Entrega;

import java.util.List;

public interface EntregaService {

    List<Entrega> listarEntregas();

    Entrega buscarEntregaPorId(Long id);

    Entrega adicionarEntrega(Entrega entrega);

    Entrega atualizarEntrega(Long id, Entrega entrega);

    void deletarEntrega(Long id);

}
