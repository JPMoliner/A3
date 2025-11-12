import model.Funcionario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteFuncionario {
    
    @Test
    void testSettersAndGetters() {
        Funcionario func = new Funcionario();
        
        func.setNome("Funcionario Teste");
        func.setIdade(40);
        func.setCpf("777.777.77A-77");
        
        // Nota de QA: O método em Funcionario.java está nomeado "setCurso", mas afeta "cargo"
        // Isso é um "code smell", mas o teste deve refletir o código como está.
        func.setCurso("RH"); 
        func.setPis(987654);

        assertEquals("Funcionario Teste", func.getNome());
        assertEquals(40, func.getIdade());
        assertEquals("777.777.77A-77", func.getCpf());
        assertEquals("RH", func.getCargo());
        assertEquals(987654, func.getPis());
    }

    @Test
    void testConstrutorCompleto() {
        // Testando o construtor que usa a superclasse
        Funcionario func = new Funcionario("CEO", "111.222.333-44", 12345, 10, "Super Funcionario", 50);
        
        assertEquals(10, func.getId());
        assertEquals("Super Funcionario", func.getNome());
        assertEquals(50, func.getIdade());
        assertEquals("CEO", func.getCargo());
        assertEquals("111.222.333-44", func.getCpf());
        assertEquals(12345, func.getPis());
        
        // Testa o toString() para cobertura completa
        String esperado = "\n ID: " + func.getId() +
                        "\n Nome: " + func.getNome() +
                        "\n Idade: " + func.getIdade() +
                        "\n Cargo: " + func.getCargo() +
                        "\n CPF:" + func.getCpf() +
                        "\n PIS:" + func.getPis() +
                        "\n -----------";
        assertEquals(esperado, func.toString());
    }
}