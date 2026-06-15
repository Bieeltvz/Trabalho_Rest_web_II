package com.example.delivery;

import com.example.delivery.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbChecker implements CommandLineRunner {

    // Componente simples que roda na inicialização para conferir contagem de usuários.
    // Útil para debug rápido: confirma se a conexão com o repositório está funcionando.
    private final UsuarioRepository usuarioRepository;

    public DbChecker(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // imprime a quantidade de usuários no banco (pode ser 0 ou >0 quando DataInitializer roda)
        long count = usuarioRepository.count();
        System.out.println("[DbChecker] usuario.count() = " + count);
    }
}
