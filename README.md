# Projeto Hero - API de Cadastro de Heróis

Projeto desenvolvido como parte de um processo seletivo técnico, com foco em demonstrar domínio na construção 
de uma API RESTful utilizando **Spring Boot** e boas práticas de desenvolvimento backend.

## Funcionalidades

- API REST com operações completas de CRUD (Create, Read, Update, Delete)
- Integração com banco de dados via **Flyway** (migração automatizada)
- Uso de **DTOs (Data Transfer Objects)** para encapsulamento de dados
- Documentação automática com **Swagger UI**
- Configuração de **CORS** para consumo seguro por aplicações frontend
- Respostas estruturadas com HATEOAS (links de navegação RESTful)

## Como usar

1. Execute o script:

CREATE SCHEMA project-hero;

2. Rode o projeto. O **Flyway** se encarrega automaticamente de:

- Criar as tabelas
- Popular os dados iniciais

3. Com a API no ar (`http://localhost:8080`), você pode:

- Utilizar um frontend Angular para interagir com os endpoints
- Ou testar diretamente via ferramentas como **Postman**, **Insomnia**, etc.

## Documentação da API

A documentação gerada automaticamente com Swagger está disponível em:

http://localhost:8080/swagger-ui.html

Ou (dependendo da lib):

http://localhost:8080/swagger-ui/index.html

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Flyway
- Swagger (Springfox ou SpringDoc)
- H2/PostgreSQL/MySQL (configurável)
- Maven

## Objetivo

Este projeto tem como foco demonstrar:

- Estrutura limpa e modular de uma API RESTful
- Boas práticas em organização de código e separação de responsabilidades
- Prontidão para ser integrado a qualquer frontend moderno

