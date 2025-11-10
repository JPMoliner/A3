import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.Aluno;

public class TesteAluno {
  @Test
  void criaEConsultaAluno() {
    Aluno a = new Aluno();
    a.setId(1);
    a.setNome("Ana");
    a.setIdade(20);
    a.setCPF("123");
    a.setCurso("ADS");
    a.setFase(3);

    assertEquals(1, a.getId());
    assertEquals("Ana", a.getNome());
    assertEquals(20, a.getIdade());
    assertEquals("123", a.getCPF());
    assertEquals("ADS", a.getCurso());
    assertEquals(3, a.getFase());
  }
}
