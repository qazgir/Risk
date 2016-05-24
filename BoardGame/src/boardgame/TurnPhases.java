/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.util.ArrayList;
import java.util.Optional;
import java.util.TreeSet;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

/**
 *
 * @author csstudent
 */
public class TurnPhases {
    
    public TurnPhases() {
    }
    
    public static void reinforce(Player p) {
        Game.setCurrentPhase("reinforce");
        Game.setReinforceUnits(p.getUnitsPerTurn());
    }
    
    public static void attack(Player p) {
        Game.setCurrentPhase("attack");
        Game.setFromTerritory(null);
    }
    
    public static void move(Player p) {
        Game.setCurrentPhase("move");
        Game.setFromTerritory(null);
    }
    
    public static void moveSingle(Territory from, Territory to) {
        ArrayList<Integer> choices = new ArrayList<Integer>();
        for (int i = 0; i < from.getUnits(); i++) {
            choices.add(i);
        }
        ChoiceDialog<Integer> dialog = new ChoiceDialog<Integer>(1, choices);
        dialog.setTitle("Move Units");
        dialog.setHeaderText("Choose number of units to move from " + from.getName() + " to " + to.getName());
        dialog.setContentText("Choose a number:");
        Optional<Integer> result = dialog.showAndWait();
        int units = 0;
        if (result.isPresent()) {
            units = result.get();
        }
        from.changeUnits(from.getUnits() - units);
        to.changeUnits(to.getUnits() + units);
    }
    
    public static void takeTurn(Player p) {
        Game.setPlayingPlayer(p);
        reinforce(p);
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
