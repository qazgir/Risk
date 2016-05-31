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
    
    public Button getButton(){
        return linkedButton; 
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
        refreshText();
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
        if (Game.getCurrentPhase().equals("reinforce")) {
            //in reinforce phase
            if (Game.getPlayingPlayer().equals(this.controller)) {
                //territory is valid
                changeUnits(units+1);
                Game.setReinforceUnits(Game.getReinforceUnits()-1);
                if (Game.getReinforceUnits() == 0) {
                    //out of reinforce units
                    TurnPhases.attack(this.controller);
                }
            }
        } else if (Game.getCurrentPhase().equals("attack")) {
            //in attack phase
            if (Game.getFromTerritory() == null) {
                if (Game.getPlayingPlayer().equals(this.controller) && this.units >= 2) {
                    Game.setFromTerritory(this);
                }
            } else {
                if (!(Game.getPlayingPlayer().equals(this.controller)) && Game.getFromTerritory().isAdjacent(this)) {
                    Territory from = Game.getFromTerritory();
                    ArrayList<Integer> attackingDice = TurnPhases.rollNumDice(Math.min(from.getUnits() - 1, 3));
                    ArrayList<Integer> defendingDice = TurnPhases.rollNumDice(Math.min(this.getUnits() - 1, 2));
                    for (int i = Math.min(attackingDice.size(), defendingDice.size())-1; i >= 0; i--) {
                        if (attackingDice.get(i) > defendingDice.get(i)) {
                            this.changeUnits(this.getUnits()-1);
                        } else {
                            from.changeUnits(from.getUnits()-1);
                        }
                    }
                    if (this.getUnits() <= 0) {
                        this.getController().surrenderTerritory(this, Game.getPlayingPlayer());
                        TurnPhases.moveSingle(from, this);
                    }
                    Game.setFromTerritory(null);
                } else if (this.equals(Game.getFromTerritory())) {
                    Game.setFromTerritory(null);
                }
            }
        } else if (Game.getCurrentPhase().equals("move")) {
            //in move phase
            if (Game.getFromTerritory() == null) {
                if (Game.getPlayingPlayer().equals(this.controller) && this.units > 1) {
                    Game.setFromTerritory(this);
                }
            } else {
                if (Game.getPlayingPlayer().equals(this.controller) && Game.getFromTerritory().isAdjacent(this)) {
                    TurnPhases.moveSingle(Game.getFromTerritory(), this);
                }
            }
        }
    }
    
    public void refreshText() {
        this.linkedButton.setText(territoryName+":"+units);
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
