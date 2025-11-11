import dao.FuncionarioDAO;
import dao.Database;
import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TesteFuncionarioDAO {

    // URL do banco de dados em memória
    private static final String IN_MEMORY_DB = "jdbc:sqlite::memory:";

    @BeforeEach
    public void setUp() {
        // 1. Conecta ao banco de dados em memória
        Database.createConnection(IN_MEMORY_DB);
        
        // 2. Cria a tabela 'Funcionarios'
        FuncionarioDAO.InitializeDB();
    }

    @Test
    void testAddFuncionarioAndGetFuncionarioByID() {
        // 1. Cria e adiciona um funcionario
        String cpf = "123.456.789-00";
        int pis = 1234567;
        assertTrue(FuncionarioDAO.addFuncionario("Engenheiro", cpf, pis, "Joao", 30));

        // 2. Busca o funcionario (ID 1)
        Funcionario func = FuncionarioDAO.getFuncionarioByID(1);
        
        // 3. Verifica se os dados estão corretos
        assertNotNull(func);
        assertEquals("Joao", func.getNome());
        assertEquals(30, func.getIdade());
        assertEquals("Engenheiro", func.getCargo());
        assertEquals(pis, func.getPIS());
        assertEquals(cpf, func.getCPF());
    }

    @Test
    void testGetFuncionarios() {
        // 1. Adiciona alguns funcionarios
        FuncionarioDAO.addFuncionario("Advogada", "111.111.111-11", 11111, "Maria", 32);
        FuncionarioDAO.addFuncionario("Medico", "222.222.222-22", 22222, "Carlos", 44);

        // 2. Busca a lista de funcionarios
        ArrayList<Funcionario> funcionarios = FuncionarioDAO.getFuncionarios();

        // 3. Verifica o tamanho e conteúdo
        assertNotNull(funcionarios);
        assertEquals(2, funcionarios.size());
        assertEquals("Maria", funcionarios.get(0).getNome());
        assertEquals("Medico", funcionarios.get(1).getCargo());
    }

    @Test
    void testUpdateFuncionario() {
        // 1. Adiciona um funcionario
        FuncionarioDAO.addFuncionario("Analista", "333.333.333-33", 33333, "Ana", 29);
        int id = 1; // ID do funcionario inserido
        
        // 2. Define novos dados e atualiza
        String novoCargo = "Analista Senior";
        String novoNome = "Ana Silva";
        int novaIdade = 30;

        assertTrue(FuncionarioDAO.updateFuncionario(novoCargo, "333.333.333-33", 33333, novoNome, novaIdade, id));

        // 3. Busca o funcionario atualizado
        Funcionario funcAtualizado = FuncionarioDAO.getFuncionarioByID(id);

        // 4. Verifica as atualizações
        assertNotNull(funcAtualizado);
        assertEquals(novoNome, funcAtualizado.getNome());
        assertEquals(novoCargo, funcAtualizado.getCargo());
        assertEquals(novaIdade, funcAtualizado.getIdade());
    }

    @Test
    void testRemoveFuncionarioByID() {
        // 1. Adiciona um funcionario
        FuncionarioDAO.addFuncionario("Arquiteto", "444.444.444-44", 44444, "Lucas", 45);
        int id = 1;

        // 2. Verifica se ele existe
        assertNotNull(FuncionarioDAO.getFuncionarioByID(id));

        // 3. Remove o funcionario
        assertTrue(FuncionarioDAO.removeFuncionarioByID(id));

        // 4. Verifica se ele foi removido
        assertNull(FuncionarioDAO.getFuncionarioByID(id));
    }
    
    @Test
    void testGetFuncionarioByIDNaoExistente() {
        // Verifica se a busca por um ID inexistente retorna nulo
        assertNull(FuncionarioDAO.getFuncionarioByID(999));
    }
}