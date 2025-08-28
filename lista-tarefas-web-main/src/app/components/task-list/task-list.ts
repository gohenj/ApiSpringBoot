import { Component, OnInit } from '@angular/core';
import { TarefaService } from '../../services/tarefa';
import { Tarefa } from '../../models/tarefa';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [ CommonModule, FormsModule ],
  templateUrl: './task-list.html',
  styleUrl: './task-list.css'
})
export class TaskListComponent implements OnInit {
  tarefas: Tarefa[] = [];
  novaTarefa: Tarefa = { descricao: '', concluida: false };
  private descricaoOriginal: string = '';

  constructor(private tarefaService: TarefaService) { }
  ngOnInit(): void { this.carregarTarefas(); }

  carregarTarefas(): void { this.tarefaService.getTarefas().subscribe(data => { this.tarefas = data; }); }
  atualizarStatus(tarefa: Tarefa): void { this.tarefaService.updateTarefa(tarefa).subscribe(); }
  iniciarEdicao(tarefa: Tarefa): void { this.descricaoOriginal = tarefa.descricao; tarefa.editando = true; }
  cancelarEdicao(tarefa: Tarefa): void { tarefa.descricao = this.descricaoOriginal; tarefa.editando = false; }

  adicionarTarefa(): void {
    if (this.novaTarefa.descricao.trim() === '') return;
    this.tarefaService.addTarefa(this.novaTarefa).subscribe(tarefaAdicionada => {
      this.tarefas.push(tarefaAdicionada);
      this.novaTarefa = { descricao: '', concluida: false };
    });
  }
  deletarTarefa(id: number | undefined): void {
    if (id === undefined) return;
    this.tarefaService.deleteTarefa(id).subscribe(() => { this.tarefas = this.tarefas.filter(t => t.id !== id); });
  }
  salvarEdicao(tarefa: Tarefa): void {
    if (tarefa.descricao.trim() === '') { tarefa.descricao = this.descricaoOriginal; }
    tarefa.editando = false;
    this.atualizarStatus(tarefa);
  }
}