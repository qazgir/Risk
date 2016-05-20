package boardgame;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csstudent
 */
public class Player {
    private int units;
    private final String name;
    private ArrayList<Territory> territories;
   
    public Player(String name, ArrayList<Territory> myTerritory){
        units = 3;
        this.name = name;
        territories = myTerritory;
    }
    
    public boolean isControlling(Territory t){
        for (Territory territorie : territories) {
            if (territorie.equals(t)) {
                return true;
            }
        }
        return false;
    }
    
    public void addTerritory(Territory t) {
        if (!isControlling(t)) {
            territories.add(t);
        }
    }
    public void surrenderTerritory(Territory t, Player p) {
        if (isControlling(t)) {
            p.addTerritory(t);
            territories.remove(t);
        }
    }
    
    public void setUnitsPerTurn(int u) {
        units = u;
    }
    
    public void refreshNumUnits() {
        int out = 3;
        for (Continent c : Game.getContinents()) {
            if (c.getController().equals(this)) {
                out += c.getControllerUnits();
            }
        }
        units = out;
    }
    
    public int getUnitsPerTurn() {
        refreshNumUnits();
        return units;
    }
    
    public String getName(){
        return name;
    }
   
}
