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
public class Continent {
    private final Territory[] territories;
    private final String name;
    private final int controllerUnits;
    
    public Continent(int u, String n, Territory[] t){
        controllerUnits = u;
        name = n;
        territories = t;
    }
    public Territory[] getTerritory(){
        return territories;
    }
    
    public int getControllerUnits(){
        return controllerUnits;
    }
    public boolean getControlled(){
        int counter = 0;
        Player controller = territories[0].getOccupied();
        while(counter!=territories.length){
            if(territories[counter].getOccupied()!=controller){
                return false;
            }
            counter++;
        }
        return true;
    }
}
