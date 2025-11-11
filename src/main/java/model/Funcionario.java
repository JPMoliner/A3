package model;



public class Funcionario extends Pessoa {

    // Atributos
    private String cargo;
    private int PIS;

    // Método Construtor de Objeto Vazio
    public Funcionario() {
    }

    // Método Construtor de Objeto, inserindo dados
    public Funcionario(String cargo, int PIS) {
        this.cargo = cargo;
        this.PIS = PIS;
    }

    // Método Construtor usando tamb�m o construtor da SUPERCLASSE
    public Funcionario(String cargo, String CPF, int PIS, int id, String nome, int idade) {
        super(id, nome, idade, CPF);
        this.cargo = cargo;
        this.PIS = PIS;
    }

    // Métodos GET e SET
    public String getCargo() {
        return cargo;
    }

    public void setCurso(String cargo) {
        this.cargo = cargo;
    }
    
    public int getPIS() {
        return PIS;
    }
    
    public void setPIS (int PIS) {
        this.PIS = PIS;
    }

    // Override necessário para poder retornar os dados de Pessoa no toString para aluno.
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Idade: " + this.getIdade()
                + "\n Cargo: " + this.getCargo()
                + "\n CPF:" + this.getCPF()
                + "\n PIS:" + this.getPIS()
                + "\n -----------";
    }

}
