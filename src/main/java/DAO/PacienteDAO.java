package DAO;

import Model.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private Connection connection;

    // Construtor que recebe a conexão
    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar um novo paciente
    public void adicionarPaciente(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO pacientes (nome, especie, raca, idade, peso, historicoMedico, vacina, proprietarioNome, proprietarioEndereco, proprietarioTelefone, proprietarioEmail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, paciente.getNome());
            statement.setString(2, paciente.getEspecie());
            statement.setString(3, paciente.getRaca());
            statement.setInt(4, paciente.getIdade());
            statement.setDouble(5, paciente.getPeso());
            statement.setString(6, paciente.getHistoricoMedico());
            statement.setString(7, paciente.getVacina());
            statement.setString(8, paciente.getProprietarioNome());
            statement.setString(9, paciente.getProprietarioEndereco());
            statement.setString(10, paciente.getProprietarioTelefone());
            statement.setString(11, paciente.getProprietarioEmail());
            statement.executeUpdate();
        }
    }

    // Método para buscar todos os pacientes
    public List<Paciente> listarPacientes() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Paciente paciente = new Paciente(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("especie"),
                    resultSet.getString("raca"),
                    resultSet.getInt("idade"),
                    resultSet.getDouble("peso"),
                    resultSet.getString("historicoMedico"),
                    resultSet.getString("vacina"),
                    resultSet.getString("proprietarioNome"),
                    resultSet.getString("proprietarioEndereco"),
                    resultSet.getString("proprietarioTelefone"),
                    resultSet.getString("proprietarioEmail")
                );
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }

    // Método para atualizar um paciente
    public void atualizarPaciente(Paciente paciente) throws SQLException {
        String sql = "UPDATE pacientes SET nome = ?, especie = ?, raca = ?, idade = ?, peso = ?, historicoMedico = ?, vacina = ?, proprietarioNome = ?, proprietarioEndereco = ?, proprietarioTelefone = ?, proprietarioEmail = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, paciente.getNome());
            statement.setString(2, paciente.getEspecie());
            statement.setString(3, paciente.getRaca());
            statement.setInt(4, paciente.getIdade());
            statement.setDouble(5, paciente.getPeso());
            statement.setString(6, paciente.getHistoricoMedico());
            statement.setString(7, paciente.getVacina());
            statement.setString(8, paciente.getProprietarioNome());
            statement.setString(9, paciente.getProprietarioEndereco());
            statement.setString(10, paciente.getProprietarioTelefone());
            statement.setString(11, paciente.getProprietarioEmail());
            statement.setInt(12, paciente.getId());
            statement.executeUpdate();
        }
    }

    // Método para excluir um paciente
    public void excluirPaciente(int id) throws SQLException {
        String sql = "DELETE FROM pacientes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    
    public List<Paciente> buscarPacientePorNome(String nome) throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes WHERE nome LIKE ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%"); // Usa LIKE para buscar parte do nome
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente(
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
                pacientes.add(paciente);
            }
        }

        return pacientes;
    }
}