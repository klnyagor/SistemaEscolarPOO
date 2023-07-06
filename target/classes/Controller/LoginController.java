package Controller;

import Controller.Helper.LoginHelper;
import Model.Repositorio.UsuarioDAO;
import Model.Usuario;
import Telas.Cadastro.UsuarioCadastro;
import Telas.Login;
import Telas.MenuPrincipal;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class LoginController {

    private final Login view;
    private final UsuarioCadastro viewCadastro;
    private LoginHelper helper;
    
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
        this.viewCadastro=null;
    }
    public LoginController(UsuarioCadastro viewCadastro) {
        this.viewCadastro = viewCadastro;
        this.helper = new LoginHelper(viewCadastro);
        this.view=null;
    }
    
    public void acessar(String nome, String senha){
        Usuario user = helper.obterLogin();
        
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario login = userDAO.selectPorNomeESenha(nome, senha);
        if(login != null ){
            MenuPrincipal menu = new MenuPrincipal(nome);
            menu.setVisible(true);
            view.dispose();
        }else{
            view.exibeMensagem("Usuario ou Senha Inválido!");
        }
        
    }
    public void cadastro(){
        UsuarioCadastro menu = new UsuarioCadastro();
        menu.setVisible(true);
        view.dispose();
    }
    public void Login(){
        Login login = new Login();
        login.setVisible(true);
    }
}
