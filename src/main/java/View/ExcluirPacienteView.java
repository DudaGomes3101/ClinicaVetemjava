package View;

import Controller.PacienteController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcluirPacienteView extends JFrame {
    private PacienteController pacienteController;

    public ExcluirPacienteView(Connection conexao) {
        this.pacienteController = new PacienteController(conexao);
        setTitle("Excluir Paciente");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Mensagem de confirmação
        JLabel lblConfirmacao = new JLabel("Tem certeza que deseja excluir este paciente?");
        add(lblConfirmacao);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener((ActionEvent e) -> {
            try {
                int pacienteId = 0;
                pacienteController.excluirPaciente(pacienteId);
            } catch (SQLException ex) {
                Logger.getLogger(ExcluirPacienteView.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Paciente excluído com sucesso!");
            dispose();
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        add(btnExcluir);
        add(btnCancelar);

        setVisible(true);
    }

    public ExcluirPacienteView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
