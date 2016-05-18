/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.util.ArrayList;
import java.util.TreeSet;

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
        int numArmies = p.getUnitsPerTurn();
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
        while (true) {
            Territory from = new Territory(0, "", null); 
            while (!(from.getOccupied().equals(p) && from.getUnits()>=2)) {
                //wait for player to click country and save it to 't'
                //If ENDPHASE button is pressed, return
            }
            Territory to = new Territory(0, "", null);
            while (to.getOccupied().equals(p) || !(from.isAdjacent(to))) {
                //wait for player to click country and save it to 't'
            }
            while (to.getUnits() > 0 && from.getUnits() > 1) {
                ArrayList<Integer> attackingDice = rollNumDice(Math.min(from.getUnits() - 1, 3));
                ArrayList<Integer> defendingDice = rollNumDice(Math.min(to.getUnits() - 1, 2));
                for (int i = 0; i < Math.min(attackingDice.size(), defendingDice.size()); i++) {
                    if (attackingDice.get(i) > defendingDice.get(i)) {
                        to.changeUnits(to.getUnits()-1);
                    } else {
                        from.changeUnits(from.getUnits()-1);
                    }
                }
                //option for attacker to surrender; if so, break from loop
            }
            if (to.getUnits() <= 0) {
                to.getOccupied().surrenderTerritory(to, p);
                //move Player p's units to Territory 'to'
            }
        }
    }
    
    public static void move(Player p) {
        g.setCurrentPhase("move");
        Territory from = new Territory(0, "", null);
        while (!from.getOccupied().equals(p) || from.getUnits() < 2) {
            //wait for player to click country and save it to 't'
        }
        Territory to = new Territory(0, "", null);
        while (!from.isAdjacent(to) || !to.getOccupied().equals(p)) {
            //wait for player to click country and save it to 't'
        }
        int units = -1;
        while (units < 1 || units >= from.getUnits()) {
            //Ask player how many units they want to move and save it to int 'units'
        }
        from.changeUnits(from.getUnits() - units);
        to.changeUnits(to.getUnits() + units);
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
    public static ArrayList<Integer> rollNumDice(int num) {
        TreeSet<Integer> sorted = new TreeSet<Integer>();
        for (int i = 0; i < num; i++) {
            sorted.add(diceRoll());
        }
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (int i : sorted) {
            out.add(i);
        }
        return out;
    }
}
