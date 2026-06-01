package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller para Pedidos (Orders).
 * Mesmo comportamento: endpoints apenas confirmam funcionalidade.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<Map<String, String>> createOrder() {
        return ResponseEntity.ok(Map.of("message", "createOrder endpoint funcional"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteOrder(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "deleteOrder endpoint funcional", "id", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateOrder(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "updateOrder endpoint funcional", "id", id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "getOrderById endpoint funcional", "id", id));
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllOrders() {
        return ResponseEntity.ok(Map.of("message", "getAllOrders endpoint funcional"));
    }
}
