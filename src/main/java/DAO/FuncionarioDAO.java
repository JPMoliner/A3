/*
 Aqui vamos simular a persist�ncia de dados.
 */
package DAO;

import Model.Funcionario;
import java.util.*;

public class FuncionarioDAO {

    public static ArrayList<Funcionario> MinhaListaFunc = new ArrayList<Funcionario>();

    public static int maiorIDFunc() {
        
        int maiorIDFunc = 0;
        for (int i = 0; i < MinhaListaFunc.size(); i++) {
            if (MinhaListaFunc.get(i).getId() > maiorIDFunc) {
                maiorIDFunc = MinhaListaFunc.get(i).getId();
            }
        }
        return maiorIDFunc;
        
        
    }

}
