module br.com.curso.listadetarefas.desktop {
    // ---- Dependências do JavaFX ----
    requires javafx.controls;
    requires javafx.fxml;

    // ---- Dependências de Bibliotecas Externas ----
    requires com.fasterxml.jackson.databind; // Para o JSON
    requires java.net.http; // Para fazer as chamadas de API

    // ---- Permissões do Sistema de Módulos ----
    // Permite que o JavaFX inicie e execute nossa aplicação
    exports br.com.curso.listadetarefas.desktop;

    // Permite que as bibliotecas FXML e Jackson acessem nossas classes
    // para poder injetar componentes da UI e converter objetos para JSON.
    opens br.com.curso.listadetarefas.desktop to javafx.fxml, com.fasterxml.jackson.databind;
}