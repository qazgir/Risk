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
    private Territory[] territories;
    private String name;
    
    public Territory[] getTerritory(){
        return territories;
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
