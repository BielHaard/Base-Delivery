package com.base.delivery.controller;

import com.base.delivery.entity.Entrega;
import com.base.delivery.repository.EntregaRepository;
import com.base.delivery.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public ResponseEntity<List<Entrega>> getListarEntregas() {
        return ResponseEntity.ok(entregaService.listarEntregas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> getEntregaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(entregaService.buscarEntregaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Entrega> adicionarEntrega(@RequestBody Entrega entrega) {
        return ResponseEntity.ok(entregaService.adicionarEntrega(entrega));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> atualizarEntrega(@PathVariable Long id, @RequestBody Entrega entrega) {
        return ResponseEntity.ok(entregaService.atualizarEntrega(id, entrega));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEntrega(@PathVariable Long id) {
        entregaService.deletarEntrega(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
