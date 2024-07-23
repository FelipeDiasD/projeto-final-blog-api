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
- URL: /authors/{id}
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

### Links


- URL do deploy: [URL para teste com swagger](https://projeto-final-blog-api-prd.up.railway.app/swagger-ui/index.html)

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


### Recursos úteis

- [Documentação do springboot]()
- [Documentação do OpenAPI]()
- [Documentação do Railway]()
- 
## Autor

- Website(Webflow) - [Felipe Dias](https://diass-blog.webflow.io)
- LinkedIn - [Felipe Dias](https://www.linkedin.com/in/felipe-dsprado/)

