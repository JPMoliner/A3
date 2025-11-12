import model.Aluno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TesteAluno {

    @Test
    void testConstrutorVazio() {
        // Testa o construtor vazio (linha 12)
        Aluno aluno = new Aluno();
        assertNotNull(aluno);
    }

    @Test
    void testConstrutorDoisArgumentos() {
        // Testa o construtor de 2 argumentos (linhas 16-18)
        Aluno aluno = new Aluno("Medicina", 3);
        assertEquals("Medicina", aluno.getCurso());
        assertEquals(3, aluno.getFase());
    }

    @Test
    void testSettersAndGetters() {
        Aluno aluno = new Aluno();
        
        // Testa os setters e getters (linhas 29, 33, 37, 41)
        aluno.setCurso("Direito");
        assertEquals("Direito", aluno.getCurso());
        
        aluno.setFase(5);
        assertEquals(5, aluno.getFase());

        // Teste original que já existia
        aluno.setCpf("252525252525");
        assertEquals("252525252525", aluno.getCpf());
    }

    @Test
    void testConstrutorCompletoEToString() {
        // Testa o construtor completo (que usa a superclasse)
        Aluno aluno = new Aluno("Engenharia", 2, 1, "Joao", 22, "123.456.789-00");
        
        // Verifica todos os dados
        assertEquals(1, aluno.getId());
        assertEquals("Joao", aluno.getNome());
        assertEquals(22, aluno.getIdade());
        assertEquals("123.456.789-00", aluno.getCpf());
        assertEquals("Engenharia", aluno.getCurso());
        assertEquals(2, aluno.getFase());

        // Testa o método toString() (linhas 47-53)
        String esperado = "\n ID: 1" +
                        "\n Nome: Joao" +
                        "\n Idade: 22" +
                        "\n Curso: Engenharia" +
                        "\n Fase:2" +
                        "\n -----------";
        assertEquals(esperado, aluno.toString());
    }
}