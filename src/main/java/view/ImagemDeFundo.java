package view;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Painel personalizado que exibe uma imagem redimensionada como plano de fundo.
 */
public class ImagemDeFundo extends javax.swing.JPanel {

    /** Imagem exibida no painel. */
    private ImageIcon img;

    /**
     * Inicializa o painel com uma imagem vazia.
     */
    public void painelImagemFundo(){
        img = new ImageIcon();
    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);

    }

    /**
     * Define a imagem que será exibida como fundo.
     *
     * @param img nova imagem para o painel
     */
    public void setImg(ImageIcon img){
        this.img = img;
    }

    /**
     * Retorna a imagem atualmente configurada no painel.
     *
     * @return imagem exibida como fundo
     */
    public ImageIcon getImg(){
        return this.img;
    }
}
