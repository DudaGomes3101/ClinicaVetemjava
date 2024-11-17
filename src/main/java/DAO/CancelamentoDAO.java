package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancelamentoDAO {
    private Connection conexao;

    public CancelamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cancelarConsulta(int idConsulta, String motivo) {
        String sql = "UPDATE consultas SET status = 'CANCELADA', motivoCancelamento = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, motivo);
            stmt.setInt(2, idConsulta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
