package Controller;

import DAO.CancelamentoDAO;

import java.sql.Connection;

public class CancelamentoController {
    private CancelamentoDAO cancelamentoDAO;

    public CancelamentoController(Connection conexao) {
        this.cancelamentoDAO = new CancelamentoDAO(conexao);
    }

    public void cancelarConsulta(int idConsulta, String motivo) {
        cancelamentoDAO.cancelarConsulta(idConsulta, motivo);
    }
}
