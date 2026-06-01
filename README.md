Projeto de exemplo: Web Service REST mínimo para sistema de restaurante e delivery

Objetivo:
- Implementar endpoints REST que retornem apenas mensagens indicando que estão funcionais.

Como rodar:
1. Tenha JDK 8 (ou superior) e Maven instalados. Este projeto foi ajustado para
  ser compatível com Java 8 (Spring Boot 2.7.x).
2. Na raiz do projeto execute:

```powershell
# Se você não tem Maven instalado, instale ou use o wrapper. Se tiver Chocolatey:
choco install maven -y
refreshenv
mvn spring-boot:run
```

Endpoints (exemplos):
- POST /auth/register
- POST /auth/login
- POST /users
- GET /users
- POST /restaurants
- GET /restaurants
- POST /menu-items
- GET /menu-items
- POST /orders
- GET /orders
- POST /deliveries
- GET /deliveries

Todos retornam JSON com a chave "message" informando que o endpoint está funcional.

Comentários:
- O usuário solicitou que apenas os endpoints retornem confirmação de funcionamento
  e que não seja implementada persistência ou autenticação real. O código está
  totalmente comentado em português nos controllers.
# Trabalho_Rest_web_II

