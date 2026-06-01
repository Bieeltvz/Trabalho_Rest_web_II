package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        Map<String, String> res = new HashMap<>();
        res.put("message", "createOrder endpoint funcional");
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteOrder(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "deleteOrder endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateOrder(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "updateOrder endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getOrderById(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getOrderById endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllOrders() {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getAllOrders endpoint funcional");
        return ResponseEntity.ok(res);
    }
}
