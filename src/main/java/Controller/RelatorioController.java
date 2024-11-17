package Controller;

import DAO.RelatorioDAO;
import Model.Relatorio;
import java.sql.Connection;
import java.util.List;

public class RelatorioController {
    private RelatorioDAO relatorioDAO;

    // Construtor
    public RelatorioController(Connection conexao) {
        this.relatorioDAO = new RelatorioDAO(conexao);
    }

    // Método para adicionar um relatório
    public void adicionarRelatorio(Relatorio relatorio) {
        relatorioDAO.adicionarRelatorio(relatorio);
    }

    // Método para listar todos os relatórios
    public List<Relatorio> listarRelatorios() {
        return relatorioDAO.listarRelatorios();
    }

    // Método para buscar relatório por ID
    public Relatorio buscarRelatorioPorId(int id) {
        return relatorioDAO.buscarRelatorioPorId(id);
    }

    // Método para atualizar um relatório
    public void atualizarRelatorio(Relatorio relatorio) {
        relatorioDAO.atualizarRelatorio(relatorio);
    }

    // Método para excluir um relatório
    public void excluirRelatorio(int id) {
        relatorioDAO.excluirRelatorio(id);
    }
}
