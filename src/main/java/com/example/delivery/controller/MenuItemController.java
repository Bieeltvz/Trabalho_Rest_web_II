package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller para itens de menu (pratos).
 * Proporciona endpoints REST mínimos que confirmam funcionalidade.
 */
@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    @PostMapping
    public ResponseEntity<Map<String, String>> createMenuItem() {
        return ResponseEntity.ok(Map.of("message", "createMenuItem endpoint funcional"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMenuItem(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "deleteMenuItem endpoint funcional", "id", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateMenuItem(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "updateMenuItem endpoint funcional", "id", id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getMenuItemById(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "getMenuItemById endpoint funcional", "id", id));
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllMenuItems() {
        return ResponseEntity.ok(Map.of("message", "getAllMenuItems endpoint funcional"));
    }
}
