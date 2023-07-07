package Model.Repositorio;

import Model.Aluno;
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
public class AlunoDAO {
    
    public Aluno getAlunoByID(int id){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM ALUNO WHERE ID=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("email"), id);
                return aluno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }
    
    public boolean adicionar(Aluno aluno){
        if(aluno.getNome().isBlank() || aluno.getEndereco().isBlank() || aluno.getTelefone().isBlank() || aluno.getEmail().isBlank()){
            return false;
        }
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO ALUNO(id, nome, endereco, telefone, email) VALUES(?,?,?,?,?)");
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEndereco());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public List<Aluno> listar(){
        List<Aluno> alunos = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM ALUNO ORDER BY ID");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("email"),rs.getInt("id"));
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return alunos;
    }
    
    public boolean atualizar(Aluno aluno){
        if(aluno.getNome().isBlank() || aluno.getEndereco().isBlank() || aluno.getTelefone().isBlank() || aluno.getEmail().isBlank()){
            return false;
        }
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE ALUNO SET nome=?, endereco=?, telefone=?, email=? WHERE ID=?");
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getEmail());
            stmt.setInt(5,aluno.getId());
            
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
            stmt = conexao.prepareStatement("DELETE FROM horariosocupados WHERE ref_aluno=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("DELETE FROM notas WHERE ref_aluno=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("DELETE FROM matricula WHERE ref_aluno=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("DELETE FROM ALUNO WHERE id=?");
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
