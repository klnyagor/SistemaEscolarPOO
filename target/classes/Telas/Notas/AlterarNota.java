package Telas.Notas;


import Controller.MenuPrincipalController;
import Model.Aluno;
import Model.Disciplina;
import Model.Notas;
import Model.Repositorio.AlunoDAO;
import Model.Repositorio.DisciplinaDAO;
import Model.Repositorio.MatriculaDAO;
import Model.Repositorio.NotasDAO;
import Model.Turma;

import Telas.AlunosView;

import Telas.MenuPrincipal;
import java.util.ArrayList;
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
public class AlterarNota extends javax.swing.JPanel {
    private final MenuPrincipalController controller;
    private final MenuPrincipal menu;

    /**
     * Creates new form AlterarNota
     */
    public AlterarNota(MenuPrincipal menu) {
        initComponents();
        this.menu = menu;
        controller = menu.getController();
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

        Header1 = new javax.swing.JPanel();
        Notas = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaNotas = new javax.swing.JTable();
        BoxAluno = new javax.swing.JComboBox<>();
        Aluno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BoxDisciplina = new javax.swing.JComboBox<>();
        BoxUnidade = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NotaInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        VoltarBtn = new javax.swing.JButton();
        AlterarNota = new javax.swing.JButton();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        Header1.setOpaque(false);

        Notas.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        Notas.setForeground(new java.awt.Color(255, 255, 255));
        Notas.setText("Notas");

        javax.swing.GroupLayout Header1Layout = new javax.swing.GroupLayout(Header1);
        Header1.setLayout(Header1Layout);
        Header1Layout.setHorizontalGroup(
            Header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Notas)
                .addContainerGap(648, Short.MAX_VALUE))
        );
        Header1Layout.setVerticalGroup(
            Header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Notas)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        add(Header1);

        Main.setOpaque(false);

        TabelaNotas.setBackground(new java.awt.Color(51, 51, 51));
        TabelaNotas.setForeground(new java.awt.Color(255, 255, 255));
        TabelaNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Nota 1", "Nota 2", "Nota 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaNotas.setAutoscrolls(false);
        TabelaNotas.setOpaque(false);
        jScrollPane1.setViewportView(TabelaNotas);

        BoxAluno.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        BoxAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxAlunoActionPerformed(evt);
            }
        });

        Aluno.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Aluno.setForeground(new java.awt.Color(255, 255, 255));
        Aluno.setText("Aluno:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecione o Aluno");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Boletim");

        BoxDisciplina.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        BoxDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxDisciplinaActionPerformed(evt);
            }
        });

        BoxUnidade.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        BoxUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxUnidadeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Disciplina:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Unidade:");

        NotaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotaInputActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nota:");

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Aluno)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxAluno, 0, 121, Short.MAX_VALUE)
                            .addComponent(BoxDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BoxUnidade, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NotaInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(234, 234, 234))))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoxAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Aluno))
                        .addGap(18, 18, 18)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoxDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(NotaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        add(Main);

        Footer.setOpaque(false);

        VoltarBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        VoltarBtn.setText("Voltar");
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });

        AlterarNota.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AlterarNota.setText("Alterar");
        AlterarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FooterLayout = new javax.swing.GroupLayout(Footer);
        Footer.setLayout(FooterLayout);
        FooterLayout.setHorizontalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FooterLayout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .addComponent(AlterarNota, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        FooterLayout.setVerticalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBtn)
                    .addComponent(AlterarNota))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        add(Footer);
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        NotaView alunos = new NotaView(menu);
        controller.navegar(alunos);
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void BoxAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxAlunoActionPerformed
        listarTabela();
    }//GEN-LAST:event_BoxAlunoActionPerformed

    private void AlterarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarNotaActionPerformed
        try{
            Aluno aluno = (Aluno) BoxAluno.getSelectedItem();
            Disciplina disciplina = (Disciplina) BoxDisciplina.getSelectedItem();
            int unidade = (int) BoxUnidade.getSelectedItem();
            double nota = Double.parseDouble(NotaInput.getText());
            NotasDAO notasDao = new NotasDAO();
            notasDao.alterarNota(disciplina, aluno, nota, unidade);
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ops, algo de errado não está certo..");
        } finally {
            listarTabela();
        }
    }//GEN-LAST:event_AlterarNotaActionPerformed

    private void BoxDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxDisciplinaActionPerformed

    private void BoxUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxUnidadeActionPerformed

    private void NotaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NotaInputActionPerformed
    public void listarTabela(){
        try{
            Aluno aluno = (Aluno) BoxAluno.getSelectedItem();
            listaDisciplinas(aluno);
            listaUnidades();
            DefaultTableModel tabela = (DefaultTableModel) TabelaNotas.getModel();
            tabela.setNumRows(0);
            NotasDAO notas = new NotasDAO();
            for(Notas n: notas.PegarNotas(aluno)){
                tabela.addRow(new Object[]{n.getNome(),n.getNota1(),n.getNota2(),n.getNota3()});
            }
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ops, algo de errado não está certo..");
        }
    }
    public void listarAlunos(){
        AlunoDAO alunos = new AlunoDAO();
        List<Aluno> aluno = new LinkedList<>(alunos.listar());
        DefaultComboBoxModel boxA = (DefaultComboBoxModel) BoxAluno.getModel();
        for(Aluno a: aluno){
            boxA.addElement(a);
        }
    }
    public void listaDisciplinas(Aluno aluno){
        DisciplinaDAO disciplina = new DisciplinaDAO();
        List<Disciplina> lista = new ArrayList<>(disciplina.disciplinasAluno(aluno));
        DefaultComboBoxModel boxB = (DefaultComboBoxModel) BoxDisciplina.getModel();
        boxB.removeAllElements();
        for(Disciplina a: lista){
            boxB.addElement(a);
        }
    }
    public void listaUnidades(){
        DefaultComboBoxModel boxC = (DefaultComboBoxModel) BoxUnidade.getModel();
        boxC.removeAllElements();
        for(int i=1;i<4;i++){
            boxC.addElement(i);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarNota;
    private javax.swing.JLabel Aluno;
    private javax.swing.JComboBox<String> BoxAluno;
    private javax.swing.JComboBox<String> BoxDisciplina;
    private javax.swing.JComboBox<String> BoxUnidade;
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header1;
    private javax.swing.JPanel Main;
    private javax.swing.JTextField NotaInput;
    private javax.swing.JLabel Notas;
    private javax.swing.JTable TabelaNotas;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}