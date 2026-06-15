package com.example.delivery;

import com.example.delivery.model.*;
import com.example.delivery.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    /*
     * Classe responsável por popular o banco com dados de exemplo ao iniciar a aplicação.
     * Comportamento:
     * - Executa apenas se as tabelas estiverem vazias (verifica contagens).
     * - Insere 5 registros para usuários, clientes, categorias, produtos e pedidos.
     * - Cria alguns itens em `pedido_produto` e atualiza o valor total dos pedidos.
     * - Ao final, imprime consultas/contagens exemplo para facilitar testes manuais.
     */

    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;
    private final PedidoProdutoRepository pedidoProdutoRepository;

    public DataInitializer(UsuarioRepository usuarioRepository,
                           ClienteRepository clienteRepository,
                           CategoriaRepository categoriaRepository,
                           ProdutoRepository produtoRepository,
                           PedidoRepository pedidoRepository,
                           PedidoProdutoRepository pedidoProdutoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
        this.pedidoProdutoRepository = pedidoProdutoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Apenas popula se vazio: evita duplicar dados a cada inicialização
        if (usuarioRepository.count() == 0) {
            List<Usuario> usuarios = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Usuario u = new Usuario();
                u.setNome("Usuario " + i);
                u.setLogin("user" + i);
                u.setSenha("senha" + i);
                usuarios.add(u);
            }
            usuarioRepository.saveAll(usuarios);
            System.out.println("[DataInitializer] Inseridos 5 usuarios");
        }

        if (clienteRepository.count() == 0) {
            List<Cliente> clientes = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Cliente c = new Cliente();
                c.setNome("Cliente " + i);
                c.setTelefone("9999-000" + i);
                c.setEndereco("Rua Exemplo, " + i);
                clientes.add(c);
            }
            clienteRepository.saveAll(clientes);
            System.out.println("[DataInitializer] Inseridos 5 clientes");
        }

        if (categoriaRepository.count() == 0) {
            List<Categoria> categorias = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Categoria cat = new Categoria();
                cat.setNome("Categoria " + i);
                categorias.add(cat);
            }
            categoriaRepository.saveAll(categorias);
            System.out.println("[DataInitializer] Inseridas 5 categorias");
        }

        if (produtoRepository.count() == 0) {
            List<Categoria> categorias = categoriaRepository.findAll();
            List<Produto> produtos = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Produto p = new Produto();
                p.setNome("Produto " + i);
                p.setDescricao("Descricao do produto " + i);
                p.setPreco(new BigDecimal(10 * i));
                p.setCategoria(categorias.get((i - 1) % categorias.size()));
                produtos.add(p);
            }
            produtoRepository.saveAll(produtos);
            System.out.println("[DataInitializer] Inseridos 5 produtos");
        }

        if (pedidoRepository.count() == 0) {
            List<Cliente> clientes = clienteRepository.findAll();
            List<Produto> produtos = produtoRepository.findAll();

            List<Pedido> pedidos = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Pedido ped = new Pedido();
                ped.setDataPedido(LocalDateTime.now());
                ped.setStatus("NOVO");
                ped.setValorTotal(BigDecimal.ZERO);
                ped.setCliente(clientes.get((i - 1) % clientes.size()));
                pedidos.add(ped);
            }
            // salva pedidos sem itens inicialmente
            pedidoRepository.saveAll(pedidos);
            System.out.println("[DataInitializer] Inseridos 5 pedidos (sem itens)");

            // Criar alguns itens para cada pedido
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido ped = pedidos.get(i);
                // adicionar 1 a 3 itens para cada pedido e calcular subtotal
                int itens = 1 + (i % 3);
                BigDecimal total = BigDecimal.ZERO;
                for (int j = 0; j < itens; j++) {
                    Produto prod = produtos.get((i + j) % produtos.size());
                    PedidoProduto pp = new PedidoProduto();
                    PedidoProdutoId id = new PedidoProdutoId(ped.getId(), prod.getId());
                    pp.setId(id);
                    pp.setPedido(ped);
                    pp.setProduto(prod);
                    pp.setQuantidade(1 + j);
                    BigDecimal subtotal = prod.getPreco().multiply(new BigDecimal(pp.getQuantidade()));
                    pp.setSubtotal(subtotal);
                    pedidoProdutoRepository.save(pp);
                    total = total.add(subtotal);
                }
                ped.setValorTotal(total);
                pedidoRepository.save(ped);
            }
            System.out.println("[DataInitializer] Adicionados itens para pedidos e atualizados valores");
        }

        // Consultas de exemplo
        // Imprime contagens e exemplos para facilitar verificação manual
        System.out.println("[Example Query] total usuarios = " + usuarioRepository.count());
        System.out.println("[Example Query] total clientes = " + clienteRepository.count());
        System.out.println("[Example Query] total categorias = " + categoriaRepository.count());
        System.out.println("[Example Query] total produtos = " + produtoRepository.count());
        System.out.println("[Example Query] total pedidos = " + pedidoRepository.count());
        System.out.println("[Example Query] total pedido_produto = " + pedidoProdutoRepository.count());

        // Listar 3 primeiros produtos
        List<Produto> top3 = produtoRepository.findAll().subList(0, Math.min(3, (int) produtoRepository.count()));
        System.out.println("[Example Query] Top produtos:");
        for (Produto p : top3) {
            System.out.println(" - " + p.getNome() + " (" + p.getPreco() + ") categoria=" + p.getCategoria().getNome());
        }

        // Mostrar pedidos e itens
        System.out.println("[Example Query] Pedidos com itens:");
        List<Pedido> pedidosAll = pedidoRepository.findAll();
        for (Pedido ped : pedidosAll) {
            System.out.println("Pedido " + ped.getId() + " cliente=" + ped.getCliente().getNome() + " valorTotal=" + ped.getValorTotal());
            List<PedidoProduto> itens = pedidoProdutoRepository.findAll();
            for (PedidoProduto it : itens) {
                if (it.getPedido().getId().equals(ped.getId())) {
                    System.out.println("   item: " + it.getProduto().getNome() + " q=" + it.getQuantidade() + " subtotal=" + it.getSubtotal());
                }
            }
        }
    }
}
