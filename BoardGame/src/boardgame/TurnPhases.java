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
public class TurnPhases {
    
    public TurnPhases() {
    }
    
    public static void reinforce(Player p) {
        Game.setCurrentPhase("reinforce");
        int numArmies = p.getArmiesPerTurn();
        Game.outText("Place armies on your territories. Left: " + numArmies);
        
    }
    
    public static void attack(Player p) {
        Game.setCurrentPhase("attack");
        Game.outText("To attack, first select the territory you would like to attack from");
        
    }
    
    public static void move(Player p) {
        Game.setCurrentPhase("move");
    }
    
    public static void takeTurn(Player p) {
        reinforce(p);
        attack(p);
        move(p);
    }
}
