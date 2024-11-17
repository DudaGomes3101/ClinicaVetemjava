package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MainView extends JFrame {
    private Connection conexao;

    public MainView(Connection conexao) {
        this.conexao = conexao;
        initialize();
    }

    private void initialize() {
        setTitle("Clínica Veterinária");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Botões
        JButton btnCadastrarPaciente = new JButton("Cadastrar Paciente");
        btnCadastrarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode chamar a função para abrir a tela de cadastro de paciente
                // Exemplo: new CadastrarPacienteView(conexao).setVisible(true);
            }
        });

        JButton btnCadastrarAgendamento = new JButton("Cadastrar Agendamento");
        btnCadastrarAgendamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode chamar a função para abrir a tela de cadastro de agendamento
            }
        });

        // Adicionando botões ao painel
        panel.add(btnCadastrarPaciente);
        panel.add(btnCadastrarAgendamento);

        // Adicionando painel ao JFrame
        add(panel);
    }
}
