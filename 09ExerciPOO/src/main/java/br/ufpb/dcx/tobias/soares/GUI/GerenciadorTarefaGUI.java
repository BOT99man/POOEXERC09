package br.ufpb.dcx.tobias.soares.GUI;

import br.ufpb.dcx.tobias.gerenciadorDeTarefas.*;
import br.ufpb.dcx.tobias.Controller.*;

import javax.swing.*;
import java.awt.*;

public class GerenciadorTarefaGUI extends JFrame {
    JLabel linha1;
    GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
    JMenuBar menuBar = new JMenuBar();

    public GerenciadorTarefaGUI() {
        setTitle("GERENCIADOR DE TAREFAS");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);
        linha1 = new JLabel("MINHAS TAREFAS", JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("CADASTRAR");
        JMenuItem menuCadastrarTarefa = new JMenuItem(
                "Cadastrar tarefa");
        menuCadastrar.add(menuCadastrarTarefa);
        JMenu menuPesquisar = new JMenu("PESQUISAR");
        JMenuItem menuPesquisarTarefa = new JMenuItem(
                "Pesquisar tarefa");
        menuPesquisar.add(menuPesquisarTarefa);
        JMenu menuRemover = new JMenu("REMOVER");
        JMenuItem menuRemoverTarefa = new JMenuItem(
                "Remover tarefa");
        menuRemover.add(menuRemoverTarefa);
        menuPesquisarTarefa.addActionListener(
                new GerenciadorSearchController(gerenciador,this));
        menuRemoverTarefa.addActionListener(
                new GerenciadorRemoveController(gerenciador,this));
        menuCadastrarTarefa.addActionListener(
                (ae) -> {
                    String titulo = JOptionPane.showInputDialog(this,"Digite o título da tarefa: ");
                    String descricao = JOptionPane.showInputDialog(this,"Digite a descrição da tarefa: ");
                    String nomeDoUsuario = JOptionPane.showInputDialog(this,"Digite o nome do usuario: ");
                    String email = JOptionPane.showInputDialog(this,"Digite o e-mail: ");;
                    Usuario usuario = new Usuario(nomeDoUsuario,email);
                    Tarefa tarefa = new Tarefa(titulo,descricao,usuario);
                    boolean cadastrou = gerenciador.adicionarTarefa(tarefa);
                    if(cadastrou){
                        JOptionPane.showMessageDialog(this,"Tarefa adicionada com sucesso!");
                    }else {
                        JOptionPane.showMessageDialog(this, "Erro ao adicionar uma tarefa!" + "Verifique se já não existia tarefa com o mesmo título.");
                    }
                });
        menuBar.add(menuCadastrar);
        menuBar.add(menuPesquisar);
        menuBar.add(menuRemover);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame janela = new GerenciadorTarefaGUI();
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
