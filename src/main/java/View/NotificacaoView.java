package View;

import Controller.NotificacaoController;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class NotificacaoView extends JFrame {
    private NotificacaoController notificacaoController;
    private JTextField txtIdPaciente;
    private JTextField txtMensagem;
    private JTextField txtData;

    public NotificacaoView(Connection conexao) {
        this.notificacaoController = new NotificacaoController(conexao);
        setTitle("Enviar Notificação");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Componentes da view
        JLabel lblIdPaciente = new JLabel("ID do Paciente:");
        txtIdPaciente = new JTextField();

        JLabel lblMensagem = new JLabel("Mensagem:");
        txtMensagem = new JTextField();

        JLabel lblData = new JLabel("Data:");
        txtData = new JTextField();

        JButton btnEnviar = new JButton("Enviar Notificação");
        btnEnviar.addActionListener(e -> {
            int idPaciente = Integer.parseInt(txtIdPaciente.getText());
            String mensagem = txtMensagem.getText();
            String data = txtData.getText();
            notificacaoController.enviarNotificacao(idPaciente, mensagem, data);
            JOptionPane.showMessageDialog(this, "Notificação enviada com sucesso!");
            dispose();
        });

        // Adicionando componentes à view
        add(lblIdPaciente);
        add(txtIdPaciente);
        add(lblMensagem);
        add(txtMensagem);
        add(lblData);
        add(txtData);
        add(new JLabel()); // Placeholder
        add(btnEnviar);

        setVisible(true);
    }

    public NotificacaoView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
