package com.example.delivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    /**
     * Entidade que representa um usuário do sistema.
     * Campos:
     * - `id`: chave primária gerada pelo banco.
     * - `nome`: nome completo do usuário.
     * - `login`: identificador de login único.
     * - `senha`: senha em texto (atualmente armazenada em texto claro).
     *
     * Observação: manter simples para testes; trocar armazenamento de
     * senha por hash (BCrypt) antes de levar para produção.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
