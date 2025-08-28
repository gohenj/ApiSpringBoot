package br.com.curso.listadetarefas.desktop;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    // --- Componentes da Interface (@FXML) ---
    @FXML private TableView<Tarefa> tabelaTarefas;
    @FXML private TableColumn<Tarefa, Boolean> colunaConcluida;
    @FXML private TableColumn<Tarefa, String> colunaDescricao;
    @FXML private TableColumn<Tarefa, Void> colunaAcoes;
    @FXML private TextField campoNovaTarefa;
    @FXML private Button botaoAdicionar;
    @FXML private Label labelStatus;
    @FXML private Button botaoAtualizar;

    // --- Lógica de Negócio ---
    private final TarefaApiService tarefaApiService = new TarefaApiService();
    private final ObservableList<Tarefa> tarefasObservaveis = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Vincula a lista observável à tabela. Qualquer mudança na lista, reflete na tabela.
        tabelaTarefas.setItems(tarefasObservaveis);
        // Habilita a edição da tabela (necessário para editar a descrição)
        tabelaTarefas.setEditable(true);

        // --- Configuração das Colunas ---
        // Coluna Descrição: Pega o valor do atributo "descricao" do objeto Tarefa
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        // Torna a célula da descrição um campo de texto editável com duplo clique
        colunaDescricao.setCellFactory(TextFieldTableCell.forTableColumn());
        // Define o que fazer quando a edição é confirmada (pressionar Enter)
        colunaDescricao.setOnEditCommit(event -> {
            Tarefa tarefaEditada = event.getRowValue();
            tarefaEditada.setDescricao(event.getNewValue());
            atualizarTarefa(tarefaEditada);
        });

        // Coluna Concluída: Pega o valor do atributo "concluida"
        colunaConcluida.setCellValueFactory(new PropertyValueFactory<>("concluida"));
        // Customiza a célula para mostrar um CheckBox
        colunaConcluida.setCellFactory(tc -> new TableCell<>() {
            private final CheckBox checkBox = new CheckBox();
            {
                // Quando o checkbox é clicado, atualiza a tarefa
                checkBox.setOnAction(event -> {
                    Tarefa tarefa = getTableRow().getItem();
                    if (tarefa != null) {
                        tarefa.setConcluida(checkBox.isSelected());
                        atualizarTarefa(tarefa);
                    }
                });
            }
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    checkBox.setSelected(item);
                    setGraphic(checkBox);
                }
            }
        });

        // Coluna Ações: Customiza a célula para mostrar um botão "Deletar"
        Callback<TableColumn<Tarefa, Void>, TableCell<Tarefa, Void>> cellFactory = param -> new TableCell<>() {
            private final Button btnDeletar = new Button("Deletar");
            {
                btnDeletar.setOnAction(event -> {
                    Tarefa tarefa = getTableView().getItems().get(getIndex());
                    deletarTarefa(tarefa);
                });
            }
            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btnDeletar);
                }
            }
        };
        colunaAcoes.setCellFactory(cellFactory);

        // Carrega os dados da API ao iniciar a tela.
        carregarTarefas();
    }

    // --- Métodos de Ação (chamados pelos botões) ---
    @FXML
    private void atualizarListaDeTarefas() {
        carregarTarefas();
    }

    @FXML
    private void adicionarTarefa() {
        String descricao = campoNovaTarefa.getText();
        if (descricao == null || descricao.trim().isEmpty()) {
            labelStatus.setText("Status: Descrição não pode ser vazia.");
            return;
        }

        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setDescricao(descricao.trim());
        novaTarefa.setConcluida(false);

        // Executa a chamada de rede em uma thread separada para não travar a UI
        executarEmBackground(() -> {
            Tarefa tarefaCriada = tarefaApiService.adicionarTarefa(novaTarefa);
            if (tarefaCriada != null) {
                // Atualiza a interface na thread do JavaFX
                Platform.runLater(() -> {
                    tarefasObservaveis.add(tarefaCriada);
                    campoNovaTarefa.clear();
                    labelStatus.setText("Status: Tarefa adicionada!");
                });
            }
        });
    }

    // --- Métodos de Lógica Interna ---
    private void carregarTarefas() {
        executarEmBackground(() -> {
            List<Tarefa> tarefasDaApi = tarefaApiService.listarTarefas();
            Platform.runLater(() -> {
                tarefasObservaveis.setAll(tarefasDaApi);
                labelStatus.setText("Status: Tarefas carregadas.");
            });
        });
    }

    private void atualizarTarefa(Tarefa tarefa) {
        executarEmBackground(() -> {
            tarefaApiService.atualizarTarefa(tarefa);
            Platform.runLater(() -> labelStatus.setText("Status: Tarefa '" + tarefa.getDescricao() + "' atualizada."));
        });
    }

    private void deletarTarefa(Tarefa tarefa) {
        executarEmBackground(() -> {
            tarefaApiService.deletarTarefa(tarefa.getId());
            Platform.runLater(() -> {
                tarefasObservaveis.remove(tarefa);
                labelStatus.setText("Status: Tarefa deletada.");
            });
        });
    }

    /**
     * Helper para executar tarefas de longa duração (como chamadas de rede)
     * em uma thread de fundo para não congelar a interface do usuário.
     */
    private void executarEmBackground(Runnable acao) {
        labelStatus.setText("Status: Processando...");
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                acao.run();
                return null;
            }
        };
        task.setOnFailed(e -> {
            task.getException().printStackTrace();
            Platform.runLater(() -> labelStatus.setText("Status: Erro na operação. Veja o console."));
        });
        new Thread(task).start();
    }
}