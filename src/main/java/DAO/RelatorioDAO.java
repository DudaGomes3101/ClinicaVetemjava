package DAO;

import Model.Relatorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDAO {
    private Connection conexao;

    // Construtor
    public RelatorioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Método para adicionar um relatório
    public void adicionarRelatorio(Relatorio relatorio) {
        String sql = "INSERT INTO relatorios (data_inicio, data_fim, tipo_relatorio, paciente, veterinario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, relatorio.getDataInicio());
            stmt.setString(2, relatorio.getDataFim());
            stmt.setString(3, relatorio.getTipoRelatorio());
            stmt.setString(4, relatorio.getPaciente());
            stmt.setString(5, relatorio.getVeterinario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os relatórios
    public List<Relatorio> listarRelatorios() {
        List<Relatorio> relatorios = new ArrayList<>();
        String sql = "SELECT * FROM relatorios";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Relatorio relatorio = new Relatorio(
                    rs.getString("data_inicio"),
                    rs.getString("data_fim"),
                    rs.getString("tipo_relatorio"),
                    rs.getString("paciente"),
                    rs.getString("veterinario")
                );
                relatorios.add(relatorio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relatorios;
    }

    // Método para buscar relatório por ID
    public Relatorio buscarRelatorioPorId(int id) {
        Relatorio relatorio = null;
        String sql = "SELECT * FROM relatorios WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    relatorio = new Relatorio(
                        rs.getString("data_inicio"),
                        rs.getString("data_fim"),
                        rs.getString("tipo_relatorio"),
                        rs.getString("paciente"),
                        rs.getString("veterinario")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relatorio;
    }

    // Método para atualizar um relatório
    public void atualizarRelatorio(Relatorio relatorio) {
        String sql = "UPDATE relatorios SET data_inicio = ?, data_fim = ?, tipo_relatorio = ?, paciente = ?, veterinario = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, relatorio.getDataInicio());
            stmt.setString(2, relatorio.getDataFim());
            stmt.setString(3, relatorio.getTipoRelatorio());
            stmt.setString(4, relatorio.getPaciente());
            stmt.setString(5, relatorio.getVeterinario());
            stmt.setInt(6, relatorio.getId()); // Assumindo que a classe Relatorio tenha um método getId()
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um relatório
    public void excluirRelatorio(int id) {
        String sql = "DELETE FROM relatorios WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
