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
public class Game {
    private Player[] players;
    private int currentTurn;
    private String currentPhase;
    
    public Game(Player[] p) {
        players = p;
        currentTurn = 0;
    }
    
    public static void outText(String s) {
        //...
    }
    
    public Player[] getPlayers() {
        return players;
    }
    public int getNumPlayers() {
        return players.length;
    }
    public int getCurrentTurn() {
        return currentTurn;
    }
    public String getCurrentPhase() {
        return currentPhase;
    }
    
    public void setCurrentPhase(String s) {
        currentPhase = s;
    }
    public void setCurrentTurn(int t) {
        currentTurn = t;
    }
    
}
