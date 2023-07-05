package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class Turma {
    private int id;
    private Curso curso;
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos = new ArrayList<>();
    private int horario;
    private String turno;
    private String periodo;

    public Turma(int id, Curso curso, Professor professor, Disciplina disciplina, int horario, String turno, String periodo) {
        this.id = id;
        this.curso = curso;
        this.professor = professor;
        this.disciplina = disciplina;
        this.horario = horario;
        this.turno = turno;
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }
   
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
   
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    public void adicionarAlunos(Aluno aluno){
        this.alunos.add(aluno);
    }
    
    public String toString(){
        return String.valueOf(getId());
    }
}
