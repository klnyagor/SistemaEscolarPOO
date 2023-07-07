package Model.Repositorio;

import Model.Curso;
import Model.Disciplina;
import Model.Professor;
import Model.Turma;
import Sistema.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class TurmaDAO {
    
    public Turma getTurmaByID(int id){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        CursoDAO cursos = new CursoDAO();
        ProfessorDAO professores = new ProfessorDAO();
        DisciplinaDAO disciplinas = new DisciplinaDAO();
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM TURMA WHERE ID=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Curso ref_curso = cursos.getCursoByID(rs.getInt("ref_curso"));
                Professor ref_prof = professores.getProfessorByID(rs.getInt("ref_prof"));
                Disciplina ref_disc = disciplinas.getDisciplinaByID(rs.getInt("ref_disc"));
                Turma turma = new Turma(rs.getInt("id"), ref_curso, ref_prof, ref_disc, rs.getInt("horario"), rs.getString("turno"), rs.getString("periodo"));
                return turma;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public boolean adicionar(Turma turma){
        if(turma.getPeriodo().isBlank()){
            return false;
        }
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try{
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO TURMA (id, ref_disc, ref_curso, ref_prof, turno, periodo, horario) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, turma.getId());
            stmt.setInt(2, turma.getDisciplina().getId());
            stmt.setInt(3, turma.getCurso().getId());
            stmt.setInt(4, turma.getProfessor().getId());
            stmt.setString(5, turma.getTurno());
            stmt.setString(6, turma.getPeriodo());
            stmt.setInt(7, turma.getHorario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public List<Turma> listar(){
        List<Turma> turmas = new LinkedList<>();
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        String sql = "SELECT t.id, t.horario, t.periodo, t.turno, "
                + "c.nome as nomeCurso, c.id as idCurso, c.descricao as descricaoCurso, c.turno as turnoCurso, "
                + "p.nome as nomeProf, p.id as idProf, p.salario as salarioProf, p.endereco as enderecoProf, p.telefone as telefoneProf, p.email as emailProf, "
                + "d.nome as nomeDisc, d.id as idDisc, d.hora as horaDisc "
                + "FROM TURMA as t, DISCIPLINA as d, CURSO as c, PROFESSOR as p "
                + "WHERE t.REF_DISC = d.ID AND t.REF_CURSO = c.ID AND t.REF_PROF = p.ID ORDER BY t.id";
//        
        try{
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Curso curso = new Curso(rs.getInt("idCurso"), rs.getString("nomeCurso"), rs.getString("descricaoCurso"), rs.getString("turnoCurso"));
                Disciplina disciplina = new Disciplina(rs.getInt("idDisc"),rs.getInt("horaDisc"), rs.getString("nomeDisc"));
                Professor professor = new Professor(rs.getDouble("salarioProf"),rs.getString("nomeProf"), rs.getString("enderecoProf"), rs.getString("telefoneProf"), rs.getString("emailProf"),rs.getInt("idProf"));
                Turma turma = new Turma(rs.getInt("id"), curso, professor, disciplina, rs.getInt("horario"), rs.getString("turno"), rs.getString("periodo"));
                turmas.add(turma);
            }
            
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        
        return turmas;
    }
    
    public boolean atualizar(Turma turma){
        if(turma.getPeriodo().isBlank()){
            return false;
        }
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE TURMA SET ref_disc=?, ref_curso=?, ref_prof=?, turno=?, periodo=?, horario=? WHERE ID=?");
            stmt.setInt(1, turma.getDisciplina().getId());
            stmt.setInt(2, turma.getCurso().getId());
            stmt.setInt(3, turma.getProfessor().getId());
            stmt.setString(4, turma.getTurno());
            stmt.setString(5, turma.getPeriodo());
            stmt.setInt(6, turma.getHorario());
            stmt.setInt(7, turma.getId());
            
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public boolean deletar(int id){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM TURMA WHERE ID=?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
        
}
