
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.util.ArrayList;
import javafx.scene.text.Text;

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
    private static int numPlayers;
    //All subsequent variables new from fragmented turnPhases
    private static int currentReinforceUnits;
    private static Territory fromTerritory;
    private static MapController mapCon;
    
    public static void setNumPlayers(int n) {
        numPlayers = n;
    }
    
    public static int getNumPlayers() {
        return numPlayers;
    }
    
    public static void setConnectedController(MapController mc) {
        mapCon = mc;
    }
    
    public static void setPlayers(ArrayList<Player> p) {
        players = p;
    }
    
    public static void setReinforceUnits(int u) {
        currentReinforceUnits = u;
        mapCon.getUnitsNumBox().setText(Integer.toString(u));
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
    
    public static void outText(String s) {
        //...
    }
    
    public static void setPlayerText(String s) {
        mapCon.getPlayerTextBox().setText(s);
    }
    public static void setPhaseText(String s) {
        mapCon.getPhaseTextBox().setText(s);
    }
    
    public static ArrayList<Player> getPlayers() {
        return players;
    }
    public static Player getPlayingPlayer() {
        return playingPlayer;
    }
    public static void setPlayingPlayer(Player p) {
        playingPlayer = p;
        setPlayerText(p.getpName());
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
        setPhaseText(s);
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
    
    public static void victoryCheck(Player p){
        boolean victory = true;
        for(Continent c: Game.getContinents()){
            if(c.getController() != p){
                victory = false;
            }
        }
        if(victory){
            //playingPlayer has won the game
            mapCon.openWinScreen();
        }
    }
    
    public static void advancePhase() {
        if (currentPhase.equals("attack")) {
            victoryCheck(playingPlayer);
            TurnPhases.move(playingPlayer);
        } else if (currentPhase.equals("move")) {
            TurnPhases.takeTurn(players.get((players.indexOf(playingPlayer) + 1) % players.size()));
        }
    }
    
    public static MapController getConnController() {
        return mapCon;
    }
}
