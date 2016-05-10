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
    
    public Territory(int u, String s){
        units = u;
        territoryName = s;
    }
    public int getUnits(){
        return units;
    }
    public String getName(){
        return territoryName;
    }
    /*
    public Player getOccupied(){
        
    }
    
    */
}
