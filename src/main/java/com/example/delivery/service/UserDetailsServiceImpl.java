package com.example.delivery.service;

import com.example.delivery.model.Usuario;
import com.example.delivery.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementação de `UserDetailsService` que carrega `Usuario` do banco
 * e o converte para `UserDetails` usado pelo Spring Security.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        // Converter para UserDetails. A senha aqui deve ser o hash (BCrypt).
        return User.builder()
                .username(u.getLogin())
                .password(u.getSenha())
                .roles("USER")
                .build();
    }
}
