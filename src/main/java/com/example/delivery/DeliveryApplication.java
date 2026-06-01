package com.example.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 * Ao executar, o Spring inicializa o container e expõe os endpoints definidos
 * nos controllers abaixo.
 */
@SpringBootApplication
public class DeliveryApplication {

    /**
     * Ponto de entrada da aplicação.
     * Executar esta main sobe a API REST mínima.
     */
    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }
}
