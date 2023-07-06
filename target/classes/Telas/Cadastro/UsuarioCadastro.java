package Telas.Cadastro;

import Controller.LoginController;
import Model.Repositorio.UsuarioDAO;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class UsuarioCadastro extends javax.swing.JFrame {

    private final LoginController controller;

    /**
     * Creates new form Login
     */
    public UsuarioCadastro() {
        initComponents();
        controller = new LoginController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFechar = new javax.swing.JButton();
        Voltar = new javax.swing.JButton();
        CadastroLabel = new javax.swing.JLabel();
        UsuarioLabel = new javax.swing.JLabel();
        loginINPUT = new javax.swing.JTextField();
        SenhaLabel = new javax.swing.JLabel();
        senhaINPUT = new javax.swing.JPasswordField();
        Cadastrar = new javax.swing.JButton();
        loginPainel = new javax.swing.JLabel();
        LoginBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Escolar - Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFechar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 110, 50));

        Voltar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Voltar.setText("Voltar");
        Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Voltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });
        getContentPane().add(Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 110, 50));

        CadastroLabel.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        CadastroLabel.setForeground(new java.awt.Color(255, 255, 255));
        CadastroLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CadastroLabel.setText("Cadastro");
        CadastroLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        CadastroLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(CadastroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, 50));

        UsuarioLabel.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        UsuarioLabel.setForeground(new java.awt.Color(255, 255, 255));
        UsuarioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UsuarioLabel.setText("Usuario");
        UsuarioLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        UsuarioLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(UsuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, 30));

        loginINPUT.setBackground(new java.awt.Color(153, 153, 153));
        loginINPUT.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        loginINPUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginINPUTActionPerformed(evt);
            }
        });
        getContentPane().add(loginINPUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 320, 50));

        SenhaLabel.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        SenhaLabel.setForeground(new java.awt.Color(255, 255, 255));
        SenhaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SenhaLabel.setText("Senha");
        SenhaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SenhaLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(SenhaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, 30));

        senhaINPUT.setBackground(new java.awt.Color(153, 153, 153));
        senhaINPUT.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        senhaINPUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaINPUTActionPerformed(evt);
            }
        });
        getContentPane().add(senhaINPUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 320, 50));

        Cadastrar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Cadastrar.setText("Cadastrar");
        Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(Cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 110, 50));

        loginPainel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/imagens/painel-login.png"))); // NOI18N
        getContentPane().add(loginPainel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        LoginBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/imagens/loginIMG1.png"))); // NOI18N
        getContentPane().add(LoginBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginINPUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginINPUTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginINPUTActionPerformed

    private void senhaINPUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaINPUTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaINPUTActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        String login = loginINPUT.getText();
        String senha = senhaINPUT.getText();
        UsuarioDAO cadastro = new UsuarioDAO();
        if(cadastro.insert(login, senha)){
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado");
            controller.Login();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Ops, algo de errado não está certo..");
        }
        
    }//GEN-LAST:event_CadastrarActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        controller.Login();
        this.dispose();
    }//GEN-LAST:event_VoltarActionPerformed


    public JPasswordField getSenhaINPUT() {
        return senhaINPUT;
    }

    public void setSenhaINPUT(JPasswordField senhaINPUT) {
        this.senhaINPUT = senhaINPUT;
    }

    public JTextField getUsuarioINPUT() {
        return loginINPUT;
    }

    public void setUsuarioINPUT(JTextField usuarioINPUT) {
        this.loginINPUT = usuarioINPUT;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JLabel CadastroLabel;
    private javax.swing.JLabel LoginBG;
    private javax.swing.JLabel SenhaLabel;
    private javax.swing.JLabel UsuarioLabel;
    private javax.swing.JButton Voltar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JTextField loginINPUT;
    private javax.swing.JLabel loginPainel;
    private javax.swing.JPasswordField senhaINPUT;
    // End of variables declaration//GEN-END:variables

    public void exibeMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
