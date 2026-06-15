package com.example.delivery.repository;

import com.example.delivery.model.PedidoProduto;
import com.example.delivery.model.PedidoProdutoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, PedidoProdutoId> {
	// Repositório para entidade de junção PedidoProduto (chave composta)
}
