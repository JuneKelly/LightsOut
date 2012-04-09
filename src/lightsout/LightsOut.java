/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsout;

/**
 *
 * @author Shane
 */
public class LightsOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create the game model, then create the controller, which in turn creates the view.
        // Program runs until user exits the view.
        
        GameModel model = new GameModel();
        GameController controller = new GameController(model);
        
    }
}
