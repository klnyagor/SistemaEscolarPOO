package Controller.Helper;

import Model.Usuario;
import Telas.Cadastro.UsuarioCadastro;
import Telas.Login;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class LoginHelper {
    
    private final Login view;
    private final UsuarioCadastro viewCad;
    

    public LoginHelper(Login view) {
        this.view = view;
        this.viewCad=null;
    }
    public LoginHelper(UsuarioCadastro viewCad) {
        this. viewCad = viewCad;
        this.view=null;
    }
    
    public Usuario obterLogin(){
        String nome = view.getUsuarioINPUT().getText();
        String senha = view.getSenhaINPUT().getText();
        
        Usuario login = new Usuario(nome, senha);
        
        return login;
    }

    
}
