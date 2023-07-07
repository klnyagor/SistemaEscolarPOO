package Model.Repositorio;

import Model.Professor;
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
public class ProfessorDAO {
    
    public Professor getProfessorByID(int id){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM PROFESSOR WHERE ID=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Professor professor = new Professor(rs.getInt("salario"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("email"), rs.getInt("id"));
                return professor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public boolean adicionar(Professor professor){
        if(professor.getNome().isBlank() || professor.getEndereco().isBlank() || professor.getTelefone().isBlank() || professor.getEmail().isBlank()){
            return false;
        }
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO PROFESSOR(id, nome, endereco, telefone, email, salario) VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, professor.getId());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getEndereco());
            stmt.setString(4, professor.getTelefone());
            stmt.setString(5, professor.getEmail());
            stmt.setDouble(6,professor.getSalario());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public List<Professor> listar(){
        List<Professor> professores = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM PROFESSOR ORDER BY ID");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor(rs.getDouble("salario"),rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("email"),rs.getInt("id"));
                professores.add(professor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return professores;
    }
    
    public boolean atualizar(Professor professor){
        if(professor.getNome().isBlank() || professor.getEndereco().isBlank() || professor.getTelefone().isBlank() || professor.getEmail().isBlank()){
            return false;
        }
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE PROFESSOR SET nome=?, endereco=?, telefone=?, email=?, salario=? WHERE ID=?");
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEndereco());
            stmt.setString(3, professor.getTelefone());
            stmt.setString(4, professor.getEmail());
            stmt.setDouble(5,professor.getSalario());
            stmt.setInt(6,professor.getId());
            
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
            stmt = conexao.prepareStatement("delete from matricula where ref_turma in (select id from turma where turma.ref_prof = ?)");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("delete from turma where ref_prof = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("DELETE FROM PROFESSOR WHERE ID=?");
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
