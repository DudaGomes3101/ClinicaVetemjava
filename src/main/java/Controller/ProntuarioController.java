package Controller;

import DAO.ProntuarioDAO;
import Model.Prontuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProntuarioController {
    private ProntuarioDAO prontuarioDAO;

    public ProntuarioController(Connection conexao) {
        this.prontuarioDAO = new ProntuarioDAO(conexao);
    }

    // Método para adicionar um prontuário
    public void adicionarProntuario(int pacienteId, java.util.Date dataConsulta, String procedimentoRealizado, String prescricoes, String anexos) {
        Prontuario prontuario = new Prontuario(0, pacienteId, dataConsulta, procedimentoRealizado, prescricoes, anexos);
        try {
            prontuarioDAO.adicionarProntuario(prontuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar prontuários de um paciente
    public List<Prontuario> buscarProntuariosPorPaciente(int pacienteId) {
        try {
            return prontuarioDAO.buscarProntuariosPorPaciente(pacienteId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para atualizar um prontuário
    public void atualizarProntuario(int id, int pacienteId, java.util.Date dataConsulta, String procedimentoRealizado, String prescricoes, String anexos) {
        Prontuario prontuario = new Prontuario(id, pacienteId, dataConsulta, procedimentoRealizado, prescricoes, anexos);
        try {
            prontuarioDAO.atualizarProntuario(prontuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para deletar um prontuário
    public void deletarProntuario(int id) {
        try {
            prontuarioDAO.deletarProntuario(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar um prontuário pelo ID
    public Prontuario buscarProntuarioPorId(int id) {
        try {
            return prontuarioDAO.buscarProntuarioPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
