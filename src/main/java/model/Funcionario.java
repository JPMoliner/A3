package model;

/**
 * Classe que representa um funcionário do sistema.
 * 
 * <p>Herda os atributos básicos de {@link Pessoa}, como ID, nome, idade e CPF,
 * e adiciona informações específicas de funcionários, como cargo e PIS.</p>
 * 
 * @author Guilhermemhz
 */

public class Funcionario extends Pessoa {

    /** Cargo ocupado pelo funcionário dentro da empresa. */
    private String cargo;
    
    /** Número do PIS (Programa de Integração Social) do funcionário. */
    private int PIS;

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
     * @param PIS número do PIS do funcionário
     */
    public Funcionario(String cargo, int PIS) {
        this.cargo = cargo;
        this.PIS = PIS;
    }

    /**
     * Construtor que inicializa todos os atributos, incluindo os herdados de {@link Pessoa}.
     *
     * @param cargo cargo ocupado pelo funcionário
     * @param CPF CPF do funcionário
     * @param PIS número do PIS do funcionário
     * @param id identificador único
     * @param nome nome completo
     * @param idade idade em anos
     */
    public Funcionario(String cargo, String CPF, int PIS, int id, String nome, int idade) {
        super(id, nome, idade, CPF);
        this.cargo = cargo;
        this.PIS = PIS;
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
    public int getPIS() {
        return PIS;
    }
    
    /**
     * Define o número do PIS do funcionário.
     * 
     * @param PIS novo número do PIS
     */
    public void setPIS (int PIS) {
        this.PIS = PIS;
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
                + "\n CPF:" + this.getCPF()
                + "\n PIS:" + this.getPIS()
                + "\n -----------";
    }

}
