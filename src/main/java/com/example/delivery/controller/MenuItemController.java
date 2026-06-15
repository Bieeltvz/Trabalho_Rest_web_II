package com.example.delivery.controller;

import com.example.delivery.model.Produto;
import com.example.delivery.model.Categoria;
import com.example.delivery.repository.CategoriaRepository;
import com.example.delivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller para itens de menu (produtos).
 * Modificado para usar `ProdutoRepository` e `CategoriaRepository` e
 * realizar operações reais no banco de dados.
 */
@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Create: espera um JSON de `Produto`. Deve conter `categoria.id` para associar.
    @PostMapping
    public ResponseEntity<?> createMenuItem(@RequestBody Produto produto) {
        if (produto.getCategoria() == null || produto.getCategoria().getId() == null) {
            return ResponseEntity.badRequest().body("categoria.id é obrigatória");
        }
        Optional<Categoria> cat = categoriaRepository.findById(produto.getCategoria().getId());
        if (!cat.isPresent()) {
            return ResponseEntity.badRequest().body("categoria.id inválida");
        }
        produto.setCategoria(cat.get());
        Produto saved = produtoRepository.save(produto);
        return ResponseEntity.ok(saved);
    }

    // Delete por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update: similar ao create, valida categoria quando fornecida
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMenuItem(@PathVariable Long id, @RequestBody Produto produto) {
        Optional<Produto> existing = produtoRepository.findById(id);
        if (!existing.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (produto.getCategoria() != null && produto.getCategoria().getId() != null) {
            Optional<Categoria> cat = categoriaRepository.findById(produto.getCategoria().getId());
            if (!cat.isPresent()) return ResponseEntity.badRequest().body("categoria.id inválida");
            produto.setCategoria(cat.get());
        } else {
            // manter categoria atual se não for informada
            produto.setCategoria(existing.get().getCategoria());
        }
        produto.setId(id);
        Produto saved = produtoRepository.save(produto);
        return ResponseEntity.ok(saved);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getMenuItemById(@PathVariable Long id) {
        return produtoRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<Produto>> getAllMenuItems() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }
}
