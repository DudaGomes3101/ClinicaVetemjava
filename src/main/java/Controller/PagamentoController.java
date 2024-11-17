package Controller;

import Model.Pagamento;
import DAO.PagamentoDAO;
import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class PagamentoController {
    private PagamentoDAO pagamentoDAO;

    public PagamentoController(Connection conexao) {
        this.pagamentoDAO = new PagamentoDAO(conexao);
    }

    public void registrarPagamento(int agendamentoId, double valor, String status) {
        Pagamento pagamento = new Pagamento(0, agendamentoId, valor, status); // ID gerado automaticamente
        pagamentoDAO.inserirPagamento(pagamento);
    }

    public void atualizarPagamento(Pagamento pagamento) {
        pagamentoDAO.atualizarPagamento(pagamento);
    }

    public void deletarPagamento(int id) {
        pagamentoDAO.deletarPagamento(id);
    }

    public Pagamento buscarPagamentoPorId(int id) {
        return pagamentoDAO.buscarPagamentoPorId(id);
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoDAO.listarPagamentos();
    }
}
