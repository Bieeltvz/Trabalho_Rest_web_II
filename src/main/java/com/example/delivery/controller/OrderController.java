package com.example.delivery.controller;

import com.example.delivery.model.Pedido;
import com.example.delivery.model.Cliente;
import com.example.delivery.repository.ClienteRepository;
import com.example.delivery.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Controller para Pedidos (Orders).
 * Conectado ao banco via `PedidoRepository`. Ao criar um pedido, espera-se
 * que o JSON contenha `cliente.id` para associar o pedido ao cliente existente.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Create: salva um novo pedido; associa cliente por id e seta data se ausente
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Pedido pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            return ResponseEntity.badRequest().body("cliente.id é obrigatório");
        }
        Optional<Cliente> c = clienteRepository.findById(pedido.getCliente().getId());
        if (!c.isPresent()) return ResponseEntity.badRequest().body("cliente.id inválido");
        pedido.setCliente(c.get());
        if (pedido.getDataPedido() == null) pedido.setDataPedido(LocalDateTime.now());
        Pedido saved = pedidoRepository.save(pedido);
        return ResponseEntity.ok(saved);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        if (!pedidoRepository.existsById(id)) return ResponseEntity.notFound().build();
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Pedido pedido) {
        Optional<Pedido> existing = pedidoRepository.findById(id);
        if (!existing.isPresent()) return ResponseEntity.notFound().build();
        if (pedido.getCliente() != null && pedido.getCliente().getId() != null) {
            Optional<Cliente> c = clienteRepository.findById(pedido.getCliente().getId());
            if (!c.isPresent()) return ResponseEntity.badRequest().body("cliente.id inválido");
            pedido.setCliente(c.get());
        } else {
            pedido.setCliente(existing.get().getCliente());
        }
        pedido.setId(id);
        Pedido saved = pedidoRepository.save(pedido);
        return ResponseEntity.ok(saved);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getOrderById(@PathVariable Long id) {
        return pedidoRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<Pedido>> getAllOrders() {
        return ResponseEntity.ok(pedidoRepository.findAll());
    }
}
