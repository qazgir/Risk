/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

/**
 *
 * @author csstudent
 */
public class Territory {
    private int units;
    private String territoryName;
    private Player controller;
    
    public Territory(int u, String s, Player n){
        units = u;
        territoryName = s;
        controller = n;
    }
    public int getUnits(){
        return units;
    }
    public String getName(){
        return territoryName;
    }
    
    public Player getOccupied(){
        return controller;
    }
    
    
    
}
