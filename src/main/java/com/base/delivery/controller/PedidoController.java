package com.base.delivery.controller;

import com.base.delivery.dto.PedidoDTO;
import com.base.delivery.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoDTO> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public PedidoDTO getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping("/{clienteId}")
    public PedidoDTO createPedido(@RequestBody PedidoDTO pedidoDTO, @PathVariable Long clienteId) {
        return pedidoService.createPedido(pedidoDTO, clienteId);
    }

    @PutMapping("/{id}")
    public PedidoDTO updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.updatePedido(id, pedidoDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
    }
}
