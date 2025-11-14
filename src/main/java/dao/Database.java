package dao;


import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * Classe utilitária responsável por gerenciar a conexão com o banco de dados SQLite e executar comandos SQL.
 * <p>Centraliza a criação de conexões e o fornecimento de {@link PreparedStatement}s para as classes DAO do sistema.</p>
 */
public class Database {
    
    /** Logger utilizado para registrar mensagens e erros relacionados ao banco de dados. */
    private static Logger logger = Logger.getLogger("Database");
    
    /**
     * Construtor privado para impedir instanciação.
     * <p>Todos os métodos da classe são estáticos.</p>
     */
    private Database(){
        logger.info("Utility class");
    }
    
    /** URL padrão do banco de dados SQLite. */
    private static final String DEFAULT_URL = "jdbc:sqlite:DataBase.db";
    
    /** Conexão ativa com o banco de dados. */
    private static Connection connection = null;
    
    /** Objeto utilizado para execução de comandos SQL simples. */
    private static Statement statement = null;

    /**
     * Cria uma conexão com o banco de dados utilizando a URL padrão do projeto.
     * <p>Chama internamente o método {@link #createConnection(String)}.</p>
     */
    public static void createConnection() {
        createConnection(DEFAULT_URL);
    }

    /**
     * Cria uma conexão com o banco de dados utilizando a URL informada.
     * <p>Se já existir uma conexão aberta, ela será fechada antes de criar uma nova.</p>
     *
     * @param url caminho ou URL do banco de dados
     */
    public static void createConnection(String url) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (SQLException e) {
            logger.info(String.format("Erro ao conectar ao banco: %s", e.getMessage()));
        }
    }

    /**
     * Retorna o objeto {@link Connection} atual.
     *
     * @return Conexão ativa com o banco de dados, ou {@code null} se não houver conexão.
     */
    public static Connection getConection() {
        return connection;
    }

    /**
     * Executa um comando SQL (como CREATE, INSERT, UPDATE ou DELETE).
     *
     * @param command comando SQL a ser executado
     */
    public static void executeCommand(String command) {
        if (statement == null) {
            return;
        }
        try {
            statement.execute(command);
        } catch (SQLException e) {
            logger.info(String.format("Erro ao executar comando: %s", e.getMessage()));
        }
    }

    /**
     * Executa uma consulta SQL e retorna o resultado.
     *
     * @param query consulta SQL (SELECT) a ser executada
     * @return objeto {@link ResultSet} contendo os resultados da consulta ou {@code null} em caso de erro
     */
    public static ResultSet executeQuery(String query) {
        if (statement == null) {
            return null;
        }
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            logger.info(String.format("Erro ao executar query: %s", e.getMessage()));
        }
        return null;
    }

    /**
     * Retorna um objeto {@link PreparedStatement} para execução de comandos SQL parametrizados.
     *
     * @param command comando SQL parametrizado
     * @return objeto {@link PreparedStatement} configurado ou {@code null} em caso de erro
     */
    public static PreparedStatement getPreparedStatement(String command) {
        if (connection == null) {
            return null;
        }
        try {
            return connection.prepareStatement(command);
        } catch (SQLException e) {
            logger.info(String.format("Erro ao pegar o prepared statement: %s", e.getMessage()));
        }
        return null;
    }

}
