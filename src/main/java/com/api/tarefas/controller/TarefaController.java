
package com.api.tarefas.controller;

import com.api.tarefas.model.Tarefa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController para indicar que é uma classe controladora
@RestController
//RequestMapping indica que esse sera o link para acessar os servicos disponibilizados por essa classe
@RequestMapping("/tarefas")
public class TarefaController {
    private List<Tarefa> tarefas = new ArrayList();
    private int proximoId=1;
    
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
    /*
    metodos para serem criados
    buscar todas as tarefas
    buscar tarefas por id
    criar tarefa
    atualizar tarefa
    deletar tarefa
    */
}
