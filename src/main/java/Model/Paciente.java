package Model;

public class Paciente {
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;
    private String historicoMedico;
    private String vacina;
    private String proprietarioNome;
    private String proprietarioEndereco;
    private String proprietarioTelefone;
    private String proprietarioEmail;

    // Construtor
    public Paciente(int id, String nome, String especie, String raca, int idade, double peso, 
                    String historicoMedico, String vacina, String proprietarioNome, 
                    String proprietarioEndereco, String proprietarioTelefone, String proprietarioEmail) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.historicoMedico = historicoMedico;
        this.vacina = vacina;
        this.proprietarioNome = proprietarioNome;
        this.proprietarioEndereco = proprietarioEndereco;
        this.proprietarioTelefone = proprietarioTelefone;
        this.proprietarioEmail = proprietarioEmail;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getHistoricoMedico() { return historicoMedico; }
    public void setHistoricoMedico(String historicoMedico) { this.historicoMedico = historicoMedico; }

    public String getVacina() { return vacina; }
    public void setVacina(String vacina) { this.vacina = vacina; }

    public String getProprietarioNome() { return proprietarioNome; }
    public void setProprietarioNome(String proprietarioNome) { this.proprietarioNome = proprietarioNome; }

    public String getProprietarioEndereco() { return proprietarioEndereco; }
    public void setProprietarioEndereco(String proprietarioEndereco) { this.proprietarioEndereco = proprietarioEndereco; }

    public String getProprietarioTelefone() { return proprietarioTelefone; }
    public void setProprietarioTelefone(String proprietarioTelefone) { this.proprietarioTelefone = proprietarioTelefone; }

    public String getProprietarioEmail() { return proprietarioEmail; }
    public void setProprietarioEmail(String proprietarioEmail) { this.proprietarioEmail = proprietarioEmail; }
}
