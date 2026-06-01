package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller para acompanhar entregas (Delivery tracking).
 * Endpoints apenas retornam mensagem de funcionamento.
 */
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @PostMapping
    public ResponseEntity<Map<String, String>> createDelivery() {
        return ResponseEntity.ok(Map.of("message", "createDelivery endpoint funcional"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDelivery(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "deleteDelivery endpoint funcional", "id", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDelivery(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "updateDelivery endpoint funcional", "id", id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getDeliveryById(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "getDeliveryById endpoint funcional", "id", id));
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllDeliveries() {
        return ResponseEntity.ok(Map.of("message", "getAllDeliveries endpoint funcional"));
    }
}
