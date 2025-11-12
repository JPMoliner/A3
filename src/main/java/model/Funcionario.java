package model;

/**
 * Classe que representa um funcionário do sistema.
 * 
 * <p>Herda os atributos básicos de {@link Pessoa}, como ID, nome, idade e cpf,
 * e adiciona informações específicas de funcionários, como cargo e PIS.</p>
 * 
 * @author Guilhermemhz
 */

public class Funcionario extends Pessoa {

    /** Cargo ocupado pelo funcionário dentro da empresa. */
    private String cargo;
    
    /** Número do PIS (Programa de Integração Social) do funcionário. */
    private int pis;

    /**
     * Construtor padrão sem parâmetros.
     * Cria um objeto {@code Funcionario} vazio.
     */
    public Funcionario() {
    }

    /**
     * Construtor que inicializa apenas os atributos específicos de {@code Funcionario}.
     *
     * @param cargo cargo ocupado pelo funcionário
     * @param pis número do PIS do funcionário
     */
    public Funcionario(String cargo, int pis) {
        this.cargo = cargo;
        this.pis = pis;
    }

    /**
     * Construtor que inicializa todos os atributos, incluindo os herdados de {@link Pessoa}.
     *
     * @param cargo cargo ocupado pelo funcionário
     * @param cpf cpf do funcionário
     * @param pis número do PIS do funcionário
     * @param id identificador único
     * @param nome nome completo
     * @param idade idade em anos
     */
    public Funcionario(String cargo, String cpf, int pis, int id, String nome, int idade) {
        super(id, nome, idade, cpf);
        this.cargo = cargo;
        this.pis = pis;
    }

    /**
     * Retorna o cargo do funcionário.
     * 
     * @return o cargo do funcionário
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Define o cargo do funcionário.
     * 
     * @param cargo novo cargo do funcionário
     */
    public void setCurso(String cargo) {
        this.cargo = cargo;
    }
    
    /**
     * Retorna o número do PIS do funcionário.
     * 
     * @return o número do PIS
     */
    public int getPis() {
        return pis;
    }
    
    /**
     * Define o número do PIS do funcionário.
     * 
     * @param pis novo número do PIS
     */
    public void setPis (int pis) {
        this.pis = pis;
    }

    /**
     * Retorna uma representação textual do funcionário,
     * incluindo informações herdadas da classe {@link Pessoa}.
     * 
     * @return uma string contendo os dados do funcionário
     */
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Idade: " + this.getIdade()
                + "\n Cargo: " + this.getCargo()
                + "\n CPF:" + this.getCpf()
                + "\n PIS:" + this.getPis()
                + "\n -----------";
    }

}
