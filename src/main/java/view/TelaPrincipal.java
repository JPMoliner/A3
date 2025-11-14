package view;

import javax.swing.ImageIcon;

/**
 * Janela principal do sistema de gerenciamento, exibindo os menus de acesso às demais telas.
 * <p>Permite abrir os formulários de cadastro e gerenciamento de alunos e funcionários, além da tela Sobre.</p>
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /** Controlador da tela de gerenciamento de alunos. */
    GerenciaAluno objeto = new GerenciaAluno();

    /** Controlador da tela de gerenciamento de funcionários. */
    GerenciaFuncionario objetoF = new GerenciaFuncionario();

    /**
     * Constrói a tela principal e carrega os componentes visuais padrão.
     */
    public TelaPrincipal() {
        initComponents();
        ImageIcon img = new ImageIcon("C:\\Users\\Rafael Sonoki\\Desktop\\Java Uni\\Aula\\ProjetoA3SemControlador\\src\\view/icone.png");
        this.setIconImage(img.getImage());
    }

    /**
     * Método gerado pela IDE para inicializar os componentes gráficos da janela.
     * <p><strong>Aviso:</strong> não modificar manualmente o conteúdo, pois ele é recriado pelo Form Editor.</p>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        c_Aluno = new javax.swing.JMenuItem();
        c_Funcionario = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        g_aluno = new javax.swing.JMenuItem();
        g_Funcionario = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        dd_Sobre = new javax.swing.JMenu();
        dd_IntGrupo = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");
        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistema de Gerenciamento");

        // Menu "Arquivo" com opção Sair
        jMenu3.setText("Arquivo");

        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        // Menu "Cadastro" com Aluno e Funcionário
        jMenu4.setText("Cadastro");

        c_Aluno.setText("Aluno");
        c_Aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_AlunoActionPerformed(evt);
            }
        });
        jMenu4.add(c_Aluno);

        c_Funcionario.setText("Funcionário");
        c_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_FuncionarioActionPerformed(evt);
            }
        });
        jMenu4.add(c_Funcionario);

        jMenuBar1.add(jMenu4);

        // Menu "Gerenciar" com gerenciamento de Aluno e Funcionário
        jMenu5.setText("Gerenciar");

        g_aluno.setText("Gerenciar Alunos");
        g_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_alunoActionPerformed(evt);
            }
        });
        jMenu5.add(g_aluno);

        g_Funcionario.setText("Gerenciar Funcionários");
        g_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_FuncionarioActionPerformed(evt);
            }
        });
        jMenu5.add(g_Funcionario);

        jMenuBar1.add(jMenu5);

        // Menu "Sobre"
        dd_Sobre.setText("Sobre");
        dd_Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dd_SobreActionPerformed(evt);
            }
        });

        dd_IntGrupo.setText("Integrantes do Grupo");
        dd_IntGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dd_IntGrupoActionPerformed(evt);
            }
        });
        dd_Sobre.add(dd_IntGrupo);

        jMenuBar1.add(dd_Sobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Fecha a aplicação quando o menu Sair é acionado.
     *
     * @param evt evento de clique no item de menu
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * Abre a tela de cadastro de alunos.
     *
     * @param evt evento de seleção do item de menu
     */
    private void c_AlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_AlunoActionPerformed
        CadastroAluno objeto = new CadastroAluno();
        objeto.setVisible(true);
    }//GEN-LAST:event_c_AlunoActionPerformed

    /**
     * Exibe a tela de gerenciamento de alunos e atualiza a tabela listada.
     *
     * @param evt evento de seleção do item de menu
     */
    private void g_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_alunoActionPerformed
        objeto.setVisible(true);
        objeto.carregaTabela();
    }//GEN-LAST:event_g_alunoActionPerformed

    /**
     * Abre a tela de cadastro de funcionários.
     *
     * @param evt evento de seleção do item de menu
     */
    private void c_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_FuncionarioActionPerformed
        CadastroFuncionario objetoF = new CadastroFuncionario();
        objetoF.setVisible(true);
    }//GEN-LAST:event_c_FuncionarioActionPerformed

    /**
     * Exibe a tela de gerenciamento de funcionários e recarrega a tabela exibida.
     *
     * @param evt evento de seleção do item de menu
     */
    private void g_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_FuncionarioActionPerformed
        objetoF.setVisible(true);
        objetoF.carregaTabelaFunc();
    }//GEN-LAST:event_g_FuncionarioActionPerformed

    /**
     * Evento associado ao menu Sobre (sem ação específica definida).
     *
     * @param evt evento de seleção do menu Sobre
     */
    private void dd_SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dd_SobreActionPerformed
        // Nenhuma ação específica aqui.
    }//GEN-LAST:event_dd_SobreActionPerformed

    /**
     * Abre a tela com informações sobre os integrantes do grupo.
     *
     * @param evt evento de seleção do item de menu
     */
    private void dd_IntGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dd_IntGrupoActionPerformed
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_dd_IntGrupoActionPerformed

    /**
     * Método principal responsável por iniciar a aplicação e exibir a tela principal.
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem c_Aluno;
    private javax.swing.JMenuItem c_Funcionario;
    private javax.swing.JMenuItem dd_IntGrupo;
    private javax.swing.JMenu dd_Sobre;
    private javax.swing.JMenuItem g_Funcionario;
    private javax.swing.JMenuItem g_aluno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
