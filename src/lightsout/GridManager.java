/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsout;

/**
 *
 * @author Shane
 */
public class GridManager 
{
    LightGrid mainGrid;
    boolean gameIsFinished;
    boolean isTest;
    
    public GridManager(int rowsIn, int columnsIn) 
    {
        isTest = false;
        if (isTest == false) {
            mainGrid = new LightGridStandardImpl(rowsIn, columnsIn);
        } else {
            mainGrid = new LightGridTestImpl(rowsIn, columnsIn);
        }
        gameIsFinished = false;
    }
    
    public void toggleCell(int row, int col) 
    {
        mainGrid.invertCell(row, col);
        mainGrid.invertCell((row-1), col);
        mainGrid.invertCell(row, (col-1));
        mainGrid.invertCell((row+1), col);
        mainGrid.invertCell(row, (col+1));
        
        checkGrid();
    }
    
    public void checkGrid() 
    {
        mainGrid.checkIfGridIsSolved();
        if (mainGrid.isSolved()) {
            gameIsFinished = true;
        }
    }
    
    boolean[][] retrieveGrid() 
    {
        return mainGrid.getGrid();
    }
}
