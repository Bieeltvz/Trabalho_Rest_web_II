package com.example.delivery.repository;

import com.example.delivery.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	// Repositório para Categoria, usado para validar/associar produtos.
}
