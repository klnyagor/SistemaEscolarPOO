package Model;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class Matricula {
    
    public Matricula() {
    }

    public void fazerMatricula(Aluno aluno, Turma turma){
        turma.adicionarAlunos(aluno);
        aluno.adicionarDisciplina(turma.getDisciplina());
    }
    
    
}
