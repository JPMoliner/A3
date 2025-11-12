package principal;

import view.TelaPrincipal;
import dao.Database;
import dao.AlunoDAO;
import dao.FuncionarioDAO;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe principal do sistema.
 * <p>
 * Responsável por inicializar a conexão com o banco de dados, criar as tabelas
 * necessárias e abrir a tela principal da aplicação. Também define o tema visual
 * (Look and Feel) do sistema conforme o padrão do sistema operacional.
 * </p>
 * 
 * @author Guilhermemhz
 * @version 1.0
 */
public class Principal {
    
    /**
     * Método principal que inicializa a aplicação.
     * <p>
     * Este método realiza as seguintes ações:
     * <ul>
     *   <li>Cria a conexão com o banco de dados</li>
     *   <li>Inicializa as tabelas de alunos e funcionários</li>
     *   <li>Define o tema visual (Look and Feel)</li>
     *   <li>Exibe a tela principal da aplicação</li>
     * </ul>
     * </p>
     * 
     * @param args os argumentos da linha de comando (não são utilizados)
     */
    public static void main(String[] args) {
        // Inicializa o banco de dados e as tabelas necessárias
        Database.createConnection();
        AlunoDAO.initializeDB();
        FuncionarioDAO.initializeDB();

        // Cria e exibe a tela principal da aplicação
        TelaPrincipal objetotela = new TelaPrincipal();
        objetotela.setVisible(true);

        // Define o Look and Feel do sistema operacional
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
    }

}
