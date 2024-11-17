package DAO;

import Model.Notificacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotificacaoDAO {
    private Connection conexao;

    public NotificacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void enviarNotificacao(Notificacao notificacao) {
        String sql = "INSERT INTO notificacoes (idPaciente, mensagem, data) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, notificacao.getIdPaciente());
            stmt.setString(2, notificacao.getMensagem());
            stmt.setString(3, notificacao.getData());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
