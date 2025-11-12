import dao.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteDatabase {

    private static final String IN_MEMORY_DB = "jdbc:sqlite::memory:";

    @BeforeEach
    public void setUp() {
        // Conecta ao banco de dados em memória
        Database.createConnection(IN_MEMORY_DB);
    }

    @Test
    void testExecuteQueryThrowsException() {
        // 1. Cria um comando SQL sintaticamente inválido
        String badSql = "SELECT FROM TabelaQueNaoExiste";
        
        // 2. Executa a query
        //    Esperamos que ela falhe (lance SQLException)
        //    e que o método 'Database.java' capture a exceção (linha 70)
        //    e retorne 'null' (linha 72)
        assertNull(Database.executeQuery(badSql));
    }

    @Test
    void testGetPreparedStatementThrowsException() {
        // 1. Cria um comando SQL sintaticamente inválido
        String badSql = "INSERT INTO TabelaQueNaoExiste (coluna)";
        
        // 2. Tenta preparar o statement
        //    Esperamos que falhe (lance SQLException)
        //    e que o método 'Database.java' capture a exceção (linha 83)
        //    e retorne 'null' (linha 85)
        assertNull(Database.getPreparedStatement(badSql));
    }
    
    @Test
    void testExecuteCommandThrowsException() {
        // 1. Cria um comando SQL sintaticamente inválido
        String badSql = "DROP TABELA TabelaQueNaoExiste";
        
        // 2. Executa o comando e apenas garante que não quebra a aplicação
        //    (O método executeCommand não retorna nada, só loga o erro)
        Database.executeCommand(badSql);
        
        // Teste de cobertura simples para o getConection()
        assertNotNull(Database.getConection());
    }
}