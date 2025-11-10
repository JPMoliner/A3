/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Model.Aluno;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/* exemplo de varios testes de uma vez com parametros diferentes
    @ParameterizedTest
    @CsvSource({
        "1.0, 1.0, 1.0, -3.0",     // delta = 1² - 4*1*1 = -3
        "1.0, -2.0, 1.0, 0.0",     // delta = (-2)² - 4*1*1 = 0
        "1.0, 5.0, 6.0, 1.0"       // delta = 25 - 24 = 1
    })
    void testGetDelta(double a, double b, double c, double deltaEsperado) {
        Equacao equacao = new Equacao(a, b, c);
        double deltaCalculado = equacao.getDelta();
        assertEquals(deltaEsperado, deltaCalculado, 0.0001);
    }
*/

/* exemplo de um teste
    @Test
    void testGetSoma(){
        //Instancia um objeto da classe Calculadora
        Calculadora calculadora = new Calculadora(4.0,2.0);
        //Define o valor esperado para a operação
        double retornoEsperado = 5.0;
        //Chama a operacao getSoma()
        double retornoFeito = calculadora.getSoma();
        //Premissa verifica se os valores são iguais
        assertEquals(retornoEsperado,retornoFeito,2);
    }
*/


public class TesteAluno {
    @Test
    void testCPF(){
        Aluno aluno = new Aluno();
        aluno.setCPF("252525252525");
        assertEquals("252525252525",aluno.getCPF());
    }
    
    @Test
    void testFase(){
        Aluno aluno = new Aluno();
        aluno.setFase(5);
        assertEquals(5,aluno.getFase());
    }
}
