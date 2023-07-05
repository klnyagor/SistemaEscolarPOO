package Controller.Helper;

import Model.Usuario;
import Telas.Login;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterLogin(){
        String nome = view.getUsuarioINPUT().getText();
        String senha = view.getSenhaINPUT().getText();
        
        Usuario login = new Usuario(0, nome, senha);
        
        return login;
    }
    
//    public void setLogin(Usuario login){;;
//        String nome = login.getUsuario();
//        String senha = login.getSenha();
//        
//        view.getUsuarioINPUT().setText(nome);
//        view.getSenhaINPUT().setText(senha);
//    }
//    
//    public void limpar(){
//        view.getUsuarioINPUT().setText("");
//        view.getSenhaINPUT().setText("");
//    }
    
}
