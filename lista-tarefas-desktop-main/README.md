# 🖥️ Cliente Desktop (JavaFX) - Projeto Lista de Tarefas

Este repositório é o lar da nossa aplicação de desktop, a face nativa do nosso projeto **full-stack**! Desenvolvido em **Java** com o poderoso framework **JavaFX**, este cliente oferece uma experiência de usuário fluida e responsiva, se comunicando com a mesma **API REST** que alimenta a versão web.

---

### 🧩 Arquitetura do Projeto

Nosso sistema é construído de forma **desacoplada**, com cada componente vivendo em seu próprio repositório e se comunicando através da API.

* `🔌` **Backend (API):** O coração da aplicação, servindo dados para todos os clientes.
* `🌐` **Frontend Web:** O cliente web em Angular.
* `🖥️` **Este Repositório:** Contém exclusivamente o código-fonte do **Cliente Desktop**.

---

### ✅ Pré-requisitos

Para compilar e executar esta aplicação, você precisará ter o seguinte software instalado.

* **Java Development Kit (JDK):** Versão **17** ou superior.
    * `➡️` *Recomendação:* [Adoptium OpenJDK 17](https://adoptium.net/).
* **Apache Maven:** Ferramenta de automação de build.
    * `💡` *Nota:* IDEs como o IntelliJ IDEA já vêm com uma versão embutida.
* **IDE Java:**
    * `⭐` *Recomendação:* [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/).
* **Scene Builder:** Ferramenta visual para editar os arquivos `.fxml` da interface.
    * `🖌️` *Recomendação:* [Gluon Scene Builder para Java 17+](https://gluonhq.com/products/scene-builder/).
* **Git:** Para clonar o repositório.

**⚠️ Importante:** Para que o cliente desktop funcione, a **[API do backend](https://github.com/gohenj/main/lista-tarefas-api-main)** **precisa estar em execução**.

---

### 🚀 Como Executar o Projeto

Siga estes passos simples para rodar a aplicação desktop e começar a usar!

#### 1️⃣ Clonar o Repositório
Se você ainda não o fez, clone o repositório que contém os três projetos.

```bash
git clone [https://github.com/gohenj/main/lista-tarefas-desktop-main.git](https://github.com/gohenj/main/lista-tarefas-desktop-main.git)
