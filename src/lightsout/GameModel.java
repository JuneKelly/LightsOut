/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsout;

import java.util.ArrayList;



/**
 *
 * @author Shane
 */
public class GameModel 
{
    int rows, columns, moveCount;
    GridManager gridManager;
    ArrayList gridObservers;
    ArrayList gameStateObservers;
    ArrayList countObservers;
    boolean isFinished;
    
    public GameModel() 
    {
        rows = 5;
        columns = 5;
        isFinished = false;
        moveCount = 0;
        
        gridManager = new GridManager(rows, columns);
        gridObservers = new ArrayList();
        gameStateObservers = new ArrayList();
        countObservers = new ArrayList();
    }
    
    public void toggleCell(int x, int y) 
    {
        gridManager.toggleCell(x, y);
        moveCount++;
        notifyGridObservers();
        notifyCountObservers();
        isFinished = gridManager.gameIsFinished;
        if (isFinished) {
            notifyGameStateObservers();
        }
    }
    
    public void addGridObserver(GridObserver o) 
    {
        gridObservers.add(o);
        notifyGridObservers();
    }
    
    public void addGameStateObserver(GameStateObserver o) 
    {
        gameStateObservers.add(o);
        notifyGameStateObservers();
    }
    
    void addCountObserver(CountObserver o) 
    
    {
        countObservers.add(o);
    }
    
    private void notifyGridObservers() 
    {
        for (int i = 0; i < gridObservers.size(); i++) 
        {
            GridObserver o = (GridObserver)gridObservers.get(i);
            o.updateGrid(gridManager.retrieveGrid());
        }
    }
    
    void newGame() 
    {
        gridManager.mainGrid.randomizeGrid();
        isFinished = false;
        moveCount = 0;
        notifyGridObservers();
        notifyCountObservers();
    }

    private void notifyGameStateObservers() 
    {
        for (int i = 0; i < gameStateObservers.size(); i++) 
        {
            GameStateObserver o = (GameStateObserver) gameStateObservers.get(i);
            o.updateGameState(isFinished);
        }
    }
    
    private void notifyCountObservers() 
    {
        for (int i = 0; i < countObservers.size(); i++) 
        {
            CountObserver o = (CountObserver) countObservers.get(i);
            o.updateCount(moveCount);
        }
    }
}
