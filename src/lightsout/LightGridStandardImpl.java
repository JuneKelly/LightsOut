/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsout;

/**
 *
 * @author Shane
 */
public class LightGridStandardImpl implements LightGrid 
{
    int rows;
    int columns;
    boolean isSolved;
    
    boolean[][] grid;
    
    public LightGridStandardImpl(int rowsIn, int columnsIn)
    {
        rows = rowsIn;
        columns = columnsIn;
        
        grid = new boolean[rows][columns];
        
        isSolved = false;
        
        randomizeGrid();
    }
    
    @Override
    public void randomizeGrid()
    {
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++)
            {
                double n = Math.random();
                if (n >= 0.72) {
                    grid[i][j] = true;
                } else {
                    grid[i][j] = false;
                }
            }
        }
        
        checkIfGridIsSolved();
        if (isSolved) {
            randomizeGrid();
        }
    }
    
    @Override
    public void checkIfGridIsSolved() {
        boolean gridHasActiveCells = false;
        
        for (int i = 0; i < rows; i++) 
        {
            boolean rowHasActiveCells = false;
            
            for (int j = 0; j < columns; j++) 
            {
                if (grid[i][j] == true) {
                    rowHasActiveCells = true;
                    break;
                } else {
                    continue;
                }
            }
            
            if (rowHasActiveCells) {
                gridHasActiveCells = true;
                break;
            } else {
                continue;
            }
        }
        
        if (gridHasActiveCells) {
            isSolved = false;
        } else {
            isSolved = true;
        }
    }
    
    @Override
    public void invertCell(int row, int col) 
    {
        if (row >= 0 && row < rows && col >=0 && col < columns) {
            if (grid[row][col] == true) {
                grid[row][col] = false;
            } else {
                grid[row][col] = true;
            }
        }
    }
    
    @Override
    public boolean[][] getGrid() 
    {
        return this.grid;
    }
    
    public void print() 
    {
        for (int i = 0; i < rows; i++) 
        {
            System.out.print("\n");
            for (int j = 0; j < columns; j++) 
            {
                if (grid[i][j] == true) {
                    System.out.print(" X");
                } else {
                    System.out.print(" o");
                }
            }
            
        }
        System.out.print("\n");
    }

    @Override
    public boolean isSolved() {
        return this.isSolved;
    }
}
