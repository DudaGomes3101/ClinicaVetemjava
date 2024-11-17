package View;

import Controller.ProprietarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ExcluirProprietarioView extends JFrame {
    private ProprietarioController proprietarioController;
    private int proprietarioId;

    public ExcluirProprietarioView(Connection conexao) {
        this.proprietarioController = new ProprietarioController(conexao);
        this.proprietarioId = proprietarioId;

        setTitle("Excluir Proprietário");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Mensagem de confirmação
        JLabel mensagemLabel = new JLabel("Tem certeza que deseja excluir este proprietário?");
        add(mensagemLabel);

        // Botão de Excluir
        JButton excluirButton = new JButton("Excluir");
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Usando o controller para excluir o proprietário
                proprietarioController.excluirProprietario(proprietarioId);
                
                JOptionPane.showMessageDialog(null, "Proprietário excluído com sucesso!");
                dispose(); // Fecha a janela após excluir
            }
        });
        add(excluirButton);

        // Botão de Cancelar
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela se cancelar
            }
        });
        add(cancelarButton);

        setVisible(true);
    }

    public ExcluirProprietarioView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
