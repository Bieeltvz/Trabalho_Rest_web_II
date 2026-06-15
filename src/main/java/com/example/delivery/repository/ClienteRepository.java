package com.example.delivery.repository;

import com.example.delivery.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	// Repositório JPA para Cliente (CRUD pronto via Spring Data)
}
