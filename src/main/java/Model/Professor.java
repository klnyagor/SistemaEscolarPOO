package Model;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class Professor extends Pessoa{
    private double salario;

    public Professor(double salario, String nome, String endereco, String telefone, String email, int id) {
        super(nome, endereco, telefone, email, id);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
