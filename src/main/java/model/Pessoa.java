package model;

public abstract class Pessoa {

    // Atributos
    private int id;
    private String nome;
    private int idade;
    private String CPF;

    // M�todo Construtor de Objeto Vazio
    public Pessoa() {
    }

    // M�todo Construtor de Objeto, inserindo dados
    public Pessoa(int id, String nome, int idade, String CPF) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
    }

    // M�todos GET e SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    

}
