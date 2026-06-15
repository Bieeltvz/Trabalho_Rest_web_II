CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(255)
);

CREATE TABLE categoria (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE produto (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(10,2) NOT NULL,
    categoria_id BIGINT NOT NULL,

    CONSTRAINT fk_produto_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria(id)
);

CREATE TABLE pedido (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    valor_total DECIMAL(10,2),
    cliente_id BIGINT NOT NULL,

    CONSTRAINT fk_pedido_cliente
        FOREIGN KEY (cliente_id)
        REFERENCES cliente(id)
);

CREATE TABLE pedido_produto (
    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,

    PRIMARY KEY (pedido_id, produto_id),

    CONSTRAINT fk_pp_pedido
        FOREIGN KEY (pedido_id)
        REFERENCES pedido(id),

    CONSTRAINT fk_pp_produto
        FOREIGN KEY (produto_id)
        REFERENCES produto(id)
);