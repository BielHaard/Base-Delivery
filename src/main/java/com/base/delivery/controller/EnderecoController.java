package com.base.delivery.controller;

import com.base.delivery.entity.Endereco;
import com.base.delivery.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> getListarEnderecos() {
        return ResponseEntity.ok(enderecoService.listarEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> adicionarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.adicionarEndereco(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.atualizarEndereco(id, endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
