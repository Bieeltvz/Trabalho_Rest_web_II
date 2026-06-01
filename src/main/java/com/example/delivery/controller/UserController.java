package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller para gerenciar usuários do sistema.
 * O enunciado pede CRUD de usuário; aqui apenas confirmamos endpoints.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<Map<String, String>> createUser() {
        Map<String, String> res = new HashMap<>();
        res.put("message", "createUser endpoint funcional");
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "deleteUser endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "updateUser endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getUserById(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getUserById endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllUsers() {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getAllUsers endpoint funcional");
        return ResponseEntity.ok(res);
    }
}
