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
    private String territory;
   
    
    public String getPhase(){
        return phase;
    }
    
    public int getUnits(){
        return units;
    }
    
    public boolean canMove(){
        if(getPhase().equals("Move")){
            if(units <= 3){
               return true; 
            }
        }
            return false;
    }
    
    public boolean canAttack(){
        if(getPhase().equals("attack")){
            if(territory.equals("home") == false){
                return true;
            
            }
        }
        return false;
    }
    
    public boolean canReinforce(){
        if(turn == true){
            if(territory.equals("home")){
                return true;
            }
        }
        return false;
    }
    
}
