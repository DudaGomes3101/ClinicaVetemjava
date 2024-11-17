package DAO;

import Model.Prontuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {
    private Connection conexao;

    public ProntuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Método para adicionar um prontuário
    public void adicionarProntuario(Prontuario prontuario) throws SQLException {
        String sql = "INSERT INTO prontuarios (pacienteId, dataConsulta, procedimentoRealizado, prescricoes, anexos) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, prontuario.getPacienteId());
            stmt.setDate(2, new java.sql.Date(prontuario.getDataConsulta().getTime()));
            stmt.setString(3, prontuario.getProcedimentoRealizado());
            stmt.setString(4, prontuario.getPrescricoes());
            stmt.setString(5, prontuario.getAnexos());
            stmt.executeUpdate();
        }
    }

    // Método para buscar prontuários de um paciente
    public List<Prontuario> buscarProntuariosPorPaciente(int pacienteId) throws SQLException {
        List<Prontuario> prontuarios = new ArrayList<>();
        String sql = "SELECT * FROM prontuarios WHERE pacienteId = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pacienteId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Prontuario prontuario = new Prontuario(
                        rs.getInt("id"),
                        rs.getInt("pacienteId"),
                        rs.getDate("dataConsulta"),
                        rs.getString("procedimentoRealizado"),
                        rs.getString("prescricoes"),
                        rs.getString("anexos")
                );
                prontuarios.add(prontuario);
            }
        }

        return prontuarios;
    }

    // Método para atualizar um prontuário
    public void atualizarProntuario(Prontuario prontuario) throws SQLException {
        String sql = "UPDATE prontuarios SET pacienteId = ?, dataConsulta = ?, procedimentoRealizado = ?, prescricoes = ?, anexos = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, prontuario.getPacienteId());
            stmt.setDate(2, new java.sql.Date(prontuario.getDataConsulta().getTime()));
            stmt.setString(3, prontuario.getProcedimentoRealizado());
            stmt.setString(4, prontuario.getPrescricoes());
            stmt.setString(5, prontuario.getAnexos());
            stmt.setInt(6, prontuario.getId());
            stmt.executeUpdate();
        }
    }

    // Método para deletar um prontuário
    public void deletarProntuario(int id) throws SQLException {
        String sql = "DELETE FROM prontuarios WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método para buscar um prontuário pelo ID
    public Prontuario buscarProntuarioPorId(int id) throws SQLException {
        String sql = "SELECT * FROM prontuarios WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Prontuario(
                        rs.getInt("id"),
                        rs.getInt("pacienteId"),
                        rs.getDate("dataConsulta"),
                        rs.getString("procedimentoRealizado"),
                        rs.getString("prescricoes"),
                        rs.getString("anexos")
                );
            }
        }
        return null;
    }
}
