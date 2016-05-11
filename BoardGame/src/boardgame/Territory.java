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
    private Territory[] adjacent;
    
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
    
    public void changeController(Player p){
        controller = p;
    }
    public void changeUnits(int k){
        units = k;
    }
    public boolean isAdjacent(Territory t){
        for(int i = 0; i<adjacent.length; i++){
            if(t.equals(adjacent[i])){
                return true;
            }
        }
        return false;
    }
    
}
