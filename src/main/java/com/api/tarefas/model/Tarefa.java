
package com.api.tarefas.model;

import org.springframework.stereotype.Component;

@Component
public class Tarefa {
   private int id;
   private String descricao;
   private boolean completa;

    public Tarefa() {
    }

    public Tarefa(int id, String descricao, boolean completa) {
        this.id = id;
        this.descricao = descricao;
        this.completa = completa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }
   
   
}
