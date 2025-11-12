package model;

/**
 * Classe que representa um aluno do sistema.
 * 
 * <p>Herda os atributos básicos de {@link Pessoa}, como ID, nome, idade e CPF,
 * e adiciona informações específicas de alunos, como curso e fase.</p>
 * 
 * @author Guilhermemhz
 */

public class Aluno extends Pessoa {

    /** Nome do curso em que o aluno está matriculado. */
    private String curso;
    
    /** Fase (ou semestre) atual do aluno. */
    private int fase;

    /**
     * Construtor padrão sem parâmetros.
     * Cria um objeto {@code Aluno} vazio.
     */
    public Aluno() {
    }

    /**
     * Construtor que inicializa apenas os atributos específicos de {@code Aluno}.
     *
     * @param curso nome do curso em que o aluno está matriculado
     * @param fase fase (ou semestre) atual do aluno
     */
    public Aluno(String curso, int fase) {
        this.curso = curso;
        this.fase = fase;
    }

    /**
     * Construtor que inicializa todos os atributos, incluindo os herdados de {@link Pessoa}.
     *
     * @param curso nome do curso em que o aluno está matriculado
     * @param fase fase (ou semestre) atual do aluno
     * @param id identificador único do aluno
     * @param nome nome completo do aluno
     * @param idade idade em anos
     * @param CPF CPF do aluno
     */
    public Aluno(String curso, int fase, int id, String nome, int idade, String CPF) {
        super(id, nome, idade, CPF);
        this.curso = curso;
        this.fase = fase;
    }

    /**
     * Retorna o nome do curso em que o aluno está matriculado.
     * 
     * @return o nome do curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Define o nome do curso em que o aluno está matriculado.
     * 
     * @param curso novo nome do curso
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    /**
     * Retorna a fase (ou semestre) atual do aluno.
     * 
     * @return a fase atual do aluno
     */
    public int getFase() {
        return fase;
    }

    /**
     * Define a fase (ou semestre) atual do aluno.
     * 
     * @param fase nova fase do aluno
     */
    public void setFase(int fase) {
        this.fase = fase;
    }

    /**
     * Retorna uma representação textual do aluno,
     * incluindo informações herdadas da classe {@link Pessoa}.
     * 
     * @return uma string contendo os dados do aluno
     */
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Idade: " + this.getIdade()
                + "\n Curso: " + this.getCurso()
                + "\n Fase:" + this.getFase()
                + "\n -----------";
    }
  
}
