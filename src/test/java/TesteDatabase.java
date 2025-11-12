import dao.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class TesteDatabase {

    private static final String IN_MEMORY_DB = "jdbc:sqlite::memory:";

    @BeforeEach
    public void setUp() {
        Database.createConnection(IN_MEMORY_DB);
    }
    
    @AfterEach
    public void tearDown() throws SQLException {
        // Garante que a conexão seja fechada após cada teste
        if (Database.getConection() != null && !Database.getConection().isClosed()) {
            Database.getConection().close();
        }
    }

    @Test
    void testGetConection() {
        // Teste simples para o getConection()
        // O ERRO ESTAVA AQUI:
        assertNotNull(Database.getConection()); 
    }

    @Test
    void testMethodsWithClosedConnection() throws SQLException {
        // Testa o que acontece se a conexão for fechada
        assertNotNull(Database.getConection());
        Database.getConection().close(); // Força o fechamento

        // Agora, todas as operações devem falhar e cair nos blocos 'catch'
        
        // Testa executeCommand (linha 57 do Database.java)
        Database.executeCommand("SELECT 1"); 
        
        // Testa executeQuery (linha 70 do Database.java)
        assertNull(Database.executeQuery("SELECT 1"));

        // Testa getPreparedStatement (linha 83 do Database.java)
        assertNull(Database.getPreparedStatement("SELECT 1"));
    }
}