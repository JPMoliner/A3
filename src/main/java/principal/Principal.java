package principal;

import View.TelaPrincipal;
import DAO.Database;
import DAO.AlunoDAO;
import DAO.FuncionarioDAO;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Principal {

    public static void main(String[] args) {
        Database.createConnection();
        AlunoDAO.InitializeDB();
        FuncionarioDAO.InitializeDB();

        
        TelaPrincipal objetotela = new TelaPrincipal();
        objetotela.setVisible(true);

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
