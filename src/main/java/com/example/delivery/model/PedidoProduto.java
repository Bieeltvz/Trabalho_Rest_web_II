package com.example.delivery.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto {

    /**
     * Entidade de junção entre Pedido e Produto (itens do pedido).
     * - `id`: chave composta embutida (`PedidoProdutoId`).
     * - `pedido`, `produto`: relacionamentos ManyToOne com mapeamento de IDs.
     * - `quantidade`, `subtotal`: detalhes da linha do pedido.
     */

    @EmbeddedId
    private PedidoProdutoId id;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;
    private BigDecimal subtotal;

    public PedidoProdutoId getId() {
        return id;
    }

    public void setId(PedidoProdutoId id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
