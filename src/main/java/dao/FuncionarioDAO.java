package dao;


import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 

public class FuncionarioDAO {
    
    private static Logger logger = Logger.getLogger("FuncionarioDAO");
    
    private FuncionarioDAO(){
        logger.log(Level.WARNING, "Utility class");
    }
    

    public static void InitializeDB() {
        Database.executeCommand("CREATE TABLE IF NOT EXISTS Funcionarios (id INTEGER PRIMARY KEY, cargo TEXT, CPF TEXT, PIS INTEGER, nome TEXT, idade INTEGER)");
    }

    public static boolean addFuncionario(String cargo, String CPF, int PIS, String nome, int idade) {
        PreparedStatement statement = Database.getPreparedStatement("INSERT INTO Funcionarios (cargo, CPF, PIS, nome, idade) VALUES (?, ?, ?, ?, ?)");
        if (statement == null) {
            return false;
        }

        try {
            statement.setString(1, cargo);
            statement.setString(2, CPF);
            statement.setInt(3, PIS);
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
    
    public static ArrayList<Funcionario> getFuncionarios(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ResultSet result = Database.executeQuery("SELECT * FROM Funcionarios");
        if (result == null)
            return funcionarios;

        try {
            while(result.next()) {
                funcionarios.add(new Funcionario(
                        result.getString("cargo"),
                        result.getString("CPF"),
                        result.getInt("PIS"),
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
    
    public static boolean removeFuncionarioByID(int id){
        Database.executeCommand("DELETE FROM Funcionarios WHERE id = " + id);
        return true;
    }

    
    public static boolean updateFuncionario(String cargo, String CPF, int PIS, String nome, int idade, int id){
        PreparedStatement statement = Database.getPreparedStatement("UPDATE Funcionarios SET cargo = ?, CPF = ?, PIS = ?, nome = ?, idade = ? WHERE id = ?");
        if (statement == null) {
            return false;
        }
        try {
            statement.setString(1, cargo);
            statement.setString(2, CPF);
            statement.setInt(3, PIS);
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
    
    public static Funcionario getFuncionarioByID(int id){
        ResultSet result = Database.executeQuery("SELECT * FROM Funcionarios WHERE id = " + id);
        if (result == null)
            return null;
        try {
            if (result.next()) {
                return new Funcionario(
                    result.getString("cargo"),
                    result.getString("CPF"),
                    result.getInt("PIS"),
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
