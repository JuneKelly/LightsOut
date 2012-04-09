/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Shane
 */
public class GameController implements ActionListener 
{
    GameModel model;
    GameView view;
    
    public GameController(GameModel modelIn) 
    {
        model = modelIn;
        view = new GameView(this, modelIn);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        CellButton button = (CellButton)e.getSource();
        
        model.toggleCell(button.x, button.y);
    }
    
    public void startNewGame() 
    {
        model.newGame();
    }
}
