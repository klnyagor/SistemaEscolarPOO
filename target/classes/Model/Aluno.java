package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class Aluno extends Pessoa{
    private Map<Disciplina,Double> disciplinas = new HashMap<>();
    private Map<Integer,Boolean> horasAulas = new HashMap<>();
    
    public Aluno(String nome, String endereco, String telefone, String email, int id) {
        super(nome, endereco, telefone, email, id);
        for(int i=1;i<=5;i++){
            horasAulas.put(i, true);
        }
    }

    public void getDisciplinas() {
        for(Disciplina nome: disciplinas.keySet()){
            System.out.println(nome);
        }
    }

    public void getHorasAulas() {
        for(int i=1;i<=horasAulas.size();i++){
            Boolean hora = horasAulas.get(i);
            if(hora){
                System.out.print(i);
            }
        }
        System.out.println();
    }
    
    public int horariosLivres(int i){
        if(horasAulas.containsKey(i)){
            Boolean validacao = horasAulas.get(i);
            if(validacao){
                return i;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
    public void adicionarDisciplina(Disciplina disciplina){
        this.disciplinas.put(disciplina,0.0);
        horasAulas.replace(disciplina.getHora(), true, false);
    }
    public Map<Disciplina,Double> quantidadeDisciplinas(){
        return this.disciplinas;
    }
    public void notas(){
        for(Double nota: disciplinas.values()){
            System.out.println(nota);
        }
    }
 
    public String toString(){
        return getNome();
    }
}
