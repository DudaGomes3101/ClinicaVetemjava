package Model;

public class Relatorio {
    private int id; // Adicionando o campo ID
    private String dataInicio;
    private String dataFim;
    private String tipoRelatorio;  // Pode ser "Consultas", "Tratamentos", "Exames", etc.
    private String paciente;
    private String veterinario;

    public Relatorio(String dataInicio, String dataFim, String tipoRelatorio, String paciente, String veterinario) {
        this.id = id; // Inicializando o ID
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tipoRelatorio = tipoRelatorio;
        this.paciente = paciente;
        this.veterinario = veterinario;
    }

    // Getters e Setters
    public int getId() { return id; } // Método para obter o ID
    public void setId(int id) { this.id = id; } // Método para definir o ID

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }

    public String getDataFim() { return dataFim; }
    public void setDataFim(String dataFim) { this.dataFim = dataFim; }

    public String getTipoRelatorio() { return tipoRelatorio; }
    public void setTipoRelatorio(String tipoRelatorio) { this.tipoRelatorio = tipoRelatorio; }

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public String getVeterinario() { return veterinario; }
    public void setVeterinario(String veterinario) { this.veterinario = veterinario; }
}
