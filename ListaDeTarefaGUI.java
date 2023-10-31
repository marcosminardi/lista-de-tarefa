package br.newtonpaiva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ListaDeTarefaGUI {
    static ArrayList<String> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Lista de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField campoTexto = new JTextField();
        panel.add(campoTexto);

        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tarefa = campoTexto.getText();
                tarefas.add(tarefa);
                campoTexto.setText("");
                JOptionPane.showMessageDialog(frame, "Tarefa adicionada com sucesso!");
            }
        });
        panel.add(botaoAdicionar);

        JButton botaoRemover = new JButton("Remover");
        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tarefas.isEmpty()) {
                    tarefas.remove(tarefas.size() - 1);
                    JOptionPane.showMessageDialog(frame, "Tarefa removida com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Não há tarefas para remover!");
                }
            }
        });
        panel.add(botaoRemover);

        JButton botaoListar = new JButton("Listar");
        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder tarefasString = new StringBuilder();
                for (String tarefa : tarefas) {
                    tarefasString.append(tarefa).append("\n");
                }
                JOptionPane.showMessageDialog(frame, tarefasString.toString());
            }
        });
        panel.add(botaoListar);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }


}
