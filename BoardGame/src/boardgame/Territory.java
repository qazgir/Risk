/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import javafx.scene.control.Button;
import java.util.*;

/**
 *
 * @author csstudent
 */
public class Territory {
    private int units;
    private final String territoryName;
    private Player controller;
    private ArrayList<Territory> adjacent;
    private final Button linkedButton;
    
    public Territory(int u, String s, Button b){
        linkedButton = b;
        units = u;
        territoryName = s;
        linkedButton.setText(s +":"+u);
    }
    public void setController(Player n){
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
        for (Territory adjacent1 : adjacent) {
            if (t.equals(adjacent1)) {
                return true;
            }
        }
        return false;
    }
    public void addAdjacent(Territory t){
        adjacent.add(t);
    }
    
}
