package dao;


import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;

/**
 * Data Access Object (DAO) responsável por realizar as operações de banco de dados da entidade {@link model.Funcionario}.
 * <p>Disponibiliza métodos estáticos para criar tabela, inserir, atualizar, remover e consultar funcionários.</p>
 */
public class FuncionarioDAO {
    
    /** Logger utilizado para registrar mensagens e exceções da classe. */
    private static Logger logger = Logger.getLogger("FuncionarioDAO");
    
    /**
     * Construtor privado para impedir instanciação, já que todos os métodos são estáticos.
     */
    private FuncionarioDAO(){
        logger.log(Level.WARNING, "Utility class");
    }
    
    /**
     * Cria a tabela <b>Funcionarios</b> no banco de dados caso ainda não exista.
     * <p>Os campos criados são: id, cargo, CPF, PIS, nome e idade.</p>
     */
    public static void initializeDB() {
        Database.executeCommand("CREATE TABLE IF NOT EXISTS Funcionarios (id INTEGER PRIMARY KEY, cargo TEXT, cpf TEXT, pis INTEGER, nome TEXT, idade INTEGER)");
    }

    /**
     * Adiciona um novo funcionário à tabela do banco de dados.
     *
     * @param cargo cargo ocupado pelo funcionário
     * @param cpf CPF do funcionário
     * @param pis número de identificação do PIS
     * @param nome nome completo do funcionário
     * @param idade idade do funcionário
     * @return {@code true} se o funcionário foi adicionado com sucesso ou {@code false} em caso de erro
     */
    public static boolean addFuncionario(String cargo, String cpf, int pis, String nome, int idade) {
        PreparedStatement statement = Database.getPreparedStatement("INSERT INTO Funcionarios (cargo, cpf, pis, nome, idade) VALUES (?, ?, ?, ?, ?)");
        if (statement == null) {
            return false;
        }

        try {
            statement.setString(1, cargo);
            statement.setString(2, cpf);
            statement.setInt(3, pis);
            statement.setString(4, nome);
            statement.setInt(5, idade);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao adicionar funcionario na database: {0}", e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * Retorna uma lista com todos os funcionários cadastrados no banco de dados.
     *
     * @return lista de objetos {@link Funcionario} encontrados ou uma lista vazia se não houver registros
     */
    public static List<Funcionario> getFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();
        ResultSet result = Database.executeQuery("SELECT * FROM Funcionarios");
        if (result == null)
            return funcionarios;

        try {
            while(result.next()) {
                funcionarios.add(new Funcionario(
                        result.getString("cargo"),
                        result.getString("cpf"),
                        result.getInt("pis"),
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getInt("idade")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao pegar funcionario: {0}", e.getMessage());
        }
        
        return funcionarios;
    }
    
    /**
     * Remove um funcionário do banco de dados a partir do seu ID.
     *
     * @param id identificador do funcionário
     * @return {@code true} após a execução do comando de remoção
     */
    public static boolean removeFuncionarioByID(int id){
        Database.executeCommand("DELETE FROM Funcionarios WHERE id = " + id);
        return true;
    }

    
    /**
     * Atualiza os dados de um funcionário existente no banco de dados.
     *
     * @param cargo novo cargo do funcionário
     * @param cpf novo CPF do funcionário
     * @param pis novo número PIS
     * @param nome novo nome do funcionário
     * @param idade nova idade do funcionário
     * @param id ID do funcionário a ser atualizado
     * @return {@code true} se a atualização foi bem-sucedida ou {@code false} em caso de erro
     */
    public static boolean updateFuncionario(String cargo, String cpf, int pis, String nome, int idade, int id){
        PreparedStatement statement = Database.getPreparedStatement("UPDATE Funcionarios SET cargo = ?, cpf = ?, pis = ?, nome = ?, idade = ? WHERE id = ?");
        if (statement == null) {
            return false;
        }
        try {
            statement.setString(1, cargo);
            statement.setString(2, cpf);
            statement.setInt(3, pis);
            statement.setString(4, nome);
            statement.setInt(5, idade);
            statement.setInt(6, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao dar update no funcionario: {0}", e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * Busca um funcionário específico pelo ID.
     *
     * @param id identificador do funcionário
     * @return objeto {@link Funcionario} correspondente ao ID informado ou {@code null} se não for encontrado
     */
    public static Funcionario getFuncionarioByID(int id){
        ResultSet result = Database.executeQuery("SELECT * FROM Funcionarios WHERE id = " + id);
        if (result == null)
            return null;
        try {
            if (result.next()) {
                return new Funcionario(
                    result.getString("cargo"),
                    result.getString("cpf"),
                    result.getInt("pis"),
                    result.getInt("id"),
                    result.getString("nome"),
                    result.getInt("idade")
                );
            } else {
                logger.log(Level.WARNING, "Nenhum aluno encontrada com ID {0}",  id);
                return null;
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao pegar aluno: {0}", e.getMessage());
            return null;
        }
    }
}    
