package Controller;

import Model.Proprietario;
import DAO.ProprietarioDAO;
import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class ProprietarioController {
    private ProprietarioDAO proprietarioDAO;

    public ProprietarioController(Connection conexao) {
        this.proprietarioDAO = new ProprietarioDAO(conexao);
    }

    public void cadastrarProprietario(String nome, String telefone, String endereco) {
        Proprietario proprietario = new Proprietario(0, nome, telefone, endereco); // ID gerado automaticamente
        proprietarioDAO.inserirProprietario(proprietario);
    }

    public void atualizarProprietario(Proprietario proprietario) {
        proprietarioDAO.atualizarProprietario(proprietario);
    }

    public void excluirProprietario(int id) {
        proprietarioDAO.deletarProprietario(id);
    }


    public Proprietario buscarProprietarioPorId(int id) {
        return proprietarioDAO.buscarProprietarioPorId(id);
    }

    public List<Proprietario> listarProprietarios() {
        return proprietarioDAO.listarProprietarios();
    }
    
    public void editarProprietario(int id, String nome, String telefone, String endereco) {
    Proprietario proprietario = new Proprietario(id, nome, telefone, endereco);
    proprietarioDAO.atualizarProprietario(proprietario);
}

}