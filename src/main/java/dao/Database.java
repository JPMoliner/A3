package dao;

import java.util.logging.Level;
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
        logger.log(Level.WARNING, "Utility class");
    }
    
    private static final String URL = "jdbc:sqlite:DataBase.db";
    private static Connection connection = null;
    private static Statement statement = null;

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao conectar ao banco: {0}", e.getMessage());
        }
    }

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
            logger.log(Level.WARNING, "Erro ao executar comando: {0}", e.getMessage());
        }
    }

    public static ResultSet executeQuery(String query) {
        if (statement == null) {
            return null;
        }
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Erro ao executar query: {0}", e.getMessage());
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
            logger.log(Level.WARNING, "Erro ao pegar o prepared statement: {0}", e.getMessage());
        }
        return null;
    }

}
