package dao;


import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Database {

    private static Logger logger = Logger.getLogger("Database");
     
    private Database(){
        logger.info("Utility class");
    }
    
    // URL Padrão
    private static final String DEFAULT_URL = "jdbc:sqlite:DataBase.db";
    private static Connection connection = null;
    private static Statement statement = null;

    // Método original, agora chama o método sobrecarregado
    public static void createConnection() {
        createConnection(DEFAULT_URL);
    }

    // Novo método sobrecarregado para testes (esta é a nossa modificação)
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

    //
    // AQUI ESTÃO OS MÉTODOS QUE FALTAVAM:
    //

    public static Connection getConection() {
        return connection;
    }

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