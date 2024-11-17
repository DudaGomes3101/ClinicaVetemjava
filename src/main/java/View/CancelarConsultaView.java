package View;

import Controller.CancelamentoController;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class CancelarConsultaView extends JFrame {
    private CancelamentoController cancelamentoController;
    private JTextField txtIdConsulta;
    private JTextField txtMotivo;

    public CancelarConsultaView(Connection conexao) {
        this.cancelamentoController = new CancelamentoController(conexao);
        setTitle("Cancelar Consulta");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Componentes da view
        JLabel lblIdConsulta = new JLabel("ID da Consulta:");
        txtIdConsulta = new JTextField();
        
        JLabel lblMotivo = new JLabel("Motivo:");
        txtMotivo = new JTextField();

        JButton btnCancelar = new JButton("Cancelar Consulta");
        btnCancelar.addActionListener(e -> {
            int idConsulta = Integer.parseInt(txtIdConsulta.getText());
            String motivo = txtMotivo.getText();
            cancelamentoController.cancelarConsulta(idConsulta, motivo);
            JOptionPane.showMessageDialog(this, "Consulta cancelada com sucesso!");
            dispose();
        });

        // Adicionando componentes à view
        add(lblIdConsulta);
        add(txtIdConsulta);
        add(lblMotivo);
        add(txtMotivo);
        add(new JLabel()); // Placeholder
        add(btnCancelar);

        setVisible(true);
    }

    public CancelarConsultaView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
