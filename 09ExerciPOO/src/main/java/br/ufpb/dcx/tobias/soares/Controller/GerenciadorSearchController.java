package br.ufpb.dcx.tobias.soares.Controller;

import br.ufpb.dcx.tobias.gerenciadorDeTarefas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class GerenciadorSearchController implements ActionListener {
    private GerenciadorDeTarefas gerenciador;
    private JFrame janelaPrincipal;

    public GerenciadorSearchController(GerenciadorDeTarefas gerenciador, JFrame janelaPrincipal) {
        this.gerenciador = gerenciador;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeDoUsuario = JOptionPane.showInputDialog(janelaPrincipal,"Digite o nome do usuario que está cadastrado nas tarefas: ");
        String email = JOptionPane.showInputDialog(janelaPrincipal,"Digite o e-mail:");
        Usuario usuario = new Usuario(nomeDoUsuario, email);
        try {
            Collection<Tarefa> tarefasAchadas = gerenciador.buscarTodasAsTarefasDoUsuario(usuario);
            JOptionPane.showMessageDialog(janelaPrincipal,"Tarefas encontradas: ");
            for(Tarefa tarefa : tarefasAchadas) {
                JOptionPane.showMessageDialog(janelaPrincipal,tarefa.toString());
            }
        } catch (NaoHaTarefasException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Nenhuma tarefa encontrada");
        }

    }
}
