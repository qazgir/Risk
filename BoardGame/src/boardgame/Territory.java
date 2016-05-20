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
    private ArrayList<Territory> adjacent = new ArrayList<Territory>();
    private final Button linkedButton;
    
    public Territory(int u, String s, Button b){
        linkedButton = b;
        units = u;
        territoryName = s;
        linkedButton.setText(this.territoryName +":"+u);
        linkedButton.setOnMouseClicked(event -> this.handleClick());
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
    
    public boolean getOccupied(){
        if(controller == null){
            return false;
        } else {
            return true;
        }
    }
    
    public Player getController(){
        return controller;
    }
    
    public void changeController(Player p){
        controller = p;
    }
    public void changeUnits(int k){
        units = k;
    }
    public boolean isAdjacent(Territory t){
        for (int k = 0; k<adjacent.size(); k++) {
            if (t.equals(adjacent.get(k))) {
                return true;
            }
        }
        return false;
    }
    public void addCornerAdjacent(Territory t, Territory m, Territory d){
        adjacent.add(t);
        adjacent.add(m);
        adjacent.add(d);
    }
    
    public void handleClick() {
        Game.setLastClickedTerritory(this);
    }
    public void addSideAdjacent(Territory t, Territory m, Territory d, Territory e, Territory f){
        adjacent.add(t);
        adjacent.add(m);
        adjacent.add(d);
        adjacent.add(e);
        adjacent.add(f);
    }
    public void addMiddleAdjacent(Territory t, Territory m, Territory d, Territory e, Territory f, Territory g, Territory b, Territory x){
        adjacent.add(t);
        adjacent.add(m);
        adjacent.add(d);
        adjacent.add(e);
        adjacent.add(f);
        adjacent.add(g);
        adjacent.add(b);
        adjacent.add(x);
    }
    
    public Button getLinkedButton(){
        return linkedButton;
    }
}
