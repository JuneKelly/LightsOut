/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsout;

import javax.swing.JButton;

/**
 *
 * @author Shane
 */
public class CellButton extends JButton 
{
    int x, y;
    
    public void set(int xIn, int yIn) 
    {
        this.x = xIn;
        this.y = yIn;
    }
}
