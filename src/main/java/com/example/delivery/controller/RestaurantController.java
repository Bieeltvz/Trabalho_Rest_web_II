package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller para recursos de Restaurante.
 * Implementa os endpoints REST solicitados no enunciado, porém
 * apenas retornam mensagens informando que o endpoint está funcional.
 *
 * Observação: neste projeto não existe uma entidade `Restaurante`/`Restaurant`
 * mapeada com JPA. Portanto não há repositório para vincular aqui —
 * os endpoints atuam como stubs funcionais que demonstram o contrato HTTP.
 * Comentários foram escritos no estilo de um desenvolvedor para facilitar leitura.
 */
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    // Insert - criar novo restaurante
    @PostMapping
    public ResponseEntity<Map<String, String>> createRestaurant() {
        Map<String, String> res = new HashMap<>();
        res.put("message", "createRestaurant endpoint funcional");
        return ResponseEntity.ok(res);
    }

    // Delete - remover restaurante por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteRestaurant(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "deleteRestaurant endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    // Update - atualizar restaurante por id
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateRestaurant(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "updateRestaurant endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    // Select by id - buscar restaurante por id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getRestaurantById(@PathVariable String id) {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getRestaurantById endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    // Select all - listar todos os restaurantes
    @GetMapping
    public ResponseEntity<Map<String, String>> getAllRestaurants() {
        Map<String, String> res = new HashMap<>();
        res.put("message", "getAllRestaurants endpoint funcional");
        return ResponseEntity.ok(res);
    }
}
