package Controller;

import Controller.Helper.LoginHelper;
import Model.Repositorio.UsuarioDAO;
import Model.Usuario;
import Telas.Login;
import Telas.MenuPrincipal;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void acessar(){
        Usuario user = helper.obterLogin();
        
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario login = userDAO.selectPorNomeESenha(user);
        
        if(login != null ){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            view.dispose();
        }else{
            view.exibeMensagem("Usuario ou Senha Inválido!");
        }
        
        
    }
    
}
