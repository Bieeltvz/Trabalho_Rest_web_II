package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        Map<String, String> res = new HashMap<>();
        res.put("message", "createDelivery endpoint funcional");
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDelivery(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "deleteDelivery endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDelivery(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "updateDelivery endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getDeliveryById(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getDeliveryById endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllDeliveries() {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getAllDeliveries endpoint funcional");
        return ResponseEntity.ok(res);
    }
}
