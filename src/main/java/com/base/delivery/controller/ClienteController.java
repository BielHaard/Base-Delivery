package com.base.delivery.controller;

import com.base.delivery.dto.ClienteDTO;
import com.base.delivery.dto.PedidoDTO;
import com.base.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public ClienteDTO createCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.createCliente(clienteDTO);
    }

    @PutMapping("/{id}")
    public ClienteDTO updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.updateCliente(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

    @PostMapping("/{clienteId}/relacionar-pedido")
    public ClienteDTO relacionarPedidoAoCliente(@PathVariable Long clienteId, @RequestBody PedidoDTO pedidoDTO) {
        return clienteService.relacionarPedidoAoCliente(clienteId, pedidoDTO);
    }
}
