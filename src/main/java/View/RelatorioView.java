package View;

import Controller.RelatorioController;
import Model.Relatorio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RelatorioView {
    private RelatorioController relatorioController;

    // Componentes da interface
    private JFrame frame;
    private JTextArea textArea;
    private JTextField dataInicioField;
    private JTextField dataFimField;
    private JTextField tipoRelatorioField;
    private JTextField pacienteField;
    private JTextField veterinarioField;
    private JButton adicionarButton;
    private JButton listarButton;
    private JButton buscarButton;
    private JButton atualizarButton;
    private JButton excluirButton;

    public RelatorioView(RelatorioController relatorioController) {
        this.relatorioController = relatorioController;

        // Configurações da janela
        frame = new JFrame("Gerenciamento de Relatórios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 2));

        // Criação dos componentes
        dataInicioField = new JTextField("Data Início");
        dataFimField = new JTextField("Data Fim");
        tipoRelatorioField = new JTextField("Tipo de Relatório");
        pacienteField = new JTextField("Paciente");
        veterinarioField = new JTextField("Veterinário");
        textArea = new JTextArea();
        adicionarButton = new JButton("Adicionar Relatório");
        listarButton = new JButton("Listar Relatórios");
        buscarButton = new JButton("Buscar Relatório");
        atualizarButton = new JButton("Atualizar Relatório");
        excluirButton = new JButton("Excluir Relatório");

        // Adiciona os componentes ao frame
        frame.add(dataInicioField);
        frame.add(dataFimField);
        frame.add(tipoRelatorioField);
        frame.add(pacienteField);
        frame.add(veterinarioField);
        frame.add(textArea);
        frame.add(adicionarButton);
        frame.add(listarButton);
        frame.add(buscarButton);
        frame.add(atualizarButton);
        frame.add(excluirButton);

        // Adiciona os listeners
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarRelatorio();
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarRelatorios();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRelatorio();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarRelatorio();
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirRelatorio();
            }
        });

        // Mostra a janela
        frame.setVisible(true);
    }

    public RelatorioView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Método para adicionar relatório
    private void adicionarRelatorio() {
        String dataInicio = dataInicioField.getText();
        String dataFim = dataFimField.getText();
        String tipoRelatorio = tipoRelatorioField.getText();
        String paciente = pacienteField.getText();
        String veterinario = veterinarioField.getText();
        
        Relatorio relatorio = new Relatorio(dataInicio, dataFim, tipoRelatorio, paciente, veterinario);
        relatorioController.adicionarRelatorio(relatorio);
        JOptionPane.showMessageDialog(frame, "Relatório adicionado!");
        clearFields();
    }

// Método para listar relatórios
private void listarRelatorios() {
    List<Relatorio> relatorios = relatorioController.listarRelatorios();
    textArea.setText(""); // Limpa o campo de texto
    for (Relatorio relatorio : relatorios) {
        textArea.append("Data Início: " + relatorio.getDataInicio() + "\n");
        textArea.append("Data Fim: " + relatorio.getDataFim() + "\n");
        textArea.append("Tipo de Relatório: " + relatorio.getTipoRelatorio() + "\n");
        textArea.append("Paciente: " + relatorio.getPaciente() + "\n");
        textArea.append("Veterinário: " + relatorio.getVeterinario() + "\n");
        textArea.append("----------------------------\n");
    }
}

// Método para buscar relatório
private void buscarRelatorio() {
    String idString = JOptionPane.showInputDialog("Digite o ID do relatório:");
    int id = Integer.parseInt(idString);
    Relatorio relatorio = relatorioController.buscarRelatorioPorId(id);
    if (relatorio != null) {
        textArea.setText("Data Início: " + relatorio.getDataInicio() + "\n");
        textArea.append("Data Fim: " + relatorio.getDataFim() + "\n");
        textArea.append("Tipo de Relatório: " + relatorio.getTipoRelatorio() + "\n");
        textArea.append("Paciente: " + relatorio.getPaciente() + "\n");
        textArea.append("Veterinário: " + relatorio.getVeterinario() + "\n");
    } else {
        JOptionPane.showMessageDialog(frame, "Relatório não encontrado!");
    }
}

// Método para atualizar relatório
private void atualizarRelatorio() {
    String idString = JOptionPane.showInputDialog("Digite o ID do relatório para atualizar:");
    int id = Integer.parseInt(idString);
    Relatorio relatorio = relatorioController.buscarRelatorioPorId(id);
    if (relatorio != null) {
        String dataInicio = dataInicioField.getText();
        String dataFim = dataFimField.getText();
        String tipoRelatorio = tipoRelatorioField.getText();
        String paciente = pacienteField.getText();
        String veterinario = veterinarioField.getText();
        
        relatorio.setDataInicio(dataInicio);
        relatorio.setDataFim(dataFim);
        relatorio.setTipoRelatorio(tipoRelatorio);
        relatorio.setPaciente(paciente);
        relatorio.setVeterinario(veterinario);
        
        relatorioController.atualizarRelatorio(relatorio);
        JOptionPane.showMessageDialog(frame, "Relatório atualizado!");
        clearFields();
    } else {
        JOptionPane.showMessageDialog(frame, "Relatório não encontrado!");
    }
}

// Método para excluir relatório
private void excluirRelatorio() {
    String idString = JOptionPane.showInputDialog("Digite o ID do relatório para excluir:");
    int id = Integer.parseInt(idString);
    relatorioController.excluirRelatorio(id);
    JOptionPane.showMessageDialog(frame, "Relatório excluído!");
    clearFields();
}

// Método para limpar os campos
private void clearFields() {
    dataInicioField.setText("");
    dataFimField.setText("");
    tipoRelatorioField.setText("");
    pacienteField.setText("");
    veterinarioField.setText("");
}

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
