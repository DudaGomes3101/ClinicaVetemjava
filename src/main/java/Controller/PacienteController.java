package Controller;

import Model.Paciente;
import DAO.PacienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private PacienteDAO pacienteDAO;
    private Connection conexao;

    public PacienteController(Connection conexao) {
        this.conexao = conexao;
        this.pacienteDAO = new PacienteDAO(conexao);
    }
    

    // Método para adicionar um novo paciente
    public void adicionarPaciente(Paciente paciente) throws SQLException {
        pacienteDAO.adicionarPaciente(paciente);
    }

    // Método para listar todos os pacientes
    public List<Paciente> listarPacientes() throws SQLException {
        return pacienteDAO.listarPacientes();
    }

    // Método para editar um paciente existente
    public void editarPaciente(Paciente paciente) throws SQLException {
        pacienteDAO.atualizarPaciente(paciente);
    }

    // Método para excluir um paciente
    public void excluirPaciente(int id) throws SQLException {
        pacienteDAO.excluirPaciente(id);
    }

    // Método para pesquisar pacientes por nome
    public List<Paciente> buscarPacientesPorNome(String nome) {
    try {
        return pacienteDAO.buscarPacientePorNome(nome);
    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>(); // Retorna uma lista vazia em caso de erro
    }
    }
    
    // Método para buscar paciente por ID
    public Paciente buscarPacientePorId(int id) {
        Paciente paciente = null;
        String sql = "SELECT * FROM pacientes WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                paciente = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("especie"),
                    rs.getString("raca"),
                    rs.getInt("idade"),
                    rs.getDouble("peso"),
                    rs.getString("historicoMedico"),
                    rs.getString("vacina"),
                    rs.getString("proprietarioNome"),
                    rs.getString("proprietarioEndereco"),
                    rs.getString("proprietarioTelefone"),
                    rs.getString("proprietarioEmail")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }
}
