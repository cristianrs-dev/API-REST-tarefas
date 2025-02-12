
package com.api.tarefas.controller;

import com.api.tarefas.model.Tarefa;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController para indicar que é uma classe controladora
@RestController
//RequestMapping indica que esse sera o link para acessar os servicos disponibilizados por essa classe
@RequestMapping("/tarefas")
public class TarefaController {
    private List<Tarefa> tarefas = new ArrayList();
    private int proximoId=1;
    
    public void listaDeTarefas(){
        this.tarefas = new ArrayList<>();
        tarefas.add(new Tarefa(1, "tarefa 1",false));
        tarefas.add(new Tarefa(2, "tarefa 2",false));
    }
    
    @PostConstruct
    public void init() {
    this.tarefas = new ArrayList<>();
    tarefas.add(new Tarefa(1, "Tarefa 1", false));
    tarefas.add(new Tarefa(2, "Tarefa 2", false));
}
    
    @GetMapping
    public List buscaTodasTarefas(){
        return tarefas;
    }
    @GetMapping("/{id}")
    public Tarefa buscaTarefaId(@PathVariable int id){
        for(Tarefa tarefa : tarefas){
            if(tarefa.getId() == id){
                return tarefa;
            }
        }
        return null;
    }
    
    // Endpoint para criar uma nova tarefa
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa novaTarefa) {
        novaTarefa.setId(proximoId++);
        tarefas.add(novaTarefa);
        return novaTarefa;
    }

    // Endpoint para atualizar uma tarefa existente
    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable int id, @RequestBody Tarefa tarefaAtualizada) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId() == id) {
                tarefaAtualizada.setId(id);
                tarefas.set(i, tarefaAtualizada);
                return tarefaAtualizada;
            }
        }
        return null;
    }

    // Endpoint para deletar uma tarefa
    @DeleteMapping("/{id}")
    public String deletarTarefa(@PathVariable int id) {
        tarefas.removeIf(tarefa -> tarefa.getId() == id);
        return "Tarefa com ID " + id + " deletada com sucesso.";
    }
}
  
