package view;

/**
 * Exceção específica para encapsular mensagens exibidas na camada de visão.
 */
public class Mensagens extends Exception {

     /**
     * Cria uma nova instância da exceção contendo a mensagem informada.
     *
     * @param msg texto descritivo que será apresentado ao usuário
     */
    Mensagens(String msg) {
        super(msg);
    }
}
