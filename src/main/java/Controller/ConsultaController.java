package Controller;

import DAO.ConsultaDAO;
import Model.Consulta;

import java.sql.Connection;
import java.util.List;

public class ConsultaController {
    private ConsultaDAO consultaDAO;

    public ConsultaController(Connection conexao) {
        this.consultaDAO = new ConsultaDAO(conexao);
    }

    public List<Consulta> listarConsultas() {
        return consultaDAO.listarConsultas();
    }
}
