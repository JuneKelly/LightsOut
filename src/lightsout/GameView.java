/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author Shane
 */
public class GameView implements GridObserver, GameStateObserver, CountObserver 
{
    String windowTitle;
    int rows, columns;
    GameController controller;
    boolean[][] currentGrid;
    JFrame mainWindow;
    CellButton[][] buttonGrid;
    
    
    public GameView(GameController controllerIn, GameModel modelIn) 
    {
        this.controller = controllerIn;
        modelIn.addGridObserver(this);
        modelIn.addGameStateObserver(this);
        modelIn.addCountObserver(this);
        windowTitle = "Lights Out! v0.01";
        
        rows = modelIn.rows;
        columns = modelIn.columns;
        
        buttonGrid = new CellButton[rows][columns];
        createWindow();
    }   
    
    public void updateGrid(boolean[][] gridIn) 
    {
        this.currentGrid = gridIn;
        drawGrid();
    }
    
    private void drawGrid() 
    {
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                if (currentGrid[i][j] == true) {
                    buttonGrid[i][j].setBackground(Color.white);
                } else {
                    buttonGrid[i][j].setBackground(Color.black);
                }
            }
        }
    }
    
    private void createWindow() 
    {
        
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }	
        catch(Exception e) {}
        
        mainWindow = new JFrame(windowTitle);
        Toolkit toolkit = Toolkit.getDefaultToolkit();	
	Dimension scrnsize = toolkit.getScreenSize();
        
        mainWindow.setBounds(scrnsize.width/3, scrnsize.height/5, 500, 500);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BorderLayout border = new BorderLayout();
        
        // Create menubar
        JMenuBar menuBar = new JMenuBar();
        JButton newGameItem = new JButton("New Game");
        
        newGameItem.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                controller.startNewGame();
            }
        });
        menuBar.add(newGameItem);
        
        GridLayout gridLayout = new GridLayout(rows, columns, 2, 2);
        
	mainWindow.setLayout(border);
        JPanel pane = new JPanel(gridLayout);
        pane.setBackground(Color.DARK_GRAY);
        
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                CellButton button = new CellButton();
                button.set(i, j);
                button.setSize(16, 16);
                button.addActionListener(controller);
                button.setOpaque(true);
                buttonGrid[i][j] = button;
                pane.add(button);
            }
        }
        
        mainWindow.add(menuBar, BorderLayout.NORTH);
        mainWindow.add(pane, BorderLayout.CENTER);
        
        drawGrid();
        
        mainWindow.setVisible(true);
    }

    @Override
    public void updateGameState(boolean isFinished) 
    {
        if (isFinished) {
            int response = JOptionPane.showConfirmDialog(mainWindow, 
                    "Congratulations!, play again?", "You Win!", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (response == JOptionPane.YES_OPTION) {
                controller.startNewGame();
            } else {
                System.exit(1);
            }
        }
    }

    @Override
    public void updateCount(int countIn) 
    {
        mainWindow.setTitle(windowTitle + "    [moves: " + countIn + "]");
    }
}
