package com.example.delivery.repository;

import com.example.delivery.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// Repositório JPA padrão para a entidade Produto (CRUD automático pelo Spring Data)
}
