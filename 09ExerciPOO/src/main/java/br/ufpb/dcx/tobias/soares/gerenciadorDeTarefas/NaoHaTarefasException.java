package br.ufpb.dcx.tobias.soares.gerenciadorDeTarefas;

public class NaoHaTarefasException extends Exception {
    public NaoHaTarefasException() {
        super("Nao há tarefas!");
    }

    public NaoHaTarefasException(String mensagem) {
        super(mensagem);
    }
}
