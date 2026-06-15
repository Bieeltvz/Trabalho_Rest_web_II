package com.example.delivery.controller;

import com.example.delivery.model.Usuario;
import com.example.delivery.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller responsável por autenticação mínima do sistema.
 *
 * Explicação resumida:
 * - `/auth/register` recebe um JSON com os dados do usuário e salva
 *   a entidade `Usuario` no banco via `UsuarioRepository`.
 * - `/auth/login` recebe `{login, senha}`, procura o usuário por login
 *   e compara a senha em texto claro (método de exemplo, inseguro).
 *
 * Observações de implementação (para desenvolvedores):
 * - Aqui usamos comparação direta de senha apenas para facilitar testes.
 *   Em um ambiente real, substituir por hashing (BCrypt) e validação.
 * - O token retornado é sintético ("dummy-token"); trocar por JWT
 *   ou outro provedor de tokens quando for necessário autenticação real.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registrar novo usuário: salva a entidade `Usuario` no banco.
    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        // salva a entidade e retorna o objeto persistido (com id preenchido)
        Usuario saved = usuarioRepository.save(usuario);
        return ResponseEntity.ok(saved);
    }

    // Login simples: verifica login + senha em texto claro.
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String login = body.get("login");
        String senha = body.get("senha");
        if (login == null || senha == null) return ResponseEntity.badRequest().body("login e senha são obrigatórios");
        // busca o usuário e compara a senha em texto (exemplo)
        return usuarioRepository.findByLogin(login).map(u -> {
            if (senha.equals(u.getSenha())) {
                Map<String, String> res = new HashMap<>();
                res.put("message", "autenticado");
                // token fictício — substituir por geração real de token/JWT
                res.put("token", "dummy-token");
                return ResponseEntity.ok(res);
            } else {
                return ResponseEntity.status(401).body("credenciais inválidas");
            }
        }).orElseGet(() -> ResponseEntity.status(401).body("credenciais inválidas"));
    }
}
