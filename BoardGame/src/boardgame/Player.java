package boardgame;

import java.util.ArrayList;
import java.util.Arrays;

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
    private String pName;
    private ArrayList<Territory> territories;
   
    public Player(String name, ArrayList<Territory> myTerritory){
        units = 3;
        pName = name;
        territories = myTerritory;
        
    }
    
    public ArrayList<Territory> getTerritories(){
        return territories;
    }
 
    public boolean isControlling(Territory t){
        if(t.getController().equals(this)){
            return true;
        }
        return false;
    }
    
    public void addTerritory(Territory t) {
        if (!isControlling(t)) {
            territories.add(t);
            t.setController(this);
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
    
    public String getpName(){
        return pName;
    }
    
    public int getUnitsPerTurn(){
        int sumUnits = 3;
        for(Continent c: Game.getContinents()){
            if(c.getController().equals(this)){
               sumUnits = sumUnits + c.getControllerUnits(); 
            }
        }
        return sumUnits;
    }
}
