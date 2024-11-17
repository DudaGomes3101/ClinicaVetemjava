package Model;

public class Cancelamento {
    private int idConsulta;
    private String motivo;

    // Construtor
    public Cancelamento(int idConsulta, String motivo) {
        this.idConsulta = idConsulta;
        this.motivo = motivo;
    }

    // Getters e Setters
    public int getIdConsulta() { return idConsulta; }
    public void setIdConsulta(int idConsulta) { this.idConsulta = idConsulta; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}
