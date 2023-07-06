package Model.Repositorio;

import Model.Usuario;
import Sistema.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    public boolean insert(String login, String senha){
        Boolean cadastro;
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        if(login.compareTo("") == 0 || senha.compareTo("")==0){
            JOptionPane.showMessageDialog(null, "Ops, algo de errado não está certo..");
            return false;
        }
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("insert into usuario values(?,?)");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            stmt.executeUpdate();
            cadastro = true;
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado");
            return cadastro;
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ops, algo de errado não está certo..");
            return false;
        } finally {
            postgres.close(stmt, conexao);
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
            JOptionPane.showMessageDialog(null, "Ops, algo de errado não está certo..");
        } finally {
            postgres.close(stmt, conexao);
        }
        return null;
    }
 
}
