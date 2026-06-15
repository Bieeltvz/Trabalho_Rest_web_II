package com.example.delivery.repository;

import com.example.delivery.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	/**
	 * Repositório JPA para a entidade Usuario.
	 * Inclui método auxiliar para localizar usuário por `login`.
	 */
	java.util.Optional<Usuario> findByLogin(String login);
}
