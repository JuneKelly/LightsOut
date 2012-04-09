/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import lightsout.*;
/**
 *
 * @author Shane
 */
public class testGrid {
    public static void main(String[] args) {
        System.out.println("--Testing LightGrid class--");
        
        LightGrid grid = new LightGridTestImpl(5, 5);
        
        grid.print();
    }
}
