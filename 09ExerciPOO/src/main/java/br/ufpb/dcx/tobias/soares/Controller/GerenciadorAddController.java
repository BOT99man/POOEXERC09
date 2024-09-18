package br.ufpb.dcx.tobias.soares.Controller;

import br.ufpb.dcx.tobias.gerenciadorDeTarefas.Tarefa;
import br.ufpb.dcx.tobias.gerenciadorDeTarefas.Usuario;
import br.ufpb.dcx.tobias.gerenciadorDeTarefas.GerenciadorDeTarefas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciadorAddController implements ActionListener {
    private GerenciadorDeTarefas gerenciadorTarefa;
    private JFrame janelaPrincipal;

    public GerenciadorAddController(GerenciadorDeTarefas gerenciadorTarefa, JFrame janelaPrincipal) {
        this.gerenciadorTarefa = gerenciadorTarefa;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String titulo = JOptionPane.showInputDialog(janelaPrincipal,"Digite o título da tarefa: ");
        String descricao = JOptionPane.showInputDialog(janelaPrincipal,"Digite a descrição da tarefa: ");
        String nomeDoUsuario = JOptionPane.showInputDialog(janelaPrincipal,"Digite o nome do usuario: ");
        String email = JOptionPane.showInputDialog(janelaPrincipal,"Digite o e-mail: ");
        Usuario usuario = new Usuario(nomeDoUsuario,email);
        Tarefa tarefa = new Tarefa(titulo,descricao,usuario);
        boolean cadastrou = gerenciadorTarefa.adicionarTarefa(tarefa);
        if(cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal,"Tarefa adicionada com sucesso!");
        }else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Erro ao adicionar uma tarefa!" + "Verifique se já não existia tarefa com o mesmo título.");
        }
    }
}
