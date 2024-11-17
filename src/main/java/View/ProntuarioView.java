package view;

import Controller.ProntuarioController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

public class ProntuarioView {
    private ProntuarioController controller;
    private JFrame frame;

    // Componentes da interface
    private JTextField pacienteIdField;
    private JTextField procedimentoField;
    private JTextField prescricoesField;
    private JTextField anexosField;
    private JTextArea resultArea;

    public ProntuarioView(Connection conexao) {
        this.controller = new ProntuarioController(conexao);
        initialize();
    }

    public ProntuarioView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void initialize() {
        frame = new JFrame("Gerenciamento de Prontuários");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        pacienteIdField = new JTextField(10);
        procedimentoField = new JTextField(10);
        prescricoesField = new JTextField(10);
        anexosField = new JTextField(10);
        resultArea = new JTextArea(10, 30);

        JButton adicionarButton = new JButton("Adicionar Prontuário");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar a lógica para coletar a data e chamar o método de adicionar
                controller.adicionarProntuario(Integer.parseInt(pacienteIdField.getText()), new java.util.Date(), procedimentoField.getText(), prescricoesField.getText(), anexosField.getText());
                resultArea.setText("Prontuário adicionado!");
            }
        });

        frame.add(new JLabel("ID do Paciente:"));
        frame.add(pacienteIdField);
        frame.add(new JLabel("Procedimento:"));
        frame.add(procedimentoField);
        frame.add(new JLabel("Prescrições:"));
        frame.add(prescricoesField);
        frame.add(new JLabel("Anexos:"));
        frame.add(anexosField);
        frame.add(adicionarButton);
        frame.add(resultArea);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Aqui você deve criar a conexão com o banco de dados e passar para a view
        Connection conexao = null; // Crie a conexão com o banco de dados
        new ProntuarioView(conexao);
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
