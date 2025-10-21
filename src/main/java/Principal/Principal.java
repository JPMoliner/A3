package Principal;

import View.TelaPrincipal;
import javax.swing.*;

public class Principal {

    public static void main(String[] args) {
        TelaPrincipal objetotela = new TelaPrincipal();
        objetotela.setVisible(true);
        
            try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
    }
    
}
