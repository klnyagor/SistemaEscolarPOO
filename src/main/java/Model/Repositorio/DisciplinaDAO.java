package Model.Repositorio;

import Model.Aluno;
import Model.Disciplina;
import Sistema.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class DisciplinaDAO {
    
    public Disciplina getDisciplinaByID(int id){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM DISCIPLINA WHERE ID=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Disciplina disciplina = new Disciplina(rs.getInt("id"), rs.getInt("hora"), rs.getString("nome"));
                return disciplina;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public boolean adicionar(Disciplina disciplina) {
        boolean retorno = true;
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO disciplina (id, nome, hora) VALUES (?, ?, ?)");
            stmt.setInt(1, disciplina.getId());
            stmt.setString(2, disciplina.getNome());
            stmt.setInt(3, disciplina.getHora());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        } finally {
            postgres.close(stmt, conexao);
            return retorno;
        }
    }
    
    public List<Disciplina> listar(){
        List<Disciplina> disciplinas = new LinkedList<>();
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM DISCIPLINA ORDER BY ID");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina(rs.getInt("id"),rs.getInt("hora"), rs.getString("nome"));
                disciplinas.add(disciplina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return disciplinas;
    }
    
    public boolean atualizar(Disciplina disciplina){
        boolean retorno = true;
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE DISCIPLINA SET hora=?, nome=? WHERE ID=?");
            stmt.setInt(1,disciplina.getHora());
            stmt.setString(2, disciplina.getNome());
            stmt.setInt(3,disciplina.getId());
                        
            stmt.executeUpdate();
        } catch (SQLException e) {
            retorno = false;
            e.printStackTrace();
        } finally {
            postgres.close(stmt, conexao);
            return retorno;
        }
    }
    
    public boolean deletar(int id){
        boolean retorno = true;
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM notas WHERE ref_disc=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("DELETE FROM horariosocupados WHERE ref_disc=?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            stmt = conexao.prepareStatement("DELETE FROM DISCIPLINA WHERE ID=?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            retorno = false;
        } finally {
            postgres.close(null, stmt, conexao);
            return retorno;
        }
    }
    public List<Disciplina> disciplinasAluno(Aluno aluno){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        List<Disciplina> lista = new ArrayList<>();
        ResultSet rs ;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT disciplina.* FROM disciplina INNER JOIN turma ON"
                    + " disciplina.id = turma.ref_disc INNER JOIN matricula ON turma.id = matricula.ref_turma "
                    + "WHERE matricula.ref_aluno = ?");
            stmt.setInt(1, aluno.getId());

            rs = stmt.executeQuery();
            while(rs.next()){
                lista.add(new Disciplina(rs.getInt("id"),rs.getInt("hora"), rs.getString("nome")));
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
        return null;
    }
    
}
