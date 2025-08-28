# API REST - Projeto Full-Stack de Lista de Tarefas

API REST desenvolvida como o núcleo de uma aplicação full-stack de gerenciamento de tarefas. Este backend é responsável por toda a lógica de negócio e persistência de dados, servindo dois clientes diferentes: uma aplicação web em Angular e uma aplicação desktop em JavaFX.

---

### Arquitetura da Solução

O projeto é dividido em três repositórios independentes que se comunicam via API REST, seguindo uma arquitetura de microsserviços desacoplada.

-   **1. Backend (Este Repositório):**
    -   API central construída com **Java e Spring Boot**.
    -   Gerencia todas as operações CRUD (Criar, Ler, Atualizar, Deletar).
    -   Utiliza um banco de dados em memória **H2** para facilitar o desenvolvimento.

-   **2. Frontend Web:**
    -   Cliente web moderno construído com **Angular**.
    -   Link para o repositório: `https://github.com/RafaelSilvaGomes/lista-tarefas-web`

-   **3. Frontend Desktop:**
    -   Cliente desktop nativo construído com **JavaFX**.
    -   Link para o repositório: `https://github.com/RafaelSilvaGomes/lista-tarefas-desktop`

### Tecnologias Utilizadas
-   Java 21
-   Spring Boot 3
-   Spring Data JPA
-   Maven
-   H2 Database

### Como Executar
1.  **Pré-requisitos:** Ter o JDK 21 instalado.
2.  Clone este repositório: `git clone https://github.com/RafaelSilvaGomes/lista-tarefas-api.git`
3.  Abra o projeto em sua IDE (VS Code, IntelliJ, etc.).
4.  Execute a classe principal `ListaTarefasApiApplication.java`.
5.  Caso esteja no VS Code instale a extensão 'Spring Boot Dashboard'
6.  Clique no icone da extensão e execute 'lista-tarefa-api'
7.  A API estará rodando em `http://localhost:8080`.

### Endpoints da API

| Método | URL                 | Descrição                      |
| :----- | :------------------ | :----------------------------- |
| `GET`  | `/api/tarefas`      | Lista todas as tarefas.        |
| `POST` | `/api/tarefas`      | Cria uma nova tarefa.          |
| `PUT`  | `/api/tarefas/{id}` | Atualiza uma tarefa existente. |
| `DELETE`| `/api/tarefas/{id}` | Deleta uma tarefa.             |

---
**Autor:** Rafael Silva Gomes
