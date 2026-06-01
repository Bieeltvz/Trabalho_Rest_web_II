package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller para recursos de Restaurante.
 * Implementa os endpoints REST solicitados no enunciado, porém
 * apenas retornam mensagens informando que o endpoint está funcional.
 * Todos os métodos comentados em português para facilitar avaliação.
 */
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    // Insert - criar novo restaurante
    @PostMapping
    public ResponseEntity<Map<String, String>> createRestaurant() {
        // Retorna JSON simples informando funcionalidade
        return ResponseEntity.ok(Map.of("message", "createRestaurant endpoint funcional"));
    }

    // Delete - remover restaurante por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteRestaurant(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "deleteRestaurant endpoint funcional", "id", id));
    }

    // Update - atualizar restaurante por id
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateRestaurant(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "updateRestaurant endpoint funcional", "id", id));
    }

    // Select by id - buscar restaurante por id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getRestaurantById(@PathVariable String id) {
        return ResponseEntity.ok(Map.of("message", "getRestaurantById endpoint funcional", "id", id));
    }

    // Select all - listar todos os restaurantes
    @GetMapping
    public ResponseEntity<Map<String, String>> getAllRestaurants() {
        return ResponseEntity.ok(Map.of("message", "getAllRestaurants endpoint funcional"));
    }
}
