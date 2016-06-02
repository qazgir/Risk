/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;

/**
 *
 * @author csstudent
 */
public class TurnPhases {
    
    public TurnPhases() {
    }
    
    public static void reinforce(Player p) {
        Game.setCurrentPhase("reinforce");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Turn Phase");
        alert.setHeaderText(null);
        alert.setContentText("It is now the reinforce phase.");
        alert.showAndWait();
        Game.setReinforceUnits(p.getUnitsPerTurn());
        Game.setFromTerritory(null);
        Game.getConnController().getUnitsBox().setVisible(true);
        Game.getConnController().getUnitsNumBox().setVisible(true);
    }

    public static void attack(Player p) {
        Game.getConnController().getUnitsBox().setVisible(false);
        Game.getConnController().getUnitsNumBox().setVisible(false);
        Game.setCurrentPhase("attack");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Turn Phase");
        alert.setHeaderText(null);
        alert.setContentText("It is now the attack phase.");
        alert.showAndWait();
        Game.setFromTerritory(null);
    }
    
    public static void move(Player p) {
        Game.setCurrentPhase("move");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Turn Phase");
        alert.setHeaderText(null);
        alert.setContentText("It is now the move phase.");
        alert.showAndWait();
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
        Alert confirm = new Alert(AlertType.CONFIRMATION);
        confirm.setTitle("Next Turn");
        confirm.setContentText("It is now " + p.getpName() + "'s turn!");
        ButtonType okButton = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        confirm.getButtonTypes().setAll(okButton);
        confirm.showAndWait();
        reinforce(p);
    }
    
    public static int diceRoll() {
        return (int)(Math.random()*6) + 1;
    }
    public static ArrayList<Integer> rollNumDice(int num) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            out.add(diceRoll());
        }
        Collections.sort(out);
        return out;
    }
}
