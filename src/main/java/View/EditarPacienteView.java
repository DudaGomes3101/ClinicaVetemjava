package View;

import Controller.PacienteController;
import Model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditarPacienteView extends JFrame {
    private PacienteController pacienteController;
    private JTextField txtNome;
    private JTextField txtEspecie;
    private JTextField txtRaca;
    private JTextField txtIdade;
    private JTextField txtPeso;
    private JTextField txtHistoricoMedico;
    private JTextField txtVacina;
    private JTextField txtProprietarioNome;
    private JTextField txtProprietarioEndereco;
    private JTextField txtProprietarioTelefone;
    private JTextField txtProprietarioEmail;

    public EditarPacienteView(Connection conexao) {
        this.pacienteController = new PacienteController(conexao);
        int pacienteId = 0;
        Paciente paciente = pacienteController.buscarPacientePorId(pacienteId);

        setTitle("Editar Paciente");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(11, 2));

        // Componentes da view
        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(paciente.getNome());

        JLabel lblEspecie = new JLabel("Espécie:");
        txtEspecie = new JTextField(paciente.getEspecie());

        JLabel lblRaca = new JLabel("Raça:");
        txtRaca = new JTextField(paciente.getRaca());

        JLabel lblIdade = new JLabel("Idade:");
        txtIdade = new JTextField(String.valueOf(paciente.getIdade()));

        JLabel lblPeso = new JLabel("Peso:");
        txtPeso = new JTextField(String.valueOf(paciente.getPeso()));

        JLabel lblHistoricoMedico = new JLabel("Histórico Médico:");
        txtHistoricoMedico = new JTextField(paciente.getHistoricoMedico());

        JLabel lblVacina = new JLabel("Vacina:");
        txtVacina = new JTextField(paciente.getVacina());

        JLabel lblProprietarioNome = new JLabel("Nome do Proprietário:");
        txtProprietarioNome = new JTextField(paciente.getProprietarioNome());

        JLabel lblProprietarioEndereco = new JLabel("Endereço do Proprietário:");
        txtProprietarioEndereco = new JTextField(paciente.getProprietarioEndereco());

        JLabel lblProprietarioTelefone = new JLabel("Telefone do Proprietário:");
        txtProprietarioTelefone = new JTextField(paciente.getProprietarioTelefone());

        JLabel lblProprietarioEmail = new JLabel("Email do Proprietário:");
        txtProprietarioEmail = new JTextField(paciente.getProprietarioEmail());

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(e -> {
            try {
                int idade = Integer.parseInt(txtIdade.getText());
                double peso = Double.parseDouble(txtPeso.getText());
                Paciente pacienteAtualizado = new Paciente(
                        pacienteId,
                        txtNome.getText(),
                        txtEspecie.getText(),
                        txtRaca.getText(),
                        idade,
                        peso,
                        txtHistoricoMedico.getText(),
                        txtVacina.getText(),
                        txtProprietarioNome.getText(),
                        txtProprietarioEndereco.getText(),
                        txtProprietarioTelefone.getText(),
                        txtProprietarioEmail.getText()
                );
                pacienteController.editarPaciente(pacienteAtualizado);
                JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para idade e peso.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(EditarPacienteView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Adicionando componentes à view
        add(lblNome);
        add(txtNome);
        add(lblEspecie);
        add(txtEspecie);
        add(lblRaca);
        add(txtRaca);
        add(lblIdade);
        add(txtIdade);
        add(lblPeso);
        add(txtPeso);
        add(lblHistoricoMedico);
        add(txtHistoricoMedico);
        add(lblVacina);
        add(txtVacina);
        add(lblProprietarioNome);
        add(txtProprietarioNome);
        add(lblProprietarioEndereco);
        add(txtProprietarioEndereco);
        add(lblProprietarioTelefone);
        add(txtProprietarioTelefone);
        add(lblProprietarioEmail);
        add(txtProprietarioEmail);
        add(new JLabel()); // Placeholder
        add(btnAtualizar);

        setVisible(true);
    }

    public EditarPacienteView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
