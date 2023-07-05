package Model;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class Disciplina {
    private int id;
    private String nome;
    private int hora;

    public Disciplina(int id, int hora, String nome) {
        this.id = id;
        this.hora = hora;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return getNome();
    }
}
