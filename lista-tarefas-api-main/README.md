# 🌟 API REST - Projeto Full-Stack de Lista de Tarefas

Uma API REST desenvolvida como o coração de uma solução **full-stack** de gerenciamento de tarefas. Este backend é a espinha dorsal da aplicação, centralizando toda a lógica de negócio e a persistência de dados. A API serve como um hub para dois clientes distintos: uma aplicação web moderna e uma aplicação desktop nativa.

---

### 🧩 Arquitetura da Solução

O projeto é construído sobre uma arquitetura de microsserviços **desacoplada**, com cada componente residindo em seu próprio repositório. Eles se comunicam de forma fluida através desta API REST.

* **1. Backend (Este Repositório):**
    * `💻` A **API central** construída com **Java** e **Spring Boot**.
    * Gerencia todas as operações **CRUD** (Criar, Ler, Atualizar, Deletar).
    * Utiliza um banco de dados em memória **H2** para um desenvolvimento rápido e leve.

* **2. Frontend Web:**
    * `🌐` O cliente web, feito com **Angular**, para uma experiência de usuário moderna e responsiva.
    * Repositório: `https://github.com/gohenj/main/lista-tarefas-web-main`

* **3. Frontend Desktop:**
    * `🖥️` O cliente desktop, criado com **JavaFX**, oferecendo uma aplicação nativa e robusta.
    * Repositório: `https://github.com/gohenj/main/lista-tarefas-desktop-main`

---

### 🚀 Tecnologias Utilizadas

Este projeto foi construído com ferramentas e tecnologias robustas para garantir performance e escalabilidade.

* `☕` **Java 21**
* `🍃` **Spring Boot 3**
* `🗄️` **Spring Data JPA**
* `📦` **Maven**
* `⚙️` **H2 Database**

---

### 🛠️ Como Executar o Projeto

Siga estes passos simples para rodar a API em seu ambiente de desenvolvimento local.

#### Pré-requisitos
* Certifique-se de que você tem o **JDK 21** instalado.

#### Instalação
1.  **Clone este repositório:**
    ```bash
    git clone [https://github.com/gohenj/main/lista-tarefas-api-main.git](https://github.com/gohenj/lista-tarefas-api-main.git)
    ```
2.  **Abra o projeto:**
    * Abra a pasta do projeto em sua IDE favorita (VS Code, IntelliJ, etc.).
3.  **Execute a aplicação:**
    * **Via IDE:** Execute a classe principal `ListaTarefasApiApplication.java`.
    * **Via VS Code:** Instale a extensão 'Spring Boot Dashboard', clique no ícone da extensão e execute 'lista-tarefa-api-main'.
4.  **Acesse a API:**
    * A API estará rodando e pronta para receber requisições em `http://localhost:8080`.

---

### 📡 Endpoints da API

A API expõe os seguintes endpoints REST para gerenciar as tarefas:

| Método | URL                   | Descrição                       |
| :----- | :-------------------- | :------------------------------ |
| `GET`  | `/api/tarefas`        | Lista todas as tarefas.         |
| `POST` | `/api/tarefas`        | Cria uma nova tarefa.           |
| `PUT`  | `/api/tarefas/{id}`   | Atualiza uma tarefa existente.  |
| `DELETE`| `/api/tarefas/{id}`   | Deleta uma tarefa.              |

---

### ✍️ Autor

Este projeto foi desenvolvido com paixão por:

* **Gustavo Mendonça**

---
