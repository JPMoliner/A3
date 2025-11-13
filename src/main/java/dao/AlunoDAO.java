package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsável pelo acesso e manipulação dos dados de {@link Aluno}
 * no banco de dados.
 * <p>
 * Fornece métodos estáticos para criar a tabela de alunos, inserir novos registros,
 * buscar, atualizar e remover dados da tabela.
 * </p>
 */
public class AlunoDAO {

    /** Logger utilizado para registrar mensagens e erros relacionados ao acesso de dados. */
    private static Logger logger = Logger.getLogger("AlunoDAO");
    
    /**
     * Construtor privado para impedir instanciação da classe.
     * <p>Todos os métodos são estáticos e devem ser acessados diretamente.</p>
     */
    private AlunoDAO(){
        logger.log(Level.WARNING, "Utility class");
    }
    
    /**
     * Cria a tabela <b>Alunos</b> no banco de dados, caso ela ainda não exista.
     * <p>Os campos criados são: id, nome, curso, fase, idade e cpf.</p>
     */
    public static void initializeDB() {
        Database.executeCommand("CREATE TABLE IF NOT EXISTS Alunos (id INTEGER PRIMARY KEY, nome TEXT, curso TEXT, fase INTEGER, idade INTEGER, cpf TEXT)");
    }

     /**
     * Adiciona um novo aluno ao banco de dados.
     *
     * @param curso Curso em que o aluno está matriculado.
     * @param fase Fase (ou semestre) atual do aluno.
     * @param nome Nome completo do aluno.
     * @param idade Idade do aluno.
     * @param cpf CPF do aluno.
     * @return {@code true} se o aluno foi adicionado com sucesso, ou {@code false} em caso de erro.
     */
    public static boolean addAluno(String curso, int fase, String nome, int idade, String cpf) {
        PreparedStatement statement = Database.getPreparedStatement("INSERT INTO Alunos (nome, curso, fase, idade, cpf) VALUES (?, ?, ?, ?, ?)");
        if (statement == null) {
            return false;
        }

        try {
            statement.setString(1, nome);
            statement.setString(2, curso);
            statement.setInt(3, fase);
            statement.setInt(4, idade);
            statement.setString(5, cpf);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao adicionar aluno na database: {0}", e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * Retorna uma lista com todos os alunos cadastrados no banco de dados.
     *
     * @return {@link ArrayList} contendo todos os objetos {@link Aluno} encontrados.
     *         Se não houver alunos, retorna uma lista vazia.
     */
    public static List<Aluno> getAlunos(){
        List<Aluno> alunos = new ArrayList<>();
        ResultSet result = Database.executeQuery("SELECT * FROM Alunos");
        if (result == null)
            return alunos;
        
        try {
            while(result.next()) {
                alunos.add(new Aluno(
                        result.getString("curso"),
                        result.getInt("fase"),
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getInt("idade"),
                        result.getString("cpf")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao pegar alunos: {0}", e.getMessage());
        }
        
        return alunos;
    }
    
    /**
     * Remove um aluno do banco de dados com base no seu ID.
     *
     * @param id Identificador único do aluno a ser removido.
     * @return {@code true} se o aluno foi removido com sucesso.
     */
    public static boolean removeAlunoByID(int id){
        Database.executeCommand("DELETE FROM Alunos WHERE id = " + id);
        return true;
    }

    /**
     * Atualiza as informações de um aluno existente no banco de dados.
     *
     * @param curso Novo curso do aluno.
     * @param fase Nova fase (semestre) do aluno.
     * @param nome Novo nome do aluno.
     * @param idade Nova idade do aluno.
     * @param cpf Novo CPF do aluno.
     * @param id ID do aluno a ser atualizado.
     * @return {@code true} se a atualização foi realizada com sucesso, ou {@code false} em caso de erro.
     */
    public static boolean updateAluno(String curso, int fase, String nome, int idade, String cpf, int id){
        PreparedStatement statement = Database.getPreparedStatement("UPDATE Alunos SET curso = ?, fase = ?, nome = ?, idade = ?, cpf = ? WHERE id = ?");
        if (statement == null) {
            return false;
        }
        try {
            statement.setString(1, curso);
            statement.setInt(2, fase);
            statement.setString(3, nome);
            statement.setInt(4, idade);
            statement.setString(5, cpf);
            statement.setInt(6, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao dar update no aluno: {0}", e.getMessage());
            return false;
        }
        return true;
    }
    
     /**
     * Busca e retorna um aluno do banco de dados com base no seu ID.
     *
     * @param id Identificador único do aluno.
     * @return Objeto {@link Aluno} correspondente ao ID informado,
     *         ou {@code null} se não houver correspondência ou ocorrer um erro.
     */
    public static Aluno getAlunoByID(int id){
        ResultSet result = Database.executeQuery("SELECT * FROM Alunos WHERE id = " + id);
        if (result == null)
            return null;
        try {
            if (result.next()) {
                return new Aluno(
                    result.getString("curso"),
                    result.getInt("fase"),
                    result.getInt("id"),
                    result.getString("nome"),
                    result.getInt("idade"),
                    result.getString("cpf")
                );
            } else {
                logger.log(Level.WARNING, "Nenhum aluno encontrada com ID {0}", id);
                return null;
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao pegar aluno: {0}", e.getMessage());
            return null;
        }
    }
    
}
