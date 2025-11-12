package model;

/**
 * Classe abstrata que representa uma pessoa genérica no sistema.
 * Contém atributos básicos como ID, nome, idade e CPF.
 * 
 * <p>Esta classe serve como base para outras classes que representam
 * tipos específicos de pessoas, como clientes ou funcionários.</p>
 * 
 */

public abstract class Pessoa {

    /** Identificador único da pessoa. */
    private int id;
    
    /** Nome da pessoa. */
    private String nome;
    
    /** Idade da pessoa em anos. */
    private int idade;
    
    /** CPF (Cadastro de Pessoa Física) da pessoa. */
    private String CPF;

    /**
     * Construtor padrão sem parâmetros.
     * Cria uma instância de {@code Pessoa} vazia.
     */
    public Pessoa() {
    }

    /**
     * Construtor que inicializa todos os atributos da pessoa.
     *
     * @param id identificador único
     * @param nome nome completo
     * @param idade idade em anos
     * @param CPF CPF da pessoa
     */
    public Pessoa(int id, String nome, int idade, String CPF) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
    }

    /**
     * Retorna o identificador da pessoa.
     * 
     * @return o ID da pessoa
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador da pessoa.
     * 
     * @param id novo ID da pessoa
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome da pessoa.
     * 
     * @return o nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * 
     * @param nome novo nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a idade da pessoa.
     * 
     * @return a idade da pessoa
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade da pessoa.
     * 
     * @param idade nova idade da pessoa
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna o CPF da pessoa.
     * 
     * @return o CPF da pessoa
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * Define o CPF da pessoa.
     * 
     * @param CPF novo CPF da pessoa
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    

}
