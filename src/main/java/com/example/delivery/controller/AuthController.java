package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller para endpoints de autenticação.
 * Conforme solicitado no enunciado, o sistema deve permitir cadastrar e
 * fazer login sem autenticação — aqui apenas confirmamos que os endpoints
 * estão funcionais. Não implementamos autenticação real; isso foi solicitado
 * pelo usuário: "faça somente com os endpoints retornando que o endpoint esta funcional".
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    // Registrar novo usuário (pode ser chamado sem autenticação)
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register() {
        return ResponseEntity.ok(Map.of("message", "register endpoint funcional"));
    }

    // Login (retorna mensagem informando que endpoint funciona)
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login() {
        // Aqui normalmente geraríamos um token JWT; por agora apenas confirmamos funcionalidade
        return ResponseEntity.ok(Map.of("message", "login endpoint funcional", "token", "dummy-token"));
    }
}
