package Main;

import Controller.RelatorioController;
import View.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import view.ProntuarioView;

public class Main extends JFrame {
    private Connection conexao;

    public Main() {
        try {
        // Usar um caminho absoluto
        conexao = DriverManager.getConnection("jdbc:h2:C:/Users/maria/OneDrive/Documentos/clinica_veterinaria", "sa", "");
        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS pacientes (id INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(255) NOT NULL)");
        JOptionPane.showMessageDialog(this, "Banco de dados criado e conexão realizada com sucesso!");

        // Inicializar interface
        initialize();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // Para ajudar na depuração
    }
}


    private void initialize() {
        setTitle("Sistema de Gestão Veterinária");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Inicializar Botões
        JButton cadastrarPacienteButton = new JButton("Cadastrar Paciente");
        JButton editarPacienteButton = new JButton("Editar Paciente");
        JButton excluirPacienteButton = new JButton("Excluir Paciente");
        JButton cadastrarProprietarioButton = new JButton("Cadastrar Proprietário");
        JButton editarProprietarioButton = new JButton("Editar Proprietário");
        JButton excluirProprietarioButton = new JButton("Excluir Proprietário");
        JButton agendarConsultaButton = new JButton("Agendar Consulta");
        JButton visualizarConsultasButton = new JButton("Visualizar Consultas");
        JButton cancelarConsultaButton = new JButton("Cancelar Consulta");
        JButton atualizarProntuarioButton = new JButton("Atualizar Prontuário");
        JButton gerarRelatorioButton = new JButton("Gerar Relatório");
        JButton registrarPagamentoButton = new JButton("Registrar Pagamento");
        JButton enviarNotificacaoButton = new JButton("Enviar Notificação");

        // Adicionar Ações aos Botões
        cadastrarPacienteButton.addActionListener(e -> new PacienteView(conexao).setVisible(true));
        editarPacienteButton.addActionListener(e -> new EditarPacienteView(conexao).setVisible(true));
        excluirPacienteButton.addActionListener(e -> new ExcluirPacienteView(conexao).setVisible(true));
        cadastrarProprietarioButton.addActionListener(e -> new ProprietarioView(conexao).setVisible(true));
        editarProprietarioButton.addActionListener(e -> new EditarProprietarioView(conexao).setVisible(true));
        excluirProprietarioButton.addActionListener(e -> new ExcluirProprietarioView(conexao).setVisible(true));
        agendarConsultaButton.addActionListener(e -> new AgendamentoView(conexao).setVisible(true));
        visualizarConsultasButton.addActionListener(e -> new VisualizarConsultasView(conexao).setVisible(true));
        cancelarConsultaButton.addActionListener(e -> new CancelarConsultaView(conexao).setVisible(true));
        atualizarProntuarioButton.addActionListener(e -> new ProntuarioView(conexao).setVisible(true));
        gerarRelatorioButton.addActionListener(e -> new RelatorioView((RelatorioController) conexao).setVisible(true));
        registrarPagamentoButton.addActionListener(e -> new PagamentoView(conexao).setVisible(true));
        enviarNotificacaoButton.addActionListener(e -> new NotificacaoView(conexao).setVisible(true));

        // Adicionar Botões à Janela
        add(cadastrarPacienteButton);
        add(editarPacienteButton);
        add(excluirPacienteButton);
        add(cadastrarProprietarioButton);
        add(editarProprietarioButton);
        add(excluirProprietarioButton);
        add(agendarConsultaButton);
        add(visualizarConsultasButton);
        add(cancelarConsultaButton);
        add(atualizarProntuarioButton);
        add(gerarRelatorioButton);
        add(registrarPagamentoButton);
        add(enviarNotificacaoButton);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new); // Chama a inicialização da interface gráfica
    }
}