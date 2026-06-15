package com.example.delivery.controller;

import com.example.delivery.model.Usuario;
import com.example.delivery.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller para gerenciar usuários do sistema.
 * Alterado para usar JPA: injeta `UsuarioRepository` e realiza operações reais
 * no banco de dados (CRUD). Comentários em português explicam as mudanças.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    // Injeção do repositório JPA que mapeia a entidade `Usuario`.
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Create: salva um novo usuário recebido no corpo da requisição
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        Usuario saved = usuarioRepository.save(usuario);
        return ResponseEntity.ok(saved);
    }

    // Delete: remove por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update: atualiza o usuário (substituição simples)
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> existing = usuarioRepository.findById(id);
        if (!existing.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuario saved = usuarioRepository.save(usuario);
        return ResponseEntity.ok(saved);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        return usuarioRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
}
