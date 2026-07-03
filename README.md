# 🩺 Vitalis – Sistema de Gestão para Clínicas Médicas

## Sobre o Projeto

O **Vitalis** é uma aplicação full stack desenvolvida para auxiliar na gestão de clínicas médicas, oferecendo uma API REST para gerenciamento de pacientes, médicos e consultas, além de uma interface web para interação com o sistema.

O projeto foi criado com o objetivo de aplicar boas práticas de desenvolvimento, arquitetura em camadas e integração entre backend e frontend, simulando um sistema utilizado em ambientes clínicos reais.

---

## Funcionalidades

### 👤 Gestão de Pacientes

* Cadastro de pacientes
* Consulta de pacientes
* Atualização de informações
* Exclusão de registros

### 👨‍⚕️ Gestão de Médicos

* Cadastro de médicos
* Consulta de médicos
* Atualização de informações
* Exclusão de registros

### 📅 Gestão de Consultas

* Agendamento de consultas
* Associação entre paciente e médico
* Consulta de agendamentos
* Atualização e cancelamento de consultas
* 
---

## Tecnologias Utilizadas

### Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* JWT

### Frontend

* React
* Javascript
* Vite

### Banco de Dados

* PostgreSQL
(Usei o software pgAdmin4)

### Testes

* Para testes unitários:
* JUnit 5
* Mockito
* Para testes manuais de endpoints:
* Postman

---

## Arquitetura

O projeto segue uma arquitetura em camadas, separando as responsabilidades entre:

* **Controller** – Endpoints da API
* **Service** – Regras de negócio
* **Repository** – Persistência de dados
* **DTO** – Objetos de entrada e saída
* **Model** – Entidades do domínio
* **Security** – Autenticação e autorização
* **Exception** – Tratamento global de exceções

---

## Objetivos do Projeto

* Desenvolver uma aplicação completa para gestão de clínicas médicas.
* Consolidar conhecimentos em Java, Spring Boot e React.
* Aplicar boas práticas de arquitetura e desenvolvimento de APIs REST.
* Construir um projeto de portfólio com tecnologias utilizadas no mercado.

---

## Status do Projeto

### ✅ Implementado

* CRUD de pacientes
* CRUD de médicos
* CRUD de consultas
* CRUD de triagens
* Controle de fluxo de pacientes
* Dois fluxos diferentes (Emergencial e agendado)
* Fila de prioridade usando protocolo de manchester com cálculo com base nos sinais vitais
* Persistência com PostgreSQL
* Migrações com Flyway
* Tratamento de exceções (GlobalException e Business Exception)
* API REST

---

## Autor

**Cauê Sobral**

Estudante de Ciência da Computação e desenvolvedor Java apaixonado por desenvolvimento backend, arquitetura de software e aplicações web.
