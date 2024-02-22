package com.base.delivery.service.impl;

import com.base.delivery.dto.EntregaDTO;
import com.base.delivery.entity.Entrega;
import com.base.delivery.exception.IdNotFoundException;
import com.base.delivery.repository.EntregaRepository;
import com.base.delivery.service.EntregaService;
import com.base.delivery.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private PedidoService pedidoService;

    public List<EntregaDTO> getAllEntregas() {
        List<Entrega> entregas = entregaRepository.findAll();
        return entregas.stream()
                .map(EntregaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public EntregaDTO getEntregaById(Long id) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Entrega não encontrada com ID: " + id));
        return EntregaDTO.fromEntity(entrega);
    }

    public EntregaDTO createEntrega(EntregaDTO entregaDTO, Long pedidoId) {
        Entrega entrega = entregaDTO.toEntity();
        return EntregaDTO.fromEntity(entregaRepository.save(entrega));
    }

    public EntregaDTO updateEntrega(Long id, EntregaDTO entregaDTO) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Entrega não encontrada com ID: " + id));

        entrega.setStatus(entregaDTO.status());

        return EntregaDTO.fromEntity(entregaRepository.save(entrega));
    }

    public void deleteEntrega(Long id) {
        entregaRepository.deleteById(id);
    }
}
