package view;

import dao.AlunoDAO;
import javax.swing.JOptionPane;

/**
 * Tela de cadastro de novos alunos, permitindo inserir os dados principais do aluno.
 */
public class CadastroAluno extends javax.swing.JFrame {

    /**
     * Inicializa a tela de cadastro e seus componentes gráficos.
     */
    public CadastroAluno() {
        initComponents();
    }

    /**
     * Método gerado pela IDE para configurar os componentes da tela de cadastro.
     * <p><strong>Aviso:</strong> não modificar manualmente o conteúdo, pois ele é recriado pelo Form Editor.</p>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        c_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_idade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_curso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_fase = new javax.swing.JTextField();
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        c_CPFAluno = new javax.swing.JFormattedTextField();

        setTitle("Cadastro de Aluno");
        setResizable(false);

        jLabel1.setText("Nome:");

        c_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
@@ -130,62 +135,82 @@ public class CadastroAluno extends javax.swing.JFrame {
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_CPFAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_fase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cadastrar)
                    .addComponent(b_cancelar))
                .addGap(47, 47, 47))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento do campo Nome (não possui ação adicional).
     *
     * @param evt evento associado ao campo de texto
     */
    private void c_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_nomeActionPerformed

    /**
     * Evento do campo Curso (não possui ação adicional).
     *
     * @param evt evento associado ao campo de texto
     */
    private void c_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cursoActionPerformed

    /**
     * Evento do campo Fase (não possui ação adicional).
     *
     * @param evt evento associado ao campo de texto
     */
    private void c_faseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_faseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_faseActionPerformed

    /**
     * Efetua o cadastro de um novo aluno após validação dos campos.
     *
     * @param evt evento de clique no botão Cadastrar
     */
    private void b_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastrarActionPerformed

        try {
            // recebendo e validando dados da interface gráfica.
            String nome = "";
            int idade = 0;
            String curso = "";
            int fase = 0;
            String cpf = "";

            if (this.c_nome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.c_nome.getText();
            }

            if (this.c_idade.getText().length() <= 0) {
                throw new Mensagens("Idade deve ser numero e maior que zero.");
            } else {
                idade = Integer.parseInt(this.c_idade.getText());
            }
            
            if (this.c_curso.getText().length() < 2) {
                throw new Mensagens("Curso deve conter ao menos 2 caracteres.");
            } else {
@@ -206,62 +231,74 @@ public class CadastroAluno extends javax.swing.JFrame {

            // envia os dados para o Controlador cadastrar
            if (AlunoDAO.addAluno(curso, fase, nome, idade, cpf)) {
                JOptionPane.showMessageDialog(rootPane, "Aluno Cadastrado com Sucesso!");

                // limpa campos da interface
                this.c_nome.setText("");
                this.c_idade.setText("");
                this.c_curso.setText("");
                this.c_fase.setText("");
                this.c_CPFAluno.setText("");

            }

            System.out.println(AlunoDAO.getAlunos().toString());

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um numero.");
        }


    }//GEN-LAST:event_b_cadastrarActionPerformed

    /**
     * Fecha a tela de cadastro sem salvar alterações.
     *
     * @param evt evento de clique no botão Cancelar
     */
    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

    }//GEN-LAST:event_b_cancelarActionPerformed

    /**
     * Evento do campo CPF (não possui ação adicional).
     *
     * @param evt evento associado ao campo formatado
     */
    private void c_CPFAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_CPFAlunoActionPerformed

    }//GEN-LAST:event_c_CPFAlunoActionPerformed

    /**
     * Exibe a tela de cadastro de alunos de forma independente.
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

            /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cadastrar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JFormattedTextField c_CPFAluno;
    private javax.swing.JTextField c_curso;
    private javax.swing.JTextField c_fase;
    private javax.swing.JTextField c_idade;
    private javax.swing.JTextField c_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
