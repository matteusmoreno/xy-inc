# XY-PI - Sistema de Gerenciamento de Pontos de Interesse (POIs)

[![Java](https://img.shields.io/badge/Java-17-red)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-green)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8-blue)](https://www.mysql.com/)
[![Flyway](https://img.shields.io/badge/Flyway-migration-orange)](https://flywaydb.org/)
[![Springdoc](https://img.shields.io/badge/Springdoc-OpenAPI%20UI-lightgrey)](https://springdoc.org/)

## Visão Geral

O XY-PI é um sistema de gerenciamento de Pontos de Interesse (POIs) desenvolvido em Java usando Spring Boot para o backend e MySQL para o armazenamento de dados. Este sistema oferece várias funcionalidades para criar, visualizar, atualizar, desativar e listar POIs, bem como encontrar POIs dentro de uma proximidade especificada.

## Funcionalidades

### 1. Criar Pontos de Interesse

- Endpoint: `POST /points-of-interest/create`
- Crie novos Pontos de Interesse fornecendo um nome, coordenada x e coordenada y.
- Atributos obrigatórios: nome, coordenada x e coordenada y.

### 2. Visualizar Detalhes de um Ponto

- Endpoint: `GET /points-of-interest/details/{id}`
- Visualize os detalhes de um Ponto de Interesse específico com base no seu ID.

### 3. Listar Pontos de Interesse

- Endpoint: `GET /points-of-interest/list`
- Liste todos os Pontos de Interesse ativos com paginação.
- Ordenação por nome, tamanho da página padrão: 10.

### 4. Listar Pontos por Proximidade

- Endpoint: `GET /points-of-interest/proximities`
- Encontre Pontos de Interesse dentro de uma faixa de proximidade especificada.
- Atributos obrigatórios: coordenada x, coordenada y e distância máxima.
- Ordenação por nome, tamanho da página padrão: 10.

### 5. Atualizar Pontos de Interesse

- Endpoint: `PUT /points-of-interest/update`
- Atualize o nome, a coordenada x e a coordenada y de um Ponto de Interesse existente.
- Atributo obrigatório: ID do Ponto de Interesse.

### 6. Ativar Pontos de Interesse

- Endpoint: `PUT /points-of-interest/activate/{id}`
- Ative um Ponto de Interesse com base no seu ID.

### 7. Desativar Pontos de Interesse

- Endpoint: `DELETE /points-of-interest/deactivate/{id}`
- Desative um Ponto de Interesse com base no seu ID.

## Como Executar

Siga as etapas abaixo para executar o projeto:

1. Clone o repositório do projeto:

```bash
git clone https://github.com/matteusmoreno/xy-inc
```

2. Navegue até o diretório do projeto:

```bash
cd xy-inc
```

3. Execute o projeto com Maven:

```bash
mvn spring-boot:run
```
4. O aplicativo estará acessível em `http://localhost:8080`. Você pode usar as rotas mencionadas acima para interagir com os Pontos de Interesse.

## Requisitos do Banco de Dados

O sistema utiliza um banco de dados MySQL. Certifique-se de configurar o MySQL e ajustar as configurações de conexão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost/xy-inc?createDatabaseIfNotExist=true
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
Desenvolvedor

    Matteus Moreno - Desenvolvedor principal

## Problema Original

O desafio foi baseado em [Points of Interest](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md), do repositório [Desafios de Backend](https://github.com/backend-br/desafios).




