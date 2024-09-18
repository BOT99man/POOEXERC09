package br.ufpb.dcx.tobias.soares.gerenciadorDeTarefas;

public class ExisteTarefaComOTitulo extends Exception {
    public ExisteTarefaComOTitulo() {
        super("Já existe uma tarefa com o titulo");
    }
    public ExisteTarefaComOTitulo(String msg) {
        super(msg);
    }
}
