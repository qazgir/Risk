
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
    private static Player playingPlayer;
    private static String currentPhase;
    private static Continent[] continents;
    private static Territory lastClickedTerritory;
    private static String name;
    private static Territory[] territories;
    //All subsequent variables new from fragmented turnPhases
    private static int currentReinforceUnits;
    private static Territory fromTerritory;
    
    
    public static void setPlayers(ArrayList<Player> p) {
        players = p;
    }
    
    public static void setReinforceUnits(int u) {
        currentReinforceUnits = u;
    }
    public static int getReinforceUnits() {
        return currentReinforceUnits;
    }
    public static Territory getFromTerritory() {
        return fromTerritory;
    }
    public static void setFromTerritory(Territory t) {
        fromTerritory = t;
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
    public static Player getPlayingPlayer() {
        return playingPlayer;
    }
    public static void setPlayingPlayer(Player p) {
        playingPlayer = p;
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
    
    public static void advancePhase() {
        if (currentPhase.equals("attack")) {
            TurnPhases.move(playingPlayer);
        } else if (currentPhase.equals("move")) {
            playingPlayer = players.get((players.indexOf(playingPlayer) + 1) % players.size());
        }
    }
}
