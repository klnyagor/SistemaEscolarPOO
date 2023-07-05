package Model.Repositorio;

import Model.Aluno;
import Model.Disciplina;
import Model.Notas;
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
public class NotasDAO {
    public void adicionarNota(Disciplina disciplina, Aluno aluno, double nota, int unidade){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("insert into notas"+unidade+" values(?,?,?)");
            stmt.setInt(1, disciplina.getId());
            stmt.setInt(2, aluno.getId());
            stmt.setDouble(3, nota);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    public void alterarNota(Disciplina disciplina, Aluno aluno, Double nota, int unidade){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE notas SET nota"+unidade+" = ? where ref_disc = ? and ref_aluno = ?");
            stmt.setInt(2, disciplina.getId());
            stmt.setInt(3, aluno.getId());
            stmt.setDouble(1, nota);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    public void removerNota(Disciplina disciplina, Aluno aluno, int unidade){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE notas SET nota"+unidade+" = 0");
            stmt.setInt(1, disciplina.getId());
            stmt.setInt(2, aluno.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    public List<Notas> PegarNotas(Aluno aluno){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        List<Notas> lista = new ArrayList<>();
        ResultSet rs;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT disciplina.nome, notas.nota1, notas.nota2, notas.nota3 FROM disciplina INNER JOIN notas ON disciplina.id = notas.ref_disc WHERE notas.ref_aluno = ?");
            stmt.setInt(1, aluno.getId());

            rs = stmt.executeQuery();
            while(rs.next()){
                lista.add(new Notas(rs.getString("nome"),rs.getDouble("nota1"),rs.getDouble("nota2"),rs.getDouble("nota3")));
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
