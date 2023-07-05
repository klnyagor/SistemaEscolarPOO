package Model;

/**
 *
 * @author Wedson
 * @author Yagor
 */
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private String descricao;
    private String turno;
    List<Disciplina> disciplinas = new ArrayList<>();
    List<Turma> turmas = new ArrayList<>(); 

    public Curso(int id, String nome, String descricao, String turno) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.turno = turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarTurma(Turma turma){
        this.turmas.add(turma);
    }
    
    public String toString(){
        return getNome();
    }
}
