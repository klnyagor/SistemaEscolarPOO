package Model.Repositorio;

import Model.Usuario;
import Sistema.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean insert(String login, String senha){
        Boolean cadastro;
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        if(login.trim().isEmpty() || senha.trim().isEmpty()){
            return false;
        }
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("insert into usuario values(?,?)");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            stmt.executeUpdate();
            cadastro = true;
            return cadastro;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
    public boolean update(String login, String senha){
        if(login.trim().isEmpty() || senha.trim().isEmpty()){
            return false;
        }
        
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE USUARIO SET senha=? WHERE LOGIN=?");
            stmt.setString(2, login);
            stmt.setString(1, senha);
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            postgres.close(stmt, conexao);
        }
        
    }
    
    public boolean delete(Usuario usuario){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        
        try{
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM USUARIO WHERE LOGIN=? AND SENHA=?");
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally{
            postgres.close(null, stmt, conexao);
        }
    }

    public Usuario selectPorNomeESenha(String nome, String senha){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        ResultSet rs;
        
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("select * from usuario where login=? and senha = ?");
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            while(rs.next()){
                return new Usuario(rs.getString("login"),rs.getString("senha"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            postgres.close(stmt, conexao);
        }
        return null;
    }
 
}
