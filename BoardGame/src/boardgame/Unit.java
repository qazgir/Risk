/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csstudent
 */
public class Unit {
    private int units;
    private int role;
    private boolean move;
    private String name; 
    private String faction;
    private boolean death;
    
    public void role(){
        role = (int)(Math.random()*100);
        
    }
    
    public void Death(){
        if(death == true){
           
        }
        
    }
   
    public void move(){
        if(units <= 3){
            move = true;
        }
        
        
    }
    
    public void attack(){
        
        
        
    }
    
    
    
}
