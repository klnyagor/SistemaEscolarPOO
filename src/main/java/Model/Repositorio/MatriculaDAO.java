package Model.Repositorio;

import Model.Aluno;
import Model.Curso;
import Model.Disciplina;
import Model.Professor;
import Model.Turma;
import Sistema.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class MatriculaDAO {
    public void Matricular(Aluno aluno, Turma turma){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO matricula(ref_aluno, ref_turma) VALUES(?,?)");
            stmt.setInt(1, aluno.getId());
            stmt.setInt(2, turma.getId());
            stmt.executeUpdate();
            stmt = conexao.prepareStatement("INSERT INTO horariosocupados(ref_aluno, ref_disc, horario) VALUES(?,?,?)");
            stmt.setInt(1, aluno.getId());
            stmt.setInt(2, turma.getId());
            stmt.setInt(3, turma.getHorario());
            stmt.executeUpdate();
            stmt = conexao.prepareStatement("INSERT INTO notas(ref_aluno, ref_disc) VALUES(?,?)");
            stmt.setInt(1, aluno.getId());
            stmt.setInt(2, turma.getDisciplina().getId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    // retorna uma lista de turma que o aluno pode se matricular e nao esta matriculado ainda
    public List<Turma> alunoNaoMatriculado(int id){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        List<Turma> lista = new ArrayList<>();
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT t.id, t.horario, t.periodo, t.turno,c.nome as nomeCurso,"
                    + "c.id as idCurso, c.descricao as descricaoCurso, c.turno as turnoCurso, p.nome as nomeProf, "
                    + "p.id as idProf, p.salario as salarioProf, p.endereco as enderecoProf, p.telefone as "
                    + "telefoneProf, p.email as emailProf, d.nome as nomeDisc, d.id as idDisc, d.hora as horaDisc "
                    + "FROM TURMA as t JOIN DISCIPLINA as d ON t.ref_disc = d.id JOIN CURSO as c ON t.ref_curso = c.id "
                    + "JOIN PROFESSOR as p ON t.ref_prof = p.id LEFT JOIN horariosocupados as h ON d.id = h.ref_disc "
                    + "AND h.ref_aluno = ? WHERE h.ref_disc IS NULL AND t.horario NOT IN (SELECT horario "
                    + "FROM horariosocupados WHERE ref_aluno = ?);");
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                Curso curso = new Curso(rs.getInt("idCurso"), rs.getString("nomeCurso"), rs.getString("descricaoCurso"), rs.getString("turnoCurso"));
                Disciplina disciplina = new Disciplina(rs.getInt("idDisc"),rs.getInt("horaDisc"), rs.getString("nomeDisc"));
                Professor professor = new Professor(rs.getDouble("salarioProf"),rs.getString("nomeProf"), rs.getString("enderecoProf"), rs.getString("telefoneProf"), rs.getString("emailProf"),rs.getInt("idProf"));
                Turma turma = new Turma(rs.getInt("id"), curso, professor, disciplina, rs.getInt("horario"), rs.getString("turno"), rs.getString("periodo"));
                lista.add(turma);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    public void Desmatricular(Aluno aluno, Disciplina disciplina){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM horariosocupados WHERE ref_aluno = ? and ref_disc = ?");
            stmt.setInt(1, aluno.getId());
            stmt.setInt(2, disciplina.getId());
            stmt.executeUpdate();
            stmt = conexao.prepareStatement("DELETE FROM matricula WHERE ref_aluno = ? AND"
                    + " ref_turma IN (SELECT turma.id FROM turma INNER JOIN disciplina ON "
                    + "turma.ref_disc = disciplina.id WHERE disciplina.id = ?);");
            stmt.setInt(1, aluno.getId());
            stmt.setInt(2, disciplina.getId());
            stmt.executeUpdate();
            stmt = conexao.prepareStatement("DELETE FROM notas where ref_aluno = ? and ref_disc = ?");
            stmt.setInt(1, aluno.getId());
            stmt.setInt(2, disciplina.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(stmt, conexao);
        }
    }
}
