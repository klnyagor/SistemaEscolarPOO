package Telas;

import Controller.MenuPrincipalController;
import Model.Aluno;
import Model.Repositorio.AlunoDAO;
import Model.Repositorio.MatriculaDAO;
import Model.Turma;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class MatriculasView extends javax.swing.JPanel {

    private final MenuPrincipal menu;
    private final MenuPrincipalController controller;

    /**
     * Creates new form MatriculasView
     */
    public MatriculasView(MenuPrincipal menu) {
        this.menu = menu;
        controller = menu.getController();
        initComponents();
        iniciar();
    }
    
    public void iniciar(){
        listarAlunos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        TelaMatriculas = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaMatriculas = new javax.swing.JTable();
        matriculaBoxAluno = new javax.swing.JComboBox<>();
        matriculaAluno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        btnMatricularAluno = new javax.swing.JButton();
        DiscMatriculadasBtn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        Header.setOpaque(false);

        TelaMatriculas.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        TelaMatriculas.setForeground(new java.awt.Color(255, 255, 255));
        TelaMatriculas.setText("Matriculas");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(TelaMatriculas)
                .addContainerGap(629, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(TelaMatriculas)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        add(Header);

        Main.setOpaque(false);

        TabelaMatriculas.setBackground(new java.awt.Color(51, 51, 51));
        TabelaMatriculas.setForeground(new java.awt.Color(255, 255, 255));
        TabelaMatriculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Turma ID", "Disciplina", "Horario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaMatriculas.setAutoscrolls(false);
        TabelaMatriculas.setOpaque(false);
        jScrollPane1.setViewportView(TabelaMatriculas);

        matriculaBoxAluno.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        matriculaBoxAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaBoxAlunoActionPerformed(evt);
            }
        });

        matriculaAluno.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        matriculaAluno.setForeground(new java.awt.Color(255, 255, 255));
        matriculaAluno.setText("Aluno:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecione o Aluno");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de Turmas em que o Aluno pode ser matriculado:");

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(matriculaAluno)
                        .addGap(18, 18, 18)
                        .addComponent(matriculaBoxAluno, 0, 192, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(70, 70, 70))))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(matriculaBoxAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(matriculaAluno)))
                .addContainerGap())
        );

        add(Main);

        Footer.setOpaque(false);

        btnMatricularAluno.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnMatricularAluno.setText("Matricular Aluno");
        btnMatricularAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularAlunoActionPerformed(evt);
            }
        });

        DiscMatriculadasBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DiscMatriculadasBtn.setText("Disciplinas Matriculadas");
        DiscMatriculadasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscMatriculadasBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FooterLayout = new javax.swing.GroupLayout(Footer);
        Footer.setLayout(FooterLayout);
        FooterLayout.setHorizontalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FooterLayout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .addComponent(btnMatricularAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(DiscMatriculadasBtn)
                .addGap(20, 20, 20))
        );
        FooterLayout.setVerticalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatricularAluno)
                    .addComponent(DiscMatriculadasBtn))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        add(Footer);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatricularAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularAlunoActionPerformed
        try{
            int linha = -1;
            linha = TabelaMatriculas.getSelectedRow();
            if(linha >= 0){
                Aluno aluno = (Aluno) matriculaBoxAluno.getSelectedItem();
                Turma turma = (Turma) TabelaMatriculas.getValueAt(linha, 0);
                MatriculaDAO matricula = new MatriculaDAO();
                matricula.Matricular(aluno, turma);
                JOptionPane.showMessageDialog(null, "Aluno foi matriculado!");
            
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma linha!");
            }
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ops, algo de errado não está certo..");
        } finally {
            listarTabela();
        }
    }//GEN-LAST:event_btnMatricularAlunoActionPerformed

    private void matriculaBoxAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaBoxAlunoActionPerformed
        listarTabela();
    }//GEN-LAST:event_matriculaBoxAlunoActionPerformed

    private void DiscMatriculadasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscMatriculadasBtnActionPerformed
        DiscMatriculadasView discMatriculadas = new  DiscMatriculadasView(menu);
        controller.navegar(discMatriculadas);
    }//GEN-LAST:event_DiscMatriculadasBtnActionPerformed

    public void listarAlunos(){
        AlunoDAO alunos = new AlunoDAO();
        List<Aluno> aluno = new LinkedList<>(alunos.listar());
        DefaultComboBoxModel boxA = (DefaultComboBoxModel) matriculaBoxAluno.getModel();
        for(Aluno a: aluno){
            boxA.addElement(a);
        }
    }
    
    public void listarTabela(){
        try{
            Aluno aluno = (Aluno) matriculaBoxAluno.getSelectedItem();
            DefaultTableModel tabela = (DefaultTableModel) TabelaMatriculas.getModel();
            tabela.setNumRows(0);
            MatriculaDAO turmas = new MatriculaDAO();
            for(Turma t: turmas.alunoNaoMatriculado(aluno.getId())){
                tabela.addRow(new Object[]{t, t.getDisciplina(), t.getHorario()});
            }
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ops, algo de errado não está certo..");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DiscMatriculadasBtn;
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JTable TabelaMatriculas;
    private javax.swing.JLabel TelaMatriculas;
    private javax.swing.JButton btnMatricularAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel matriculaAluno;
    private javax.swing.JComboBox<String> matriculaBoxAluno;
    // End of variables declaration//GEN-END:variables
}