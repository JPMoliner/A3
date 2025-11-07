/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Database {

    private static final String URL = "jdbc:sqlite:DataBase.db";
    private static Connection connection = null;
    private static Statement statement = null;

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
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
            System.err.println("Erro ao executar comando: " + e.getMessage());
        }
    }

    public static ResultSet executeQuery(String query) {
        if (statement == null) {
            return null;
        }
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Erro ao executar query: " + e.getMessage());
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
            System.err.println("Erro ao pegar o prepared statement: " + e.getMessage());
        }
        return null;
    }

}
