package boardgame;

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
    private boolean turn;
    private String phase;
    private int units;
    private String name;
    private Territory[] myTerritory;
   
    
    public String getPhase(){
        return phase;
    }
    
    
    public boolean canMove(){
        if(getPhase().equals("Move")){
            if(units >= 2){
               return true; 
            }
        }
            return false;
    }
    public boolean controlledT(Territory t){
        for(int k = 0; k<myTerritory.length; k++){
            if(myTerritory[k].equals(t)){
                return true;
            }
        }
        return false;
    }
    
    public boolean canAttack(Territory mine, Territory t){
        if(getPhase().equals("Attack")){
            if(this.equals(t.getOccupied()) !=true && this.controlledT(mine)==true){
                return true;
            }
        }
        return false;
    }
    
    public boolean canReinforce(Territory t){
        if(turn == true){
            if(this.equals(t.getOccupied()) == true){
                return true;
            }
        }
        return false;
    }
    
    public int getUnitsPerTurn(){
        
        return units;
        
    }
   
}
