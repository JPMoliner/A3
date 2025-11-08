package Model;

import java.util.*;
import DAO.AlunoDAO;

public class Aluno extends Pessoa {

    // Atributos
    private String curso;
    private int fase;

    // M�todo Construtor de Objeto Vazio
    public Aluno() {
    }

    // M�todo Construtor de Objeto, inserindo dados
    public Aluno(String curso, int fase) {
        this.curso = curso;
        this.fase = fase;
    }

    // M�todo Construtor usando tamb�m o construtor da SUPERCLASSE
    public Aluno(String curso, int fase, int id, String nome, int idade, String CPF) {
        super(id, nome, idade, CPF);
        this.curso = curso;
        this.fase = fase;
    }

    // M�todos GET e SET
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    // Override necess�rio para poder retornar os dados de Pessoa no toString para aluno.
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
