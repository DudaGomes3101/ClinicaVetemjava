package Model;

public class Notificacao {
    private int id;
    private int idPaciente;
    private String mensagem;
    private String data;

    // Construtor
    public Notificacao(int id, int idPaciente, String mensagem, String data) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.mensagem = mensagem;
        this.data = data;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}
