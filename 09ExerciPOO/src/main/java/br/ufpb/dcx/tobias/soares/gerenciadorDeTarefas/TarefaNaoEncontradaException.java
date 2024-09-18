package br.ufpb.dcx.tobias.soares.gerenciadorDeTarefas;

public class TarefaNaoEncontradaException extends Exception {
    public TarefaNaoEncontradaException() {
        super("br.ufpb.dcx.tobias.gerenciadorDeTarefas.Tarefa não encontrada");
    }

    public TarefaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
