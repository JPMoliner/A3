package dao;


import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

/**
 * Classe responsável por realizar as operações de acesso ao banco de dados
 * relacionadas à entidade {@link model.Funcionario}.
 * <p>
 * Contém métodos para criar a tabela, inserir, atualizar, remover e buscar
 * funcionários cadastrados.
 * </p>
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
     * Cria a tabela de Funcionários no banco de dados caso ainda não exista.
     * <p>Os campos criados são: id, cargo, cpf, pis, nome e idade.</p>
     */
    public static void initializeDB() {
        Database.executeCommand("CREATE TABLE IF NOT EXISTS Funcionarios (id INTEGER PRIMARY KEY, cargo TEXT, cpf TEXT, pis INTEGER, nome TEXT, idade INTEGER)");
    }

    /**
     * Adiciona um novo funcionário à tabela do banco de dados.
     *
     * @param cargo Cargo ocupado pelo funcionário.
     * @param cpf CPF do funcionário.
     * @param pis Número de identificação do PIS.
     * @param nome Nome completo do funcionário.
     * @param idade Idade do funcionário.
     * @return {@code true} se o funcionário foi adicionado com sucesso, {@code false} caso contrário.
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
     * @return Lista de objetos {@link Funcionario}.
     */
    public static ArrayList<Funcionario> getFuncionarios(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
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
    };
    
    /**
     * Remove um funcionário do banco de dados a partir do seu ID.
     *
     * @param id Identificador do funcionário.
     * @return {@code true} se a remoção foi realizada com sucesso.
     */
    public static boolean removeFuncionarioByID(int id){
        Database.executeCommand("DELETE FROM Funcionarios WHERE id = " + id);
        return true;
    }

    
    /**
     * Atualiza os dados de um funcionário existente no banco de dados.
     *
     * @param cargo Novo cargo do funcionário.
     * @param cpf Novo CPF do funcionário.
     * @param pis Novo número PIS.
     * @param nome Novo nome do funcionário.
     * @param idade Nova idade do funcionário.
     * @param id ID do funcionário a ser atualizado.
     * @return {@code true} se a atualização foi bem-sucedida, {@code false} caso contrário.
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
     * @param id Identificador do funcionário.
     * @return Objeto {@link Funcionario} correspondente ao ID informado,
     *         ou {@code null} se não for encontrado.
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
