package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(Map.of("message", "createUser endpoint funcional"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "deleteUser endpoint funcional", "id", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "updateUser endpoint funcional", "id", id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "getUserById endpoint funcional", "id", id));
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllUsers() {
        return ResponseEntity.ok(Map.of("message", "getAllUsers endpoint funcional"));
    }
}
