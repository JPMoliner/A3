package Principal;

import View.TelaPrincipal;
import javax.swing.*;
import DAO.*;
import Model.*;

public class Principal {

    public static void main(String[] args) {
        Database.createConnection();
        AlunoDAO.InitializeDB();
        /*AlunoDAO.addALuno("CDC", 4, "roberto", 55, "5353535353");
        for (Aluno aluno : AlunoDAO.getAlunos()){
            System.out.println(aluno.getNome() + " " + aluno.getId());
        }
        */
        
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
