package View;

import Controller.ConsultaController;
import Model.Consulta;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.List;

public class VisualizarConsultasView extends JFrame {
    private ConsultaController consultaController;

    public VisualizarConsultasView(Connection conexao) {
        this.consultaController = new ConsultaController(conexao);
        setTitle("Visualizar Consultas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabela para mostrar consultas
        String[] columnNames = {"ID", "Paciente", "Veterinário", "Tipo de Serviço", "Data e Hora", "Status de Pagamento"};
        List<Consulta> consultas = consultaController.listarConsultas();
        String[][] data = new String[consultas.size()][columnNames.length];

        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            data[i][0] = String.valueOf(consulta.getId());
            data[i][1] = consulta.getPaciente();
            data[i][2] = consulta.getVeterinario();
            data[i][3] = consulta.getTipoServico();
            data[i][4] = consulta.getDataHora();
            data[i][5] = consulta.getStatusPagamento();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public VisualizarConsultasView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
