package com.example.delivery.controller;

import com.example.delivery.model.Usuario;
import com.example.delivery.repository.UsuarioRepository;
import com.example.delivery.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    // Registrar novo usuário: salva a entidade `Usuario` no banco.
    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        // Antes de salvar, codifica a senha com BCrypt para segurança
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario saved = usuarioRepository.save(usuario);
        return ResponseEntity.ok(saved);
    }

    // Login simples: verifica login + senha em texto claro.
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String login = body.get("login");
        String senha = body.get("senha");
        if (login == null || senha == null) return ResponseEntity.badRequest().body("login e senha são obrigatórios");
        // Autentica usando AuthenticationManager; em caso de sucesso gera JWT
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, senha));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body("credenciais inválidas");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        String token = jwtUtil.generateToken(userDetails);
        Map<String, String> res = new HashMap<>();
        res.put("message", "autenticado");
        res.put("token", token);
        return ResponseEntity.ok(res);
    }
}
