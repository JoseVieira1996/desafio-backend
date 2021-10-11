# Desafio Back-End

Desafio para os candidatos à vaga de back-end na [TradeMap](https://www.linkedin.com/company/trademaphub).

## Tecnologias utilizadas
O projeto foi desenvolvido seguindo o padrão DTO, tendo as tecnologias abaixo sendo utilizadas no inicio ou no fim do projeto.

- Java
- Postgres
- Banco de Dados H2
- Heroku
- Docker

## Solução
A solução foi implementada com Spring Boot, hospedada no Heroku e está disponível no DockerHub josevieira1996/desafio:

A imagem está em: josevieira1996/desafio:v1

Pode ser executada por:

docker run -p 80:8080 --name desafio-heroku -e APP_PROFILE=dev -e DB_URL=jdbc:postgresql://ec2-18-214-214-252.compute-1.amazonaws.com:5432/d6dkat9g6e9app -e DB_USERNAME=qmordbyigmzdpp -e DB_PASSWORD=38e533217356ea36f825d63b0652404b59846b6b1eb7681700583469285baec7 desafio:v1


## Endpoints
Existem 6 endpoints que estão disponíveis para download abaixo. As requisições devem ser descompactadas e importadas no Postman:

[LINK PARA DOWNLOAD] https://drive.google.com/file/d/1syJqnnlafYbx7CGqj8AogAOvqcPwlpK6/view?usp=sharing

GET http://localhost:80/posts :retorna todos os post de forma paginada;

GET http://localhost:80/posts/{id}: mostra um post especifico;

GET http://localhost:80/posts?page=0&linesPerPage=10&direction=ASC&orderBy=createdAt: retorna uma lista de posts ordenada por data

POST http://localhost:80/posts : insere um novo post

PUT http://localhost:80/{id} : atualiza um  post

DELETE http://localhost:80/{id} : exclui um  post

## Considerações finais

A aplicação já está vinculada ao Postgres, mas ainda em modo de DEV. Sendo assim, para visualização das mudanças ocorridas e salvas no atributo "updatedAt", sugiro iniciar a aplicação na IDE de sua preferência e acessar o banco de dados H2 em http://localhost:8080/h2-console. Os dados de login e senha estão em "application-test.properties". A porta para acessar o H2 deve ser modificada para 8080, mantendo o restante das informações do endpoint:

Exemplo:

POST http://localhost:80/posts - POSTGRES

POST http://localhost:8080/posts - H2


