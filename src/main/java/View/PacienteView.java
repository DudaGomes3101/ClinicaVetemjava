package View;

import Controller.PacienteController;
import Model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PacienteView extends JFrame {
    private PacienteController pacienteController;

    // Componentes da interface
    private JTextField txtNome;
    private JTextField txtEspecie;
    private JTextField txtRaca;
    private JTextField txtIdade;
    private JTextField txtPeso;
    private JTextArea txtHistorico;
    private JTextField txtVacina;
    private JButton btnAdicionar;
    private JButton btnListar;
    private JList<Paciente> listPacientes; // Lista para exibir pacientes
    private DefaultListModel<Paciente> listModel;

    public PacienteView(Connection conexao) {
        // Inicializa o controlador
        this.pacienteController = new PacienteController(conexao);

        // Configuração da janela
        setTitle("Gerenciamento de Pacientes");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Criação dos componentes
        criarComponentes();

        // Exibe a janela
        setVisible(true);
    }

    public PacienteView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void criarComponentes() {
        // Campos de entrada
        txtNome = new JTextField(20);
        txtEspecie = new JTextField(20);
        txtRaca = new JTextField(20);
        txtIdade = new JTextField(20);
        txtPeso = new JTextField(20);
        txtHistorico = new JTextArea(5, 20);
        txtVacina = new JTextField(20);
        btnAdicionar = new JButton("Adicionar Paciente");
        btnListar = new JButton("Listar Pacientes");
        listModel = new DefaultListModel<>();
        listPacientes = new JList<>(listModel);

        // Adicionando os componentes à janela
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Espécie:"));
        add(txtEspecie);
        add(new JLabel("Raça:"));
        add(txtRaca);
        add(new JLabel("Idade:"));
        add(txtIdade);
        add(new JLabel("Peso:"));
        add(txtPeso);
        add(new JLabel("Histórico Médico:"));
        add(txtHistorico);
        add(new JLabel("Vacina:"));
        add(txtVacina);
        add(btnAdicionar);
        add(btnListar);
        add(new JScrollPane(listPacientes)); // Adiciona a lista de pacientes

        // Adicionando ActionListeners
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPaciente();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPacientes();
            }
        });
    }

    private void adicionarPaciente() {
        // Captura dados da interface
        String nome = txtNome.getText();
        String especie = txtEspecie.getText();
        String raca = txtRaca.getText();
        int idade = Integer.parseInt(txtIdade.getText());
        double peso = Double.parseDouble(txtPeso.getText());
        String historico = txtHistorico.getText();
        String vacina = txtVacina.getText();

        // Cria um novo paciente
        Paciente novoPaciente = new Paciente(0, nome, especie, raca, idade, peso, historico, vacina, "", "", "", "");
        try {
            pacienteController.adicionarPaciente(novoPaciente);
            JOptionPane.showMessageDialog(this, "Paciente adicionado com sucesso!");
            limparCampos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar paciente: " + e.getMessage());
        }
    }

    private void listarPacientes() {
        try {
            List<Paciente> pacientes = pacienteController.listarPacientes();
            listModel.clear(); // Limpa a lista antes de adicionar novos
            for (Paciente paciente : pacientes) {
                listModel.addElement(paciente); // Adiciona o paciente à lista
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar pacientes: " + e.getMessage());
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtEspecie.setText("");
        txtRaca.setText("");
        txtIdade.setText("");
        txtPeso.setText("");
        txtHistorico.setText("");
        txtVacina.setText("");
    }

    public static void main(String[] args) {
        // A conexão com o banco de dados deve ser passada para a view aqui.
        Connection conexao = null;
        conexao = (Connection) new PacienteView(conexao);
    }
}
