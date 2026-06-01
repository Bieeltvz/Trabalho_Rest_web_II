package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        Map<String, String> res = new HashMap<>();
        res.put("message", "createMenuItem endpoint funcional");
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMenuItem(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "deleteMenuItem endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateMenuItem(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "updateMenuItem endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getMenuItemById(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getMenuItemById endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllMenuItems() {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getAllMenuItems endpoint funcional");
        return ResponseEntity.ok(res);
    }
}
