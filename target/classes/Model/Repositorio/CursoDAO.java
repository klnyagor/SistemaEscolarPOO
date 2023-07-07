package Model.Repositorio;

import Model.Curso;
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
public class CursoDAO {
    
    public Curso getCursoByID(int id){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM CURSO WHERE ID=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Curso curso = new Curso(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("turno"));
                return curso;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public boolean adicionar(Curso curso) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        if(curso.getNome().isBlank() || curso.getDescricao().isBlank()){
            return false;
        }
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO curso (id, nome, descricao, turno) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, curso.getId());
            stmt.setString(2, curso.getNome());
            stmt.setString(3, curso.getDescricao());
            stmt.setString(4, curso.getTurno());

            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public List<Curso> listar(){
        List<Curso> cursos = new LinkedList<>();
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM CURSO ORDER BY ID");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("turno"));
                cursos.add(curso);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return cursos;
    }
    
    public boolean atualizar(Curso curso){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        if(curso.getNome().isBlank() || curso.getDescricao().isBlank()){
            return false;
        }
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE CURSO SET nome=?, descricao=?, turno=? WHERE ID=?");
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.setString(3, curso.getTurno());
            stmt.setInt(4,curso.getId());
            
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
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
            stmt = conexao.prepareStatement("DELETE FROM CURSO WHERE ID=?");
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
