package DAO;

import Model.Agendamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {
    private Connection conexao;

    public AgendamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (data, hora, pacienteId, veterinarioId, statusPagamento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, agendamento.getDataHora());  
            stmt.setString(2, agendamento.getDataHora()); 
            stmt.setInt(3, agendamento.getPacienteId()); 
            stmt.setInt(4, agendamento.getVeterinarioId()); 
            stmt.setString(5, agendamento.getStatusPagamento());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                agendamento.setId(rs.getInt(1)); // Armazenando o ID gerado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarAgendamento(Agendamento agendamento) {
        String sql = "UPDATE agendamentos SET data = ?, hora = ?, pacienteId = ?, veterinarioId = ?, statusPagamento = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, agendamento.getDataHora());
            stmt.setString(2, agendamento.getDataHora());
            stmt.setInt(3, agendamento.getPacienteId());
            stmt.setInt(4, agendamento.getVeterinarioId());
            stmt.setString(5, agendamento.getStatusPagamento());
            stmt.setInt(6, agendamento.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarAgendamento(int id) {
        String sql = "DELETE FROM agendamentos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Agendamento buscarAgendamentoPorId(int id) {
        String sql = "SELECT * FROM agendamentos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String statusPagamento = null;
                return new Agendamento(
                    rs.getInt("id"),
                    rs.getString("data"),
                    rs.getString("hora"),
                        rs.getString("statusPagamento") // Adicionando statusPagamento
,
                    rs.getInt("veterinarioId"), statusPagamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Agendamento> listarAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamentos";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String statusPagamento = null;
                Agendamento agendamento = new Agendamento(
                    rs.getInt("id"),
                    rs.getString("data"),
                    rs.getString("hora"),
                        rs.getString("statusPagamento") // Adicionando statusPagamento
,
                    rs.getInt("veterinarioId"), statusPagamento);
                agendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendamentos;
    }

    public Agendamento buscarAgendamentoPorPacienteId(int pacienteId) {
        String sql = "SELECT * FROM agendamentos WHERE pacienteId = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pacienteId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String statusPagamento = null;
                return new Agendamento(
                    rs.getInt("id"),
                    rs.getString("data"),
                    rs.getString("hora"),
                        rs.getString("statusPagamento") // Adicionando statusPagamento
,
                    rs.getInt("veterinarioId"), statusPagamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
