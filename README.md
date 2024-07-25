# Blog API

Java RESTful API criada para o bootcamp Santander 2024 - Backend com Java

## Table of contents

- [Visão geral](#visão-geral)
- [A applicação](#a-aplicação)
  - [Diagrama](#diagrama-preliminar) 
  - [Endpoints](#endpoints)
  - [Links](#links)
- [Meu desenvolvimento](#meu-desenvolvimento)
  - [Ferramentas utilizadas](#built-with)
  - [O que aprendi](#o-que-aprendi)
  - [Próximos passos](#próximos-passos)
  - [Recursos úteis](#recursos-úteis)
- [Autor](#autor)


## Visão geral

Essa aplicação foi construída com o simples propósito de servir como uma
API base para um blog de propósito comum.

## A aplicação

Esta aplicação Java RESTful API foi criada como projeto final do bootcamp Santander 2024 - Backend com Java
com o intuito de consolidar os tópicos estudados durante o curso.

### Diagrama preliminar



### Endpoints

Retornar todos os autores
- URL: /authors
- Method: GET
- Response: CODE 200
````
[
  {
    "id": 1,
    "name": "Felipe",
    "bio": "String",
    "posts": [
      {
        "id": 1,
        "title": "String",
        "description": "String",
        "body": "String",
        "date": "2023-07-15",
        "categories": [
          {"category1": "string"},
          {"category2": "string"}
        ]
      }
    ]
  }
]
````

Retornar um autor
- URL: /authors/author/{id}
- Method: GET
- Response: CODE 200
````
{
  "id": 1,
  "name": "Felipe",
  "bio": "String",
  "posts": [
    {
      "id": 1,
      "title": "String",
      "description": "String",
      "body": "String",
      "date": "2023-07-15",
      "categories": [
        {"category1": "string"},
        {"category2": "string"}
      ]
    }
  ]
}
````

Retornar todos os posts
- URL: /posts
- Method: GET
- Response: CODE 200
````
[
  {
    "id": 1,
    "title": "string",
    "description": "string",
    "content": "string",
    "postDate": "2024-07-23",
    "featured": true,
    "categories": [
      "NEWS"
    ]
  },
  
    {
    "id": 2,
    "title": "string",
    "description": "string",
    "content": "string",
    "postDate": "2024-07-23",
    "featured": false,
    "categories": [
      "TECH"
    ]
  }
]
````

Retornar um post
- URL: /posts/post/{id}
- Method: GET
- Response: CODE 200
````
{
    "id": 1,
    "title": "string",
    "description": "string",
    "content": "string",
    "postDate": "2024-07-23",
    "featured": true,
    "categories": [
      "NEWS"
    ]
}
````

Retornar um post pelo título
- URL: /posts/post/title/{title}
- Method: GET
- Response: CODE 200
````
{
    "id": 1,
    "title": "string",
    "description": "string",
    "content": "string",
    "postDate": "2024-07-23",
    "featured": true,
    "categories": [
      "NEWS"
    ]
}
````

Adicionar um autor
- URL: /authors
- Method: POST
- Request Body:
````
{
  "name": "string",
  "email": "string",
  "bio": "string"
}
````
- Response:
````
{
  "id": 1,
  "name": "string",
  "email": "string",
  "bio": "string",
  "posts": [],
  "featuredPosts": []
}
````

Adicionar um post
- URL: /posts
- Method: POST
- Request Body:
````
{
  "title": "string",
  "description": "string",
  "content": "string",
  "featured": true,
  "categories": [
    "NEWS"
  ],
  "author": {
    "id": 1

  }
}
````
- Response: CODE 201
````
{
  "id": 1,
  "title": "string",
  "description": "string",
  "content": "string",
  "postDate": "2024-07-23",
  "featured": true,
  "categories": [
    "NEWS"
  ]
}
````

Atualizar um autor
- URL: /authors/author/{id}
- Method: PUT
- Request Body:
````
{
  "name": "string",
  "email": "string",
  "bio": "string"
}
````
- Response: CODE 200
````
{
  "id": 1,
  "name": "string",
  "email": "string",
  "bio": "string",
  "posts": [],
  "featuredPosts": []
}
````

Atualizar um post
- URL: /posts/post/{id}
- Method: PUT
- Request Body:
````
{
  "title": "string",
  "description": "string",
  "content": "string"
}
````
- Response: CODE 200
````
{
  "title": "string",
  "description": "string",
  "content": "string"
}
````

Destacar um post
- URL: /posts/post/feature/{id}
- - Method: PUT
- Request Body:

````
true
````
- Response: CODE 200
````
POST FEATURED!
````

Deletar um autor

- URL: /authors/author/{id}
- Method: DELETE
- Response: CODE 200
````
DELETED AUTHOR WITH ID: 1
````

Deletar um post

- URL: /authors/author/{id}
- Method: DELETE
- Response: CODE 200
````
POST DELETED ID:3
````
### Respostas de erro

Autor não encontrado

- URL: /authors/author/{id}
- Method: GET-PUT-DELETE
- - Response: CODE 404
````
{
  "timestamp": "2024-07-25T18:27:52.347033Z",
  "status": 404,
  "error": "Resource not found",
  "message": "RECURSO NÃO ENCONTRADO. ID: 1",
  "path": "/author/author/1"
}
````

Post não encontrado

- URL: /posts/post/{id}
- Method: GET-PUT-DELETE
- Response: CODE 404
````
{
  "timestamp": "2024-07-25T18:27:52.347033Z",
  "status": 404,
  "error": "Resource not found",
  "message": "RECURSO NÃO ENCONTRADO. ID: 1",
  "path": "/posts/post/1"
}
````
Campo vazio ou nulo ao adicionar autor

- URL: /authors/author
- Method: POST
- Response: CODE 400

Response body - campo nome:
````
{
  "timestamp": "2024-07-25T18:51:34.672816300Z",
  "status": 400,
  "error": "Illegal argument",
  "message": "Author must have a name!",
  "path": "/authors/author"
}

````

Response body - campo email:
````
{
  "timestamp": "2024-07-25T18:51:34.672816300Z",
  "status": 400,
  "error": "Illegal argument",
  "message": "Author must have a email!",
  "path": "/authors/author"
}
````


Campo vazio ou nulo ao adicionar post

- URL: /posts/post
- Method: POST
- Response: CODE 400

Campo título

Response body:
````
{
  "timestamp": "2024-07-25T18:55:39.595545600Z",
  "status": 400,
  "error": "Illegal argument",
  "message": "Posts must have a title!",
  "path": "/posts/post"
}

````
Campo descrição

Response body: 
````
{
  "timestamp": "2024-07-25T18:57:14.281734700Z",
  "status": 400,
  "error": "Illegal argument",
  "message": "Posts must have a description!",
  "path": "/posts/post"
}
````
Campo conteúdo

Response body:
````
{
  "timestamp": "2024-07-25T18:57:51.325249600Z",
  "status": 400,
  "error": "Illegal argument",
  "message": "Posts must have content!",
  "path": "/posts/post"
}
````
Id do autor é nulo

Response body: 

````
{
  "timestamp": "2024-07-25T19:01:19.510071500Z",
  "status": 400,
  "error": "Illegal argument",
  "message": "The given id must not be null",
  "path": "/posts/post"
}
````
Sem referência do autor no corpo de requisição

Response body: 

````
{
  "timestamp": "2024-07-25T19:08:04.958+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/posts/post"
}
````


Id do autor é inexistente no banco de dados

CODE 404

Response body:

````
{
  "timestamp": "2024-07-25T19:02:16.548193700Z",
  "status": 404,
  "error": "Resource not found",
  "message": "RECURSO NÃO ENCONTRADO. ID: 10",
  "path": "/posts/post"
}
````

### Links


- URL do swagger/docapi: [projeto-final-blog-api-prd.up.railway.app/swagger-ui](https://projeto-final-blog-api-prd.up.railway.app/swagger-ui/index.html)
- URL raiz: [projeto-final-blog-api-prd.up.railway.app](https://projeto-final-blog-api-prd.up.railway.app/)

## Meu desenvolvimento

### Desenvolvido com

- Java 17
- Spring Boot 3
- Spring Data JPA
- OpenAPI (Swagger)
- Railway
- Postgresql


### O que aprendi

Além de revisar muitos conceitos de orientação a objeto, recursos do framework spring
e outros específicos a linguagem Java, acredito que meus aprendizados com este projeto giraram em torno do deploy em si
e também na configuração de perfis específicos de execução da aplicação 
utilizando yaml.


### Próximos passos

Acredito que para as próximas atualizações dessa API podemos esperar
a adição de uma camada de segurança, permitindo com que os autores ter um login utilizando
uma token JWT e com isso, tivessem acesso irrestrito as suas próprias postagens 
mas acesso limitado as postagens de outros autores.

### Recursos úteis

- [Documentação do springboot](https://docs.spring.io/spring-boot/documentation.html)
- [Documentação do OpenAPI](https://springdoc.org/)
- [Documentação do Railway](https://docs.railway.app/)

## Autor

- Website(Webflow) - [Felipe Dias](https://diass-blog.webflow.io)
- LinkedIn - [Felipe Dias](https://www.linkedin.com/in/felipe-dsprado/)

