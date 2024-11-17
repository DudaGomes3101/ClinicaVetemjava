package DAO;

import Model.Proprietario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDAO {
    private Connection conexao;

    public ProprietarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirProprietario(Proprietario proprietario) {
        String sql = "INSERT INTO proprietarios (nome, telefone, endereco) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getTelefone());
            stmt.setString(3, proprietario.getEndereco());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                proprietario.setId(rs.getInt(1)); // Armazenando o ID gerado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarProprietario(Proprietario proprietario) {
        String sql = "UPDATE proprietarios SET nome = ?, telefone = ?, endereco = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getTelefone());
            stmt.setString(3, proprietario.getEndereco());
            stmt.setInt(4, proprietario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarProprietario(int id) {
        String sql = "DELETE FROM proprietarios WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Proprietario buscarProprietarioPorId(int id) {
        String sql = "SELECT * FROM proprietarios WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Proprietario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("endereco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Proprietario> listarProprietarios() {
        List<Proprietario> proprietarios = new ArrayList<>();
        String sql = "SELECT * FROM proprietarios";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Proprietario proprietario = new Proprietario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("endereco")
                );
                proprietarios.add(proprietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proprietarios;
    }
}
