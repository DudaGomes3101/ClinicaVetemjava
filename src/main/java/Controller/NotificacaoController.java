package Controller;

import DAO.NotificacaoDAO;
import Model.Notificacao;

import java.sql.Connection;

public class NotificacaoController {
    private NotificacaoDAO notificacaoDAO;

    public NotificacaoController(Connection conexao) {
        this.notificacaoDAO = new NotificacaoDAO(conexao);
    }

    public void enviarNotificacao(int idPaciente, String mensagem, String data) {
        Notificacao notificacao = new Notificacao(0, idPaciente, mensagem, data); // ID gerado pelo banco
        notificacaoDAO.enviarNotificacao(notificacao);
    }
}
