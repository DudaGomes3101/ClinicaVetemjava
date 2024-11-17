package Model;

public class Consulta {
    private int id;
    private String paciente;
    private String veterinario;
    private String tipoServico;
    private String dataHora;
    private String statusPagamento;

    // Construtor
    public Consulta(int id, String paciente, String veterinario, String tipoServico, String dataHora, String statusPagamento) {
        this.id = id;
        this.paciente = paciente;
        this.veterinario = veterinario;
        this.tipoServico = tipoServico;
        this.dataHora = dataHora;
        this.statusPagamento = statusPagamento;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
