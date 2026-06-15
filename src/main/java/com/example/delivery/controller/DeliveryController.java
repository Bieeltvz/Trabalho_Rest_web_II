package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller para operações relacionadas a entregas.
 *
 * Detalhes:
 * - Os métodos abaixo são stubs que retornam respostas de exemplo.
 * - Não existe uma entidade JPA `Delivery` no projeto atualmente,
 *   então não há persistência real aqui — apenas rota/contrato HTTP.
 * - Se for necessário persistir entregas, criar entidade, repositório
 *   e ajustar os métodos para usar JPA/Hibernate.
 */
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @PostMapping
    public ResponseEntity<Map<String, String>> createDelivery() {
        // Exemplo: responder que endpoint funciona. Em implementação real,
        // aqui receberíamos um DTO e salvaríamos a entidade no banco.
        Map<String, String> res = new HashMap<>();
        res.put("message", "createDelivery endpoint funcional");
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDelivery(@PathVariable String id) {
        // Exemplo: receber um id e retornar confirmação. Em versão real,
        // validaríamos existência e removeríamos do repositório.
        Map<String, String> res = new HashMap<>();
        res.put("message", "deleteDelivery endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDelivery(@PathVariable String id) {
        // Exemplo: atualizar um recurso identificado por id. Normalmente
        // receberíamos um corpo com os campos a atualizar.
        Map<String, String> res = new HashMap<>();
        res.put("message", "updateDelivery endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getDeliveryById(@PathVariable String id) {
        // Exemplo: retornar representação do recurso. Aqui apenas devolvemos
        // um mapa com mensagem e id para demonstrar rota funcional.
        Map<String, String> res = new HashMap<>();
        res.put("message", "getDeliveryById endpoint funcional");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllDeliveries() {
        // Exemplo: retornar lista. Aqui apenas confirmamos que rota existe.
        Map<String, String> res = new HashMap<>();
        res.put("message", "getAllDeliveries endpoint funcional");
        return ResponseEntity.ok(res);
    }
}
