package com.base.delivery.service;
import com.base.delivery.dto.EntregaDTO;

import java.util.List;

public interface EntregaService {

    List<EntregaDTO> getAllEntregas();

    EntregaDTO getEntregaById(Long id);

    EntregaDTO createEntrega(EntregaDTO entregaDTO, Long pedidoId);

    EntregaDTO updateEntrega(Long id, EntregaDTO entregaDTO);

    void deleteEntrega(Long id);
}
