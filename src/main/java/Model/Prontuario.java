package Model;

import java.util.Date;

public class Prontuario {
    private int id;
    private int pacienteId; // ID do paciente relacionado
    private Date dataConsulta;
    private String procedimentoRealizado;
    private String prescricoes;
    private String anexos; // Pode ser uma URL ou caminho para documentos anexados

    // Construtor
    public Prontuario(int id, int pacienteId, Date dataConsulta, String procedimentoRealizado, String prescricoes, String anexos) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.dataConsulta = dataConsulta;
        this.procedimentoRealizado = procedimentoRealizado;
        this.prescricoes = prescricoes;
        this.anexos = anexos;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPacienteId() { return pacienteId; }
    public void setPacienteId(int pacienteId) { this.pacienteId = pacienteId; }

    public Date getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(Date dataConsulta) { this.dataConsulta = dataConsulta; }

    public String getProcedimentoRealizado() { return procedimentoRealizado; }
    public void setProcedimentoRealizado(String procedimentoRealizado) { this.procedimentoRealizado = procedimentoRealizado; }

    public String getPrescricoes() { return prescricoes; }
    public void setPrescricoes(String prescricoes) { this.prescricoes = prescricoes; }

    public String getAnexos() { return anexos; }
    public void setAnexos(String anexos) { this.anexos = anexos; }
}
