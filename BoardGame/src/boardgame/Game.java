
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.util.ArrayList;

/**
 *
 * @author csstudent
 */
public class Game {
    private static ArrayList<Player> players;
    private static int currentTurn = 0;
    private static String currentPhase;
    private static Continent[] continents;
    private static Player turnTaker;
    private static Territory lastClickedTerritory;
    private static String name;
    private static Territory[] territories;
    private static boolean advancePhase = false;
    
    public static void setPlayers(ArrayList<Player> p) {
        players = p;
    }
    
    
    public static void setContinents(Continent[] c) {
        continents = c;
    }
    
    /*public static void setTurnTaker(Player p){
        if(players != null){    
            turnTaker = p;
            name = p.getpName();
            MapController.playerIndic.setText("player");
        }else{
            
        }
    }*/
    
    public static void outText(String s) {
        //...
    }
    
    public static ArrayList<Player> getPlayers() {
        return players;
    }
    public static int getNumPlayers() {
        return players.size();
    }
    public static int getCurrentTurn() {
        return currentTurn;
    }
    public static String getCurrentPhase() {
        return currentPhase;
    }
    public static Territory[] getTerritories(){
        return territories;
    }
    
    public static void setTerritories(Territory[] t){
        territories = t; 
    }
    public static void setCurrentPhase(String s) {
        currentPhase = s;
        //MapController.phaseIndic.setText(s);
    }
    public static void setCurrentTurn(int t) {
        currentTurn = t;
    }
    public static Continent[] getContinents() {
        return continents;
    }
    
    public static void resetLastClickedTerritory() {
        lastClickedTerritory = new Territory(0, "", null);
    }
    public static Territory getLastClickedTerritory() {
        return lastClickedTerritory;
    }
    public static void setLastClickedTerritory(Territory t) {
        lastClickedTerritory = t;
    }
    
    public static void resetAdvancePhase() {
        advancePhase = false;
    }
    public static boolean getAdvancePhase() {
        return advancePhase;
    }
    public static void activateAdvancePhase() {
        advancePhase = true;
    }
}
