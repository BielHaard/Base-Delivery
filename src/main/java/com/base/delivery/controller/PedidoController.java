package com.base.delivery.controller;

import com.base.delivery.entity.Pedido;
import com.base.delivery.repository.PedidoRepository;
import com.base.delivery.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;
    @Autowired
    private PedidoRepository pedidosRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> getListarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.buscarPedidoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> adicionarPedido(@RequestBody Pedido pedidos) {
        return ResponseEntity.ok(pedidoService.adicionarPedido(pedidos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@RequestBody Pedido pedidos) {
        return ResponseEntity.ok(pedidoService.atualizarPedido(pedidos.getIdPedido(), pedidos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
