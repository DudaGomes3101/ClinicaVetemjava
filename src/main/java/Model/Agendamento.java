package Model;

public class Agendamento {
    private int id;
    private int pacienteId; // Adicionado para armazenar o ID do paciente
    private int veterinarioId; // Adicionado para armazenar o ID do veterinário
    private String paciente;
    private String veterinario;
    private String tipoServico;
    private String dataHora;
    private String statusPagamento;

    // Construtor
    public Agendamento(int id, String paciente, String veterinario, String tipoServico, int veterinarioId, String statusPagamento1) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.veterinarioId = veterinarioId;
        this.paciente = paciente;
        this.veterinario = veterinario;
        this.tipoServico = tipoServico;
        this.dataHora = dataHora;
        this.statusPagamento = statusPagamento;
    }

    public Agendamento(int i, String paciente, String veterinario, String tipoServico, String dataHora, String statusPagamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPacienteId() { return pacienteId; } // Método adicionado
    public void setPacienteId(int pacienteId) { this.pacienteId = pacienteId; } // Método adicionado

    public int getVeterinarioId() { return veterinarioId; } // Método adicionado
    public void setVeterinarioId(int veterinarioId) { this.veterinarioId = veterinarioId; } // Método adicionado

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public String getVeterinario() { return veterinario; }
    public void setVeterinario(String veterinario) { this.veterinario = veterinario; }

    public String getTipoServico() { return tipoServico; }
    public void setTipoServico(String tipoServico) { this.tipoServico = tipoServico; }

    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }

    public String getStatusPagamento() { return statusPagamento; }
    public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }
}
