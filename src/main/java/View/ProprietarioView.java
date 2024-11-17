package View;

import Model.Proprietario;
import Controller.ProprietarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ProprietarioView extends JFrame {
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField enderecoField;
    private ProprietarioController proprietarioController;

    public ProprietarioView(Connection conexao) {
        this.proprietarioController = new ProprietarioController(conexao);
        setTitle("Gerenciamento de Proprietários");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Campos para entrada de dados
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        add(telefoneField);

        add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        add(enderecoField);

        // Botão de Salvar
        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String endereco = enderecoField.getText();

                // Usando o controller para cadastrar o proprietário
                proprietarioController.cadastrarProprietario(nome, telefone, endereco);
                
                JOptionPane.showMessageDialog(null, "Proprietário cadastrado com sucesso!");
                dispose(); // Fecha a janela após salvar
            }
        });
        add(salvarButton);

        setVisible(true);
    }

    public ProprietarioView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
