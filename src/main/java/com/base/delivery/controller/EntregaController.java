package com.base.delivery.controller;

import com.base.delivery.dto.EntregaDTO;
import com.base.delivery.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public List<EntregaDTO> getAllEntregas() {
        return entregaService.getAllEntregas();
    }

    @GetMapping("/{id}")
    public EntregaDTO getEntregaById(@PathVariable Long id) {
        return entregaService.getEntregaById(id);
    }

    @PostMapping("/{pedidoId}")
    public EntregaDTO createEntrega(@RequestBody EntregaDTO entregaDTO, @PathVariable Long pedidoId) {
        return entregaService.createEntrega(entregaDTO, pedidoId);
    }

    @PutMapping("/{id}")
    public EntregaDTO updateEntrega(@PathVariable Long id, @RequestBody EntregaDTO entregaDTO) {
        return entregaService.updateEntrega(id, entregaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEntrega(@PathVariable Long id) {
        entregaService.deleteEntrega(id);
    }
}
