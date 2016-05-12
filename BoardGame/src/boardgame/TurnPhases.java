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
    
    private static Game g;
    
    public static void setConnectedGame(Game game) {
        g = game;
    }
    
    public TurnPhases() {
    }
    
    public static void reinforce(Player p) {
        g.setCurrentPhase("reinforce");
        int numArmies = p.getArmiesPerTurn();
        //g.outText("Place armies on your territories. Left: " + numArmies);
        Territory t = new Territory(0, "", null);
        for (int i = 0; i < numArmies; i++) {
            t = new Territory(0, "", null);
            while (!(t.getOccupied().equals(p))) {
                //wait for player to click country and save it to 't'
            }
            t.changeUnits(t.getUnits()+ 1);
        }
    }
    
    public static void attack(Player p) {
        g.setCurrentPhase("attack");
        //g.outText("To attack, first select the territory you would like to attack from");
        Territory t = new Territory(0, "", null); 
        while (!(t.getOccupied().equals(p) && t.getUnits()>=2)) {
            //wait for player to click country and save it to 't'
        }
        
    }
    
    public static void move(Player p) {
        g.setCurrentPhase("move");
    }
    
    public static void takeTurn(Player p) {
        reinforce(p);
        attack(p);
        move(p);
        g.setCurrentTurn((g.getCurrentTurn()+1) % g.getNumPlayers());
    }
    
    public static int diceRoll() {
        return (int)Math.random()*6 + 1;
    }
}
