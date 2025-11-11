package dao;


import java.util.logging.Logger;
import model.Aluno;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {

    private static Logger logger = Logger.getLogger("AlunoDAO");
    
    private AlunoDAO(){
        logger.info("Utility class");
    }
    
    public static void InitializeDB() {
        Database.executeCommand("CREATE TABLE IF NOT EXISTS Alunos (id INTEGER PRIMARY KEY, nome TEXT, curso TEXT, fase INTEGER, idade INTEGER, cpf TEXT)");
    }

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
            logger.info(String.format("Erro ao adicionar aluno na database: %s", e.getMessage()));
            return false;
        }
        return true;
    }
    
    public static ArrayList<Aluno> getAlunos(){
        ArrayList<Aluno> alunos = new ArrayList<>();
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
            logger.info(String.format("Erro ao pegar alunos: %s", e.getMessage()));
        }
        
        return alunos;
    }
    
    public static boolean removeAlunoByID(int id){
        Database.executeCommand("DELETE FROM Alunos WHERE id = " + id);
        return true;
    }

    
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
            logger.info(String.format("Erro ao dar update no aluno: %s", e.getMessage()));
            return false;
        }
        return true;
    }
    
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
                logger.info(String.format("Nenhum aluno encontrada com ID %d", id));
                return null;
            }
        } catch (SQLException e) {
            logger.info(String.format("Erro ao pegar aluno: %s", e.getMessage()));
            return null;
        }
    }
    

}
