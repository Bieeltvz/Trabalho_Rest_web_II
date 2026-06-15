Projeto: Delivery / Restaurante (API REST mínima)

Descrição
- Aplicação Spring Boot com endpoints para gerenciamento de usuários, produtos
  (menu items), pedidos, clientes e entregas. Alguns controllers são stubs
  (sem persistência) quando não há entidade JPA correspondente.

Pré-requisitos
- Java 8 instalado (JDK 1.8)
- Maven instalado
- MariaDB ou MySQL rodando localmente com um schema disponível (ex.: `teste`)

Configurar o banco de dados
1. Crie o banco (exemplo com MariaDB):

```sql
CREATE DATABASE teste CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. Verifique `src/main/resources/application.properties` e ajuste se necessário.
   Por padrão o projeto usa:

```
spring.datasource.url=jdbc:mariadb://localhost:3306/teste
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
server.port=9090
```

Se o seu banco usa usuário/senha diferentes, altere as propriedades acima.

Como compilar e rodar
1. Na raiz do projeto (onde está o `pom.xml`) execute:

```powershell
mvn -DskipTests clean package
mvn -DskipTests spring-boot:run
```

2. A aplicação vai subir por padrão na porta `9090` (conforme `application.properties`).

Endpoints úteis para teste (exemplos)
- `POST /auth/register` - registra usuário (body JSON: {"nome","login","senha"})
- `POST /auth/login` - autentica (body JSON: {"login","senha"})
- `GET /users` - lista usuários
- `POST /menu-items` - cria produto (body inclui `categoria.id`)
- `GET /menu-items` - lista produtos
- `POST /orders` - cria pedido com `cliente.id` e lista de itens

Sugestões de verificação
- Após o primeiro start a classe `DataInitializer` popula o BD com 5 registros
  em cada tabela (usuarios, clientes, categorias, produtos, pedidos) se as
  tabelas estiverem vazias.
- Logs mostram consultas de exemplo e contagens no startup.

Problemas comuns
- Erro UnsupportedClassVersionError: significa que o código foi compilado para
  uma versão de Java superior à que está instalada. Este projeto está
  configurado para target Java 8 no `pom.xml`.
- Porta ocupada: ajustar `server.port` em `application.properties` ou liberar a porta.

Contato
- Se precisar, posso gerar uma coleção Postman com as requisições mais usadas.

# Trabalho_Rest_web_II

