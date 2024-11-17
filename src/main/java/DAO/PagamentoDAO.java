package DAO;

import Model.Pagamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {
    private Connection conexao;

    public PagamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirPagamento(Pagamento pagamento) {
        String sql = "INSERT INTO pagamentos (agendamentoId, valor, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pagamento.getAgendamentoId());
            stmt.setDouble(2, pagamento.getValor());
            stmt.setString(3, pagamento.getStatus());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                pagamento.setId(rs.getInt(1)); // Armazenando o ID gerado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPagamento(Pagamento pagamento) {
        String sql = "UPDATE pagamentos SET valor = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDouble(1, pagamento.getValor());
            stmt.setString(2, pagamento.getStatus());
            stmt.setInt(3, pagamento.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPagamento(int id) {
        String sql = "DELETE FROM pagamentos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pagamento buscarPagamentoPorId(int id) {
        String sql = "SELECT * FROM pagamentos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pagamento(
                    rs.getInt("id"),
                    rs.getInt("agendamentoId"),
                    rs.getDouble("valor"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pagamento> listarPagamentos() {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM pagamentos";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                    rs.getInt("id"),
                    rs.getInt("agendamentoId"),
                    rs.getDouble("valor"),
                    rs.getString("status")
                );
                pagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagamentos;
    }
}
