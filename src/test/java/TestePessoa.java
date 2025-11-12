import model.Pessoa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe de teste para a classe abstrata Pessoa
public class TestePessoa {

    // Criamos uma classe "concreta" de teste que herda de Pessoa
    // apenas para fins de teste, já que Pessoa é abstrata.
    class PessoaConcreta extends Pessoa {
        public PessoaConcreta() {
            super();
        }

        public PessoaConcreta(int id, String nome, int idade, String cpf) {
            super(id, nome, idade, cpf);
        }
    }

    @Test
    void testSettersAndGetters() {
        Pessoa p = new PessoaConcreta();
        p.setId(100);
        p.setNome("Pessoa Teste");
        p.setIdade(99);
        p.setCpf("999.999.999-99");

        assertEquals(100, p.getId());
        assertEquals("Pessoa Teste", p.getNome());
        assertEquals(99, p.getIdade());
        assertEquals("999.999.999-99", p.getCpf());
    }

    @Test
    void testConstrutorCompleto() {
        Pessoa p = new PessoaConcreta(10, "Nome Construtor", 50, "123.456.789-00");
        
        assertEquals(10, p.getId());
        assertEquals("Nome Construtor", p.getNome());
        assertEquals(50, p.getIdade());
        assertEquals("123.456.789-00", p.getCpf());
    }
}