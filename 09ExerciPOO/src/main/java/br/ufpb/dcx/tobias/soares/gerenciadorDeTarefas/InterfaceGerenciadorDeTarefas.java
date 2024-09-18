package br.ufpb.dcx.tobias.soares.gerenciadorDeTarefas;

import java.util.Collection;

public abstract interface InterfaceGerenciadorDeTarefas{
    public boolean adicionarTarefa(Tarefa tarefa);
    public void removerTarefaPeloTitulo(String titulo) throws TarefaNaoEncontradaException;
    public Collection<Tarefa> buscarTodasAsTarefasDoUsuario(Usuario user) throws NaoHaTarefasException;
}
