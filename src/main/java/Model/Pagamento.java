package Model;

public class Pagamento {
    private int id;
    private int agendamentoId; // ID da consulta associada
    private double valor;
    private String status;

    // Construtor
    public Pagamento(int id, int agendamentoId, double valor, String status) {
        this.id = id;
        this.agendamentoId = agendamentoId;
        this.valor = valor;
        this.status = status;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAgendamentoId() { return agendamentoId; }
    public void setAgendamentoId(int agendamentoId) { this.agendamentoId = agendamentoId; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
