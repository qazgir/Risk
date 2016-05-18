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
    private static Player[] players;
    private static int currentTurn;
    private static String currentPhase;
    private static Continent[] continents;
    
    public Game(Player[] p, Continent[] c) {
        players = p;
        continents = c;
        currentTurn = 0;
    }
    
    public static void outText(String s) {
        //...
    }
    
    public static Player[] getPlayers() {
        return players;
    }
    public static int getNumPlayers() {
        return players.length;
    }
    public static int getCurrentTurn() {
        return currentTurn;
    }
    public static String getCurrentPhase() {
        return currentPhase;
    }
    
    public static void setCurrentPhase(String s) {
        currentPhase = s;
    }
    public static void setCurrentTurn(int t) {
        currentTurn = t;
    }
    public static Continent[] getContinents() {
        return continents;
    }
    
}
