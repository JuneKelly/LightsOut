/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsout;

/**
 *
 * @author Shane
 */
public interface LightGrid 
{
    public void randomizeGrid();
    public void checkIfGridIsSolved();
    public void invertCell(int row, int col);
    public boolean[][] getGrid();
    public void print();
    public boolean isSolved();
}
