package DAO;

import Model.Consulta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    private Connection conexao;

    public ConsultaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Consulta> listarConsultas() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consultas";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consulta consulta = new Consulta(
                    rs.getInt("id"),
                    rs.getString("paciente"),
                    rs.getString("veterinario"),
                    rs.getString("tipoServico"),
                    rs.getString("dataHora"),
                    rs.getString("statusPagamento")
                );
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}
