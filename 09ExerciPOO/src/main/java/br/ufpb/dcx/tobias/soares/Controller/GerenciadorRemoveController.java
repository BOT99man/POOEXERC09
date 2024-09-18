package br.ufpb.dcx.tobias.soares.Controller;

import br.ufpb.dcx.tobias.gerenciadorDeTarefas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciadorRemoveController implements ActionListener{
    private GerenciadorDeTarefas gerenciador;
    private JFrame janelaPrincipal;

    public GerenciadorRemoveController(GerenciadorDeTarefas gerenciador, JFrame janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
        this.gerenciador = gerenciador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String titulo = JOptionPane.showInputDialog(janelaPrincipal,"Qual o título da tarefa a ser removida?");
        try {
            gerenciador.removerTarefaPeloTitulo(titulo);
            JOptionPane.showMessageDialog(janelaPrincipal,"Tarefa removida com sucesso!");

        } catch (TarefaNaoEncontradaException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Tarefa não encontrada!");
        }
    }
}
