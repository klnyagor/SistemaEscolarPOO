package Model.Repositorio;

import Model.Usuario;
import java.util.ArrayList;

public class Banco {
    
    public static ArrayList<Usuario> usuario;
    public static void inicia(){
    
        usuario = new ArrayList<>();
        
        Usuario admin = new Usuario(1, "admin", "admin");
        usuario.add(admin);
        
    }
    
}
