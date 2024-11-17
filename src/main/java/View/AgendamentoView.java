package View;

import Controller.AgendamentoController;
import Model.Agendamento;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class AgendamentoView {
    private AgendamentoController agendamentoController;
    private Scanner scanner;

    public AgendamentoView(Connection conexao) {
        this.agendamentoController = new AgendamentoController(conexao);
        this.scanner = new Scanner(System.in);
    }

    public AgendamentoView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("===== Menu de Agendamentos =====");
            System.out.println("1. Adicionar Agendamento");
            System.out.println("2. Atualizar Agendamento");
            System.out.println("3. Deletar Agendamento");
            System.out.println("4. Listar Agendamentos");
            System.out.println("5. Buscar Agendamento por ID");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarAgendamento();
                    break;
                case 2:
                    atualizarAgendamento();
                    break;
                case 3:
                    deletarAgendamento();
                    break;
                case 4:
                    listarAgendamentos();
                    break;
                case 5:
                    buscarAgendamentoPorId();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarAgendamento() {
        System.out.print("Digite o nome do paciente: ");
        String paciente = scanner.nextLine();
        System.out.print("Digite o nome do veterinário: ");
        String veterinario = scanner.nextLine();
        System.out.print("Digite o tipo de serviço: ");
        String tipoServico = scanner.nextLine();
        System.out.print("Digite a data e hora: ");
        String dataHora = scanner.nextLine();
        System.out.print("Digite o status do pagamento: ");
        String statusPagamento = scanner.nextLine();

        Agendamento agendamento = new Agendamento(0, paciente, veterinario, tipoServico, dataHora, statusPagamento);
        agendamentoController.adicionarAgendamento(agendamento);
        System.out.println("Agendamento adicionado com sucesso!");
    }

    private void atualizarAgendamento() {
        System.out.print("Digite o ID do agendamento que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Digite o novo nome do paciente: ");
        String paciente = scanner.nextLine();
        System.out.print("Digite o novo nome do veterinário: ");
        String veterinario = scanner.nextLine();
        System.out.print("Digite o novo tipo de serviço: ");
        String tipoServico = scanner.nextLine();
        System.out.print("Digite a nova data e hora: ");
        String dataHora = scanner.nextLine();
        System.out.print("Digite o novo status do pagamento: ");
        String statusPagamento = scanner.nextLine();

        Agendamento agendamento = new Agendamento(id, paciente, veterinario, tipoServico, dataHora, statusPagamento);
        agendamentoController.atualizarAgendamento(agendamento);
        System.out.println("Agendamento atualizado com sucesso!");
    }

    private void deletarAgendamento() {
        System.out.print("Digite o ID do agendamento que deseja deletar: ");
        int id = scanner.nextInt();
        agendamentoController.deletarAgendamento(id);
        System.out.println("Agendamento deletado com sucesso!");
    }

    private void listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoController.listarAgendamentos();
        for (Agendamento agendamento : agendamentos) {
            System.out.println("ID: " + agendamento.getId() + ", Paciente: " + agendamento.getPaciente() +
                ", Veterinário: " + agendamento.getVeterinario() + ", Tipo de Serviço: " + agendamento.getTipoServico() +
                ", Data e Hora: " + agendamento.getDataHora() + ", Status de Pagamento: " + agendamento.getStatusPagamento());
        }
    }

    private void buscarAgendamentoPorId() {
        System.out.print("Digite o ID do agendamento: ");
        int id = scanner.nextInt();
        Agendamento agendamento = agendamentoController.buscarAgendamentoPorId(id);
        if (agendamento != null) {
            System.out.println("ID: " + agendamento.getId() + ", Paciente: " + agendamento.getPaciente() +
                ", Veterinário: " + agendamento.getVeterinario() + ", Tipo de Serviço: " + agendamento.getTipoServico() +
                ", Data e Hora: " + agendamento.getDataHora() + ", Status de Pagamento: " + agendamento.getStatusPagamento());
        } else {
            System.out.println("Agendamento não encontrado.");
        }
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
