package Model;

import java.util.*;
import DAO.FuncionarioDAO;

public class Funcionario extends Pessoa {

    // Atributos
    private String cargo;
    private int PIS;

    // M�todo Construtor de Objeto Vazio
    public Funcionario() {
    }

    // M�todo Construtor de Objeto, inserindo dados
    public Funcionario(String cargo, int PIS) {
        this.cargo = cargo;
        this.PIS = PIS;
    }

    // M�todo Construtor usando tamb�m o construtor da SUPERCLASSE
    public Funcionario(String cargo, String CPF, int PIS, int id, String nome, int idade) {
        super(id, nome, idade, CPF);
        this.cargo = cargo;
        this.PIS = PIS;
    }

    // M�todos GET e SET
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

    // Override necess�rio para poder retornar os dados de Pessoa no toString para aluno.
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

    /*
    
        ABAIXO OS M�TODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    
     */
    /*
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaListaFunc() {
        return FuncionarioDAO.MinhaListaFunc;
    }*/

    // Cadastra novo aluno
    /*public boolean InsertFuncionarioBD(String cargo, String CPF, int PIS, String nome, int idade) {
        int id = this.maiorIDFunc() + 1;
        Funcionario objetoFunc = new Funcionario(cargo, CPF, PIS, id, nome, idade);
        FuncionarioDAO.MinhaListaFunc.add(objetoFunc);
        return true;

    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteFuncBD(int id) {
        int indice = this.procuraIndice(id);
        FuncionarioDAO.MinhaListaFunc.remove(indice);
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateFuncBD(String cargo, String CPF, int PIS, int id, String nome, int idade) {
        Funcionario objetoFunc = new Funcionario(cargo, CPF, PIS, id, nome, idade);
        int indice = this.procuraIndice(id);
        FuncionarioDAO.MinhaListaFunc.set(indice, objetoFunc);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < FuncionarioDAO.MinhaListaFunc.size(); i++) {
            if (FuncionarioDAO.MinhaListaFunc.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    // carrega dados de um aluno espec�fico pelo seu ID
    public Funcionario carregaFunc(int id) {
        int indice = this.procuraIndice(id);
        return FuncionarioDAO.MinhaListaFunc.get(indice);
    }
    
    // retorna o maior ID da nossa base de dados
    public int maiorIDFunc(){
        return FuncionarioDAO.maiorIDFunc();
    }   */
}
