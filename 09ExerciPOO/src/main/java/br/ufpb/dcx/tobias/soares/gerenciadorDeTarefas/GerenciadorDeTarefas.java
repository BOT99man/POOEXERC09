package br.ufpb.dcx.tobias.soares.gerenciadorDeTarefas;

import java.util.*;

public class GerenciadorDeTarefas implements InterfaceGerenciadorDeTarefas {
    private Map<String, Tarefa> tarefas;

    public GerenciadorDeTarefas() {
        this.tarefas = new HashMap<String, Tarefa>();
    }


    @Override
    public boolean adicionarTarefa(Tarefa tarefa) {
        if(tarefa != null) {
            if (tarefas.containsKey(tarefa.getTitulo())) {
                return false;
            }
            tarefas.put(tarefa.getTitulo(), tarefa);
            return true;
        }
        return false;
    }

    @Override
    public void removerTarefaPeloTitulo(String titulo) throws TarefaNaoEncontradaException {
        if(!tarefas.containsKey(titulo)){
            throw new TarefaNaoEncontradaException("Tarefa não encontrada com o título: ["+ titulo +"]");
        }
        if(tarefas.containsKey(titulo)){
            tarefas.remove(titulo);
        }
    }

    @Override
    public Collection<Tarefa> buscarTodasAsTarefasDoUsuario(Usuario user) throws NaoHaTarefasException {
        Collection<Tarefa> tarefasDoUsuario = new ArrayList<Tarefa>();
        for(Tarefa t : tarefas.values()){
            if(t.getUsuario().equals(user)){
                tarefasDoUsuario.add(t);
            }
        }
        if(tarefasDoUsuario.isEmpty()){
            throw new NaoHaTarefasException("Não há tarefas para esse usuário!");
        }
        return tarefasDoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GerenciadorDeTarefas that = (GerenciadorDeTarefas) o;
        return Objects.equals(tarefas, that.tarefas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tarefas);
    }

    @Override
    public String toString() {
        return "GerenciadorDeTarefas{" +
                "tarefas=" + tarefas +
                '}';
    }
}
