package Controller;

import DAO.AgendamentoDAO;
import Model.Agendamento;
import java.sql.Connection;
import java.util.List;

public class AgendamentoController {
    private AgendamentoDAO agendamentoDAO;

    public AgendamentoController(Connection conexao) {
        this.agendamentoDAO = new AgendamentoDAO(conexao);
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        agendamentoDAO.inserirAgendamento(agendamento);
    }

    public void atualizarAgendamento(Agendamento agendamento) {
        agendamentoDAO.atualizarAgendamento(agendamento);
    }

    public void deletarAgendamento(int id) {
        agendamentoDAO.deletarAgendamento(id);
    }

    public Agendamento buscarAgendamentoPorId(int id) {
        return agendamentoDAO.buscarAgendamentoPorId(id);
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentoDAO.listarAgendamentos();
    }

    public Agendamento buscarAgendamentoPorPacienteId(int pacienteId) {
        return agendamentoDAO.buscarAgendamentoPorPacienteId(pacienteId);
    }
}
