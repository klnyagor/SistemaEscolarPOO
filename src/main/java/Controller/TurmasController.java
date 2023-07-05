package Controller;

import Model.Curso;
import Model.Disciplina;
import Model.Professor;
import Model.Repositorio.CursoDAO;
import Model.Repositorio.DisciplinaDAO;
import Model.Repositorio.ProfessorDAO;
import Telas.Cadastro.TurmaCadastro;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class TurmasController {
    
    private final TurmaCadastro view;

    public TurmasController(TurmaCadastro view) {
        this.view = view;
    }
    
    public void listarCurso(){
        //Buscar cursos do banco
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = new LinkedList<>(cursoDAO.listar());
        
        //Preencher campos do ComboBox
        DefaultComboBoxModel boxT = (DefaultComboBoxModel) view.getTurmaBoxCurso().getModel();
        for(Curso c: cursos){
            boxT.addElement(c);
        }
    }
    
    public void listarDisciplina(){
        DisciplinaDAO discDAO = new DisciplinaDAO();
        List<Disciplina> disc = new LinkedList<>(discDAO.listar());
        DefaultComboBoxModel boxD = (DefaultComboBoxModel) view.getTurmaBoxDisciplina().getModel();
        for(Disciplina d: disc){
            boxD.addElement(d);
        }
    }
    
    public void listarProfessor(){
        ProfessorDAO profDAO = new ProfessorDAO();
        List<Professor> prof = new LinkedList<>(profDAO.listar());
        DefaultComboBoxModel boxP = (DefaultComboBoxModel) view.getTurmaBoxProfessor().getModel();
        for(Professor p: prof){
            boxP.addElement(p);
        }
    }
    
}
