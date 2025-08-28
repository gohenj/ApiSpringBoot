# Lista de Tarefas - Cliente Desktop (JavaFX)

Este é o cliente Desktop para o projeto Full-Stack "Lista de Tarefas". A aplicação foi desenvolvida em Java com o framework JavaFX, criando uma interface nativa que consome a mesma API REST utilizada pelo [cliente Web (Angular)](https://github.com/RafaelSilvaGomes/lista-tarefas-web.git).

## Arquitetura do Projeto

O sistema completo é dividido em três partes que se comunicam de forma desacoplada

Este repositório (`lista-tarefas-desktop`) contém o código-fonte apenas do **Cliente Desktop**.

## Pré-requisitos

Para compilar e executar esta aplicação, você precisará ter o seguinte software instalado:

* **Java Development Kit (JDK)**: Versão **17** ou superior.
    * *Recomendação:* [Adoptium OpenJDK 17](https://adoptium.net/).
* **Apache Maven**: Ferramenta de automação de build.
    * *Nota:* IDEs como o IntelliJ IDEA já vêm com uma versão embutida.
* **IDE Java**:
    * *Recomendação:* [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/).
* **Scene Builder**: Ferramenta para visualizar e editar os arquivos `.fxml` da interface.
    * *Recomendação:* [Gluon Scene Builder para Java 17+](https://gluonhq.com/products/scene-builder/).
* **Git**: Para clonar o repositório.

**⚠️ Importante:** Para que o cliente desktop funcione, a **[API do backend (`lista-tarefas-api`)](https://github.com/RafaelSilvaGomes/lista-tarefas-api) precisa estar em execução**.

## Como Executar o Projeto

Siga os passos abaixo para rodar a aplicação desktop.

#### 1. Clonar o Repositório Completo
Se você ainda não o fez, clone o repositório principal que contém os três projetos.

```bash
git clone https://github.com/RafaelSilvaGomes/lista-tarefas-desktop.git
```

#### 2. Iniciar o Backend (API)
Esta é a etapa mais crucial. O cliente desktop precisa da API para buscar e salvar os dados.

1.  Abra o projeto `lista-tarefas-api` na sua IDE.
2.  Aguarde a IDE baixar todas as dependências do Maven.
3.  Encontre a classe principal (`ListaTarefasApiApplication.java`) e execute-a.
4.  Verifique se o servidor subiu corretamente, na porta `8080`.

#### 3. Abrir e Executar o Projeto Desktop

1.  Na sua IDE (IntelliJ IDEA), abra o projeto `lista-tarefas-desktop` como um novo projeto.
    * Vá em `File` -> `Open...` e selecione a pasta `lista-tarefas-desktop`.
2.  Aguarde a IDE reconhecer o projeto Maven e baixar as dependências declaradas no `pom.xml`. Se necessário, clique no ícone "Reload All Maven Projects".
3.  Execute a aplicação:
    * Navegue até `src/main/java/br/com/curso/listadetarefas/desktop/`.
    * Encontre a classe `MainApp.java`.
    * Clique com o botão direito sobre ela e selecione **`Run 'MainApp.main()'`**.

A janela da aplicação desktop deve aparecer e, após alguns instantes, carregar as tarefas da API.

## Funcionalidades

O cliente desktop implementa o CRUD completo de tarefas:

* **Listar Tarefas**: Visualiza todas as tarefas existentes.
*  **Adicionar Tarefas**: Cria novas tarefas.
*  **Atualizar Tarefas**:
    * Marca tarefas como concluídas através de um checkbox.
    * Edita a descrição de uma tarefa com um duplo clique na célula.
*  **Deletar Tarefas**: Remove tarefas da lista.
*  **Sincronização Manual**: Um botão "Atualizar" busca os dados mais recentes do servidor, refletindo mudanças feitas por outros clientes (como a versão web).

## Tecnologias Utilizadas

* **Java 17**
* **JavaFX 17**: Framework para a construção da interface gráfica.
* **Maven**: Gerenciador de dependências e build do projeto.
* **Jackson Databind**: Biblioteca para conversão de objetos Java para JSON e vice-versa.
* **Scene Builder**: Ferramenta visual para design da interface FXML.
