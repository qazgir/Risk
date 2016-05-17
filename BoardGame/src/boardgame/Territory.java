/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import javafx.scene.control.Button;

/**
 *
 * @author csstudent
 */
public class Territory {
    private int units;
    private final String territoryName;
    private Player controller;
    private Territory[] adjacent;
    private Button button;
    
    public Territory(int u, String s, Player n, Button b){
        units = u;
        territoryName = s;
    }
    public void setController(Player n){
        controller = n;
        //b.setOnMouseClicked(Put in method 'this.handleClick()');
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
        for (Territory adjacent1 : adjacent) {
            if (t.equals(adjacent1)) {
                return true;
            }
        }
        return false;
    }
}
