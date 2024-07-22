# Service Record app

Uma aplicação para registrar serviços de TI


## Table of contents

- [Visão geral](#visão-geral)
  - [A applicação](#a-aplicação)
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

### A aplicação

Esta aplicação Java RESTful API foi criada como projeto final do bootcamp Santander 2024 - Backend com Java
com o intuito de consolidar os tópicos estudados durante o curso.

#### Endpoints

Retornar todos os autores
- URL: /authors
- Method: GET
- Response:
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
- URL: /authors/author/id
- Method: GET
- Response:
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
#### Diagrama preliminar


### Links


- URL do deploy: [swagger](https://projeto-final-blog-api-prd.up.railway.app)

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
- [Documentação do Railay]()
- 
## Autor

- Website(Webflow) - [Felipe Dias](https://diass-blog.webflow.io)
- LinkedIn - [Felipe Dias](https://www.linkedin.com/in/felipe-dsprado/)
