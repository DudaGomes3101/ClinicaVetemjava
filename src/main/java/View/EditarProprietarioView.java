package View;

import Model.Proprietario;
import Controller.ProprietarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class EditarProprietarioView extends JFrame {
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField enderecoField;
    private ProprietarioController proprietarioController;
    private int proprietarioId;

    public EditarProprietarioView(Connection conexao) {
        this.proprietarioController = new ProprietarioController(conexao);
        this.proprietarioId = proprietarioId;
        Proprietario proprietario = proprietarioController.buscarProprietarioPorId(proprietarioId);

        setTitle("Editar Proprietário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Campos para entrada de dados
        add(new JLabel("Nome:"));
        nomeField = new JTextField(proprietario.getNome());
        add(nomeField);

        add(new JLabel("Telefone:"));
        telefoneField = new JTextField(proprietario.getTelefone());
        add(telefoneField);

        add(new JLabel("Endereço:"));
        enderecoField = new JTextField(proprietario.getEndereco());
        add(enderecoField);

        // Botão de Atualizar
        JButton atualizarButton = new JButton("Atualizar");
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String endereco = enderecoField.getText();

                // Usando o controller para atualizar o proprietário
                proprietarioController.editarProprietario(proprietarioId, nome, telefone, endereco);
                
                JOptionPane.showMessageDialog(null, "Proprietário atualizado com sucesso!");
                dispose(); // Fecha a janela após atualizar
            }
        });
        add(atualizarButton);

        setVisible(true);
    }

    public EditarProprietarioView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
