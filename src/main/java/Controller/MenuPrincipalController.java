package Controller;

import Telas.MenuPrincipal;
import Telas.TurmasView;
import javax.swing.JPanel;

/**
 *
 * @author Wedson
 * @author Yagor
 */
public class MenuPrincipalController {

    private final MenuPrincipal tela;
    
    public MenuPrincipalController(MenuPrincipal tela) {
        this.tela = tela;
    }
    
    public void limparTela(){
        JPanel painel = tela.getPainelCentral();
        painel.removeAll();
        painel.revalidate();
        painel.repaint();
    }
    
    public void navegar(JPanel p){
        JPanel painel = tela.getPainelCentral();
        painel.removeAll();
        painel.revalidate();
        painel.repaint();
        
        painel.add(p);
        painel.revalidate();
        painel.repaint();
    }

    public MenuPrincipal getTela() {
        return tela;
    }
    
}
