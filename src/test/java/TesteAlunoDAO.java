import dao.AlunoDAO;
import dao.Database;
import model.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TesteAlunoDAO {

    // URL do banco de dados em memória
    private static final String IN_MEMORY_DB = "jdbc:sqlite::memory:";

    @BeforeEach
    public void setUp() {
        // 1. Conecta ao banco de dados em memória
        Database.createConnection(IN_MEMORY_DB);
        
        // 2. Cria a tabela 'Alunos' (necessário para cada teste, pois o DB é 'em memória')
        AlunoDAO.initializeDB();
    }

    @Test
    void testAddAlunoAndGetAlunoByID() {
        // 1. Cria e adiciona um aluno
        String cpf = "123.456.789-00";
        assertTrue(AlunoDAO.addAluno("Engenharia", 5, "Joao", 20, cpf));

        // 2. Busca o aluno (o ID 1 é garantido no SQLite 'autoincrement' em uma tabela vazia)
        Aluno aluno = AlunoDAO.getAlunoByID(1);
        
        // 3. Verifica se os dados estão corretos
        assertNotNull(aluno);
        assertEquals("Joao", aluno.getNome());
        assertEquals(20, aluno.getIdade());
        assertEquals("Engenharia", aluno.getCurso());
        assertEquals(5, aluno.getFase());
        assertEquals(cpf, aluno.getCpf());
    }

    @Test
    void testGetAlunos() {
        // 1. Adiciona alguns alunos
        AlunoDAO.addAluno("Direito", 1, "Maria", 22, "111.111.111-11");
        AlunoDAO.addAluno("Medicina", 3, "Carlos", 24, "222.222.222-22");

        // 2. Busca a lista de alunos
        ArrayList<Aluno> alunos = AlunoDAO.getAlunos();

        // 3. Verifica o tamanho da lista
        assertNotNull(alunos);
        assertEquals(2, alunos.size());
        assertEquals("Maria", alunos.get(0).getNome());
        assertEquals("Carlos", alunos.get(1).getNome());
    }

    @Test
    void testUpdateAluno() {
        // 1. Adiciona um aluno
        AlunoDAO.addAluno("Computacao", 1, "Ana", 19, "333.333.333-33");
        
        // 2. Busca, modifica e atualiza o aluno
        String novoNome = "Ana Silva";
        String novoCurso = "Sistemas de Informacao";
        int novoId = 1; // ID do aluno inserido

        assertTrue(AlunoDAO.updateAluno(novoCurso, 2, novoNome, 20, "333.333.333-33", novoId));

        // 3. Busca o aluno atualizado
        Aluno alunoAtualizado = AlunoDAO.getAlunoByID(novoId);

        // 4. Verifica as atualizações
        assertNotNull(alunoAtualizado);
        assertEquals(novoNome, alunoAtualizado.getNome());
        assertEquals(novoCurso, alunoAtualizado.getCurso());
        assertEquals(20, alunoAtualizado.getIdade());
    }

    @Test
    void testRemoveAlunoByID() {
        // 1. Adiciona um aluno
        AlunoDAO.addAluno("Arquitetura", 7, "Lucas", 25, "444.444.444-44");
        int id = 1;

        // 2. Verifica se ele existe
        assertNotNull(AlunoDAO.getAlunoByID(id));

        // 3. Remove o aluno
        assertTrue(AlunoDAO.removeAlunoByID(id));

        // 4. Verifica se ele foi removido
        assertNull(AlunoDAO.getAlunoByID(id));
    }
    
    @Test
    void testGetAlunoByIDNaoExistente() {
        // Verifica se a busca por um ID inexistente retorna nulo
        assertNull(AlunoDAO.getAlunoByID(999));
    }
}