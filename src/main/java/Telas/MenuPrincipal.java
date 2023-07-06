package Telas;

import Controller.MenuPrincipalController;
import javax.swing.JPanel;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private final MenuPrincipalController controller;
    public MenuPrincipal(String nome) {
        initComponents();
        controller = new MenuPrincipalController(this);
        NavBar__Usuario.setText(nome);
    }
    public MenuPrincipal() {
        initComponents();
        controller = new MenuPrincipalController(this);
    }

    public MenuPrincipalController getController() {
        return controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelCentral = new javax.swing.JPanel();
        PainelBG = new javax.swing.JLabel();
        MenuBG = new javax.swing.JLabel();
        Menu__Navbar = new javax.swing.JMenuBar();
        NavBar__Usuario = new javax.swing.JMenu();
        NavBar__Usuario__Sair = new javax.swing.JMenuItem();
        NavBar__Cursos = new javax.swing.JMenu();
        NavBar__Cursos__Abrir = new javax.swing.JMenuItem();
        NavBar__Cursos__Fechar = new javax.swing.JMenuItem();
        NavBar__Disciplinas = new javax.swing.JMenu();
        NavBar__Disciplinas__Abrir = new javax.swing.JMenuItem();
        NavBar__Disciplinas__Fechar = new javax.swing.JMenuItem();
        NavBar__Professores = new javax.swing.JMenu();
        NavBar__Professores__Abrir = new javax.swing.JMenuItem();
        NavBar__Professores__Fechar = new javax.swing.JMenuItem();
        NavBar__Alunos = new javax.swing.JMenu();
        NavBar_Alunos__Abrir = new javax.swing.JMenuItem();
        NavBar__Alunos_Fechar = new javax.swing.JMenuItem();
        NavBar__Turmas = new javax.swing.JMenu();
        NavBar__Turmas__Abrir = new javax.swing.JMenuItem();
        NavBar__Turmas__Fechar = new javax.swing.JMenuItem();
        NavBar__Matriculas = new javax.swing.JMenu();
        NavBar__Matriculas__Abrir = new javax.swing.JMenuItem();
        NavBar__Matriculas__Fechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Escolar - Menu");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PainelCentral.setOpaque(false);
        getContentPane().add(PainelCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 800, 600));

        PainelBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/imagens/painel.png"))); // NOI18N
        getContentPane().add(PainelBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        MenuBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/imagens/menuBackground.png"))); // NOI18N
        getContentPane().add(MenuBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        Menu__Navbar.setForeground(new java.awt.Color(255, 255, 255));
        Menu__Navbar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        NavBar__Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/imagens/user.png"))); // NOI18N
        NavBar__Usuario.setText("Usuario");
        NavBar__Usuario.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        NavBar__Usuario__Sair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Usuario__Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/imagens/exit.png"))); // NOI18N
        NavBar__Usuario__Sair.setText("Sair");
        NavBar__Usuario__Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Usuario__SairActionPerformed(evt);
            }
        });
        NavBar__Usuario.add(NavBar__Usuario__Sair);

        Menu__Navbar.add(NavBar__Usuario);

        NavBar__Cursos.setText("Cursos");
        NavBar__Cursos.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        NavBar__Cursos__Abrir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Cursos__Abrir.setText("Abrir");
        NavBar__Cursos__Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Cursos__AbrirActionPerformed(evt);
            }
        });
        NavBar__Cursos.add(NavBar__Cursos__Abrir);

        NavBar__Cursos__Fechar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Cursos__Fechar.setText("Fechar");
        NavBar__Cursos__Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Cursos__FecharActionPerformed(evt);
            }
        });
        NavBar__Cursos.add(NavBar__Cursos__Fechar);

        Menu__Navbar.add(NavBar__Cursos);

        NavBar__Disciplinas.setText("Disciplinas");
        NavBar__Disciplinas.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        NavBar__Disciplinas__Abrir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Disciplinas__Abrir.setText("Abrir");
        NavBar__Disciplinas__Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Disciplinas__AbrirActionPerformed(evt);
            }
        });
        NavBar__Disciplinas.add(NavBar__Disciplinas__Abrir);

        NavBar__Disciplinas__Fechar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Disciplinas__Fechar.setText("Fechar");
        NavBar__Disciplinas__Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Disciplinas__FecharActionPerformed(evt);
            }
        });
        NavBar__Disciplinas.add(NavBar__Disciplinas__Fechar);

        Menu__Navbar.add(NavBar__Disciplinas);

        NavBar__Professores.setText("Professores");
        NavBar__Professores.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        NavBar__Professores__Abrir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Professores__Abrir.setText("Abrir");
        NavBar__Professores__Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Professores__AbrirActionPerformed(evt);
            }
        });
        NavBar__Professores.add(NavBar__Professores__Abrir);

        NavBar__Professores__Fechar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Professores__Fechar.setText("Fechar");
        NavBar__Professores__Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Professores__FecharActionPerformed(evt);
            }
        });
        NavBar__Professores.add(NavBar__Professores__Fechar);

        Menu__Navbar.add(NavBar__Professores);

        NavBar__Alunos.setText("Alunos");
        NavBar__Alunos.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        NavBar__Alunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__AlunosActionPerformed(evt);
            }
        });

        NavBar_Alunos__Abrir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar_Alunos__Abrir.setText("Abrir");
        NavBar_Alunos__Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar_Alunos__AbrirActionPerformed(evt);
            }
        });
        NavBar__Alunos.add(NavBar_Alunos__Abrir);

        NavBar__Alunos_Fechar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Alunos_Fechar.setText("Fechar");
        NavBar__Alunos_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Alunos_FecharActionPerformed(evt);
            }
        });
        NavBar__Alunos.add(NavBar__Alunos_Fechar);

        Menu__Navbar.add(NavBar__Alunos);

        NavBar__Turmas.setText("Turmas");
        NavBar__Turmas.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        NavBar__Turmas__Abrir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Turmas__Abrir.setText("Abrir");
        NavBar__Turmas__Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Turmas__AbrirActionPerformed(evt);
            }
        });
        NavBar__Turmas.add(NavBar__Turmas__Abrir);

        NavBar__Turmas__Fechar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Turmas__Fechar.setText("Fechar");
        NavBar__Turmas__Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Turmas__FecharActionPerformed(evt);
            }
        });
        NavBar__Turmas.add(NavBar__Turmas__Fechar);

        Menu__Navbar.add(NavBar__Turmas);

        NavBar__Matriculas.setText("Matriculas");
        NavBar__Matriculas.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        NavBar__Matriculas__Abrir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Matriculas__Abrir.setText("Abrir");
        NavBar__Matriculas__Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Matriculas__AbrirActionPerformed(evt);
            }
        });
        NavBar__Matriculas.add(NavBar__Matriculas__Abrir);

        NavBar__Matriculas__Fechar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NavBar__Matriculas__Fechar.setText("Fechar");
        NavBar__Matriculas__Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavBar__Matriculas__FecharActionPerformed(evt);
            }
        });
        NavBar__Matriculas.add(NavBar__Matriculas__Fechar);

        Menu__Navbar.add(NavBar__Matriculas);

        setJMenuBar(Menu__Navbar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NavBar__AlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__AlunosActionPerformed
        
    }//GEN-LAST:event_NavBar__AlunosActionPerformed

    private void NavBar_Alunos__AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar_Alunos__AbrirActionPerformed
        AlunosView alunos = new AlunosView(this);
        controller.navegar(alunos);
    }//GEN-LAST:event_NavBar_Alunos__AbrirActionPerformed

    private void NavBar__Alunos_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Alunos_FecharActionPerformed
        controller.limparTela();
    }//GEN-LAST:event_NavBar__Alunos_FecharActionPerformed

    private void NavBar__Professores__AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Professores__AbrirActionPerformed
        ProfessoresView professores = new ProfessoresView(this);
        controller.navegar(professores);
    }//GEN-LAST:event_NavBar__Professores__AbrirActionPerformed

    private void NavBar__Professores__FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Professores__FecharActionPerformed
        controller.limparTela();
    }//GEN-LAST:event_NavBar__Professores__FecharActionPerformed

    private void NavBar__Turmas__FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Turmas__FecharActionPerformed
        controller.limparTela();
    }//GEN-LAST:event_NavBar__Turmas__FecharActionPerformed

    private void NavBar__Disciplinas__FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Disciplinas__FecharActionPerformed
        controller.limparTela();
    }//GEN-LAST:event_NavBar__Disciplinas__FecharActionPerformed

    private void NavBar__Cursos__FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Cursos__FecharActionPerformed
        controller.limparTela();
    }//GEN-LAST:event_NavBar__Cursos__FecharActionPerformed

    private void NavBar__Usuario__SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Usuario__SairActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NavBar__Usuario__SairActionPerformed

    private void NavBar__Turmas__AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Turmas__AbrirActionPerformed
        TurmasView turmas = new TurmasView(this);
        controller.navegar(turmas);
    }//GEN-LAST:event_NavBar__Turmas__AbrirActionPerformed

    private void NavBar__Disciplinas__AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Disciplinas__AbrirActionPerformed
        DisciplinasView disciplinas = new DisciplinasView(this);
        controller.navegar(disciplinas);
    }//GEN-LAST:event_NavBar__Disciplinas__AbrirActionPerformed

    private void NavBar__Cursos__AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Cursos__AbrirActionPerformed
        CursosView cursos = new CursosView(this);
        controller.navegar(cursos);
    }//GEN-LAST:event_NavBar__Cursos__AbrirActionPerformed

    private void NavBar__Matriculas__AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Matriculas__AbrirActionPerformed
        MatriculasView matriculas = new MatriculasView(this);
        controller.navegar(matriculas);
    }//GEN-LAST:event_NavBar__Matriculas__AbrirActionPerformed

    private void NavBar__Matriculas__FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavBar__Matriculas__FecharActionPerformed
        controller.limparTela();
    }//GEN-LAST:event_NavBar__Matriculas__FecharActionPerformed

    
    public JPanel getPainelCentral() {
        return PainelCentral;
    }

    public void setPainelCentral(JPanel PainelCentral) {
        this.PainelCentral = PainelCentral;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MenuBG;
    private javax.swing.JMenuBar Menu__Navbar;
    private javax.swing.JMenuItem NavBar_Alunos__Abrir;
    private javax.swing.JMenu NavBar__Alunos;
    private javax.swing.JMenuItem NavBar__Alunos_Fechar;
    private javax.swing.JMenu NavBar__Cursos;
    private javax.swing.JMenuItem NavBar__Cursos__Abrir;
    private javax.swing.JMenuItem NavBar__Cursos__Fechar;
    private javax.swing.JMenu NavBar__Disciplinas;
    private javax.swing.JMenuItem NavBar__Disciplinas__Abrir;
    private javax.swing.JMenuItem NavBar__Disciplinas__Fechar;
    private javax.swing.JMenu NavBar__Matriculas;
    private javax.swing.JMenuItem NavBar__Matriculas__Abrir;
    private javax.swing.JMenuItem NavBar__Matriculas__Fechar;
    private javax.swing.JMenu NavBar__Professores;
    private javax.swing.JMenuItem NavBar__Professores__Abrir;
    private javax.swing.JMenuItem NavBar__Professores__Fechar;
    private javax.swing.JMenu NavBar__Turmas;
    private javax.swing.JMenuItem NavBar__Turmas__Abrir;
    private javax.swing.JMenuItem NavBar__Turmas__Fechar;
    private javax.swing.JMenu NavBar__Usuario;
    private javax.swing.JMenuItem NavBar__Usuario__Sair;
    private javax.swing.JLabel PainelBG;
    private javax.swing.JPanel PainelCentral;
    // End of variables declaration//GEN-END:variables
}
