/*
 Aqui vamos simular a persist�ncia de dados.
 */
package DAO;

import Model.Aluno;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {

    public static void InitializeDB() {
        Database.executeCommand("CREATE TABLE IF NOT EXISTS Alunos (id INTEGER PRIMARY KEY, nome TEXT, curso TEXT, fase INTEGER, idade INTEGER, cpf TEXT)");
    }

    public static void addALuno(String curso, int fase, String nome, int idade, String cpf) {
        PreparedStatement statement = Database.getPreparedStatement("INSERT INTO Alunos (nome, curso, fase, idade, cpf) VALUES (?, ?, ?, ?, ?)");
        if (statement == null) {
            return;
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
            System.err.println("Erro ao adicionar aluno na database: " + e.getMessage());
        }

    }
    
    public static ArrayList<Aluno> getAlunos(){
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
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
            System.err.println("Erro ao pegar alunos: " + e.getMessage());
        }
        
        return alunos;
    };

    public static ArrayList<Aluno> MinhaLista = new ArrayList<Aluno>();

    public static int maiorID() {

        int maiorID = 0;
        for (int i = 0; i < MinhaLista.size(); i++) {
            if (MinhaLista.get(i).getId() > maiorID) {
                maiorID = MinhaLista.get(i).getId();
            }
        }
        return maiorID;

    }

}
