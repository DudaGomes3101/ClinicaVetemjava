package View;

import Model.Pagamento;
import Controller.PagamentoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class PagamentoView extends JFrame {
    private JTextField agendamentoIdField;
    private JTextField valorField;
    private JComboBox<String> statusComboBox;
    private PagamentoController pagamentoController;

    public PagamentoView(Connection conexao) {
        this.pagamentoController = new PagamentoController(conexao);
        setTitle("Registro de Pagamento");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Campos para entrada de dados
        add(new JLabel("Agendamento ID:"));
        agendamentoIdField = new JTextField();
        add(agendamentoIdField);

        add(new JLabel("Valor:"));
        valorField = new JTextField();
        add(valorField);

        add(new JLabel("Status:"));
        statusComboBox = new JComboBox<>(new String[]{"PAGO", "PENDENTE"});
        add(statusComboBox);

        // Botão de Salvar
        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salvar o pagamento
                int agendamentoId = Integer.parseInt(agendamentoIdField.getText());
                double valor = Double.parseDouble(valorField.getText());
                String status = (String) statusComboBox.getSelectedItem();

                // Usando o controller para registrar o pagamento
                pagamentoController.registrarPagamento(agendamentoId, valor, status);
                
                JOptionPane.showMessageDialog(null, "Pagamento registrado com sucesso!");
                dispose(); // Fecha a janela após salvar
            }
        });
        add(salvarButton);

        setVisible(true);
    }

    public PagamentoView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
