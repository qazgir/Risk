/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

/**
 *
 * @author csstudent
 */
public class TurnPhases {
    
    public TurnPhases() {
    }
    
    /*public static void reinforce(Player p) {
        Game.setCurrentPhase("reinforce");
        int numArmies = p.getUnitsPerTurn();
        //g.outText("Place armies on your territories. Left: " + numArmies);
        Territory t = new Territory(0, "", null);
        Game.resetLastClickedTerritory();
        for (int i = 0; i < numArmies; i++) {
            t = new Territory(0, "", null);
            Game.resetLastClickedTerritory();
            while (!(t.getController().equals(p))) {
                t = Game.getLastClickedTerritory();
            }
            t.changeUnits(t.getUnits()+ 1);
        }
    }*/
    
    public static void reinforce(Player p){
        Game.setCurrentPhase("Reinforce");
        int remainingTroops = p.getUnitsPerTurn(p);
        List<Integer> troops = new ArrayList<>();
        for(int i = 0; i < remainingTroops; i++){
            troops.add(i);
        }
        for(Territory t: p.getTerritories()){
            ChoiceDialog<Integer> reinforce = new ChoiceDialog<>(troops.get(0), troops);
            reinforce.setTitle("Reinforce your territories.");
            reinforce.setHeaderText("Number of troops remining:" + remainingTroops);
            reinforce.setContentText("Choose a number of troops to reinforce " + t.getName());
            Optional<Integer> result = reinforce.showAndWait();
            if(result.isPresent()){
                t.addUnits(result.get());
            }
        }
        
    }
 
    /*public static void attack(Player p) {
        Game.setCurrentPhase("attack");
        //g.outText("To attack, first select the territory you would like to attack from");
        while (true) {
            Territory from = new Territory(0, "", null);
            Game.resetLastClickedTerritory();
            Game.resetAdvancePhase();
            while (!(from.getController().equals(p) && from.getUnits()>=2)) {
                from = Game.getLastClickedTerritory();
                if (Game.getAdvancePhase()) {
                    return;
                }
            }
            Territory to = new Territory(0, "", null);
            Game.resetLastClickedTerritory();
            while (to.getController().equals(p) || !(from.isAdjacent(to))) {
                to = Game.getLastClickedTerritory();
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
                Game.resetLastClickedTerritory();
                while (!Game.getLastClickedTerritory().equals(to)) {
                    if (Game.getAdvancePhase()) {
                        break;
                    }
                }
            }
            if (to.getUnits() <= 0) {
                to.getController().surrenderTerritory(to, p);
                moveSingle(from, to);
            }
        }
    
    }*/
    
   /* public static void attack(Player p){
        Game.setCurrentPhase("attack");
        Alert confirmAttack = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAttack.setTitle("Time to attack");
            confirmAttack.setContentText("Would you like to attack?");
            ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            confirmAttack.getButtonTypes().setAll(yesButton, noButton);
            Optional<ButtonType> attackResult = confirmAttack.showAndWait();
            if(attackResult.get() == noButton){
                
            } else {
                List<String> myTerritories = new ArrayList<>();
                for(int i = 0; i <= p.getTerritories().size(); i++){
                    myTerritories.add(p.getTerritories().get(i).getName());
                }
                List<String> enemeyTerritories = new ArrayList<>();
                for(Continent c: Game.getContinents()){
                    for(Territory t: c.getTerritory()){
                        if(!(t.getController().equals(p))){
                            enemeyTerritories.add(t.getName());
                        }
                    }
                }
                for(int i = 0; i <= enemeyTerritories.size(); i++){
                    Alert attackTarget = new Alert(Alert.AlertType.CONFIRMATION);
                    attackTarget.setTitle("Time to attack");
                    attackTarget.setContentText("Would you like to attack " + enemeyTerritories.get(i));
                    ButtonType yesTarget = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                    ButtonType noTarget = new ButtonType("No", ButtonBar.ButtonData.NO);
                    attackTarget.getButtonTypes().setAll(yesTarget, noTarget);
                    Optional<ButtonType> targetResult = attackTarget.showAndWait();
                    if(targetResult.get() == noTarget){
                    
                    } else {
                        List<Territory> enemeyTerritoriesActual = new ArrayList<>();
                        for(Continent c: Game.getContinents()){
                            for(Territory t: c.getTerritory()){
                                if(!(t.getController().equals(p))){
                                    enemeyTerritoriesActual.add(t);
                                }
                            }
                        }
                        for(Territory t: p.getTerritories()){
                            if(t.isAdjacent(enemeyTerritoriesActual.get(i)) == true){
                                Territory attacked = enemeyTerritoriesActual.get(i);
                                Territory attacker = t;
                                while(attacked.getUnits() > 0 && attacker.getUnits() >= 1){
                                    ChoiceDialog<Integer> rollDice = new ChoiceDialog<>(troops.get(0), troops);
                                    rollDice.setTitle("Roll the dice.");
                                    rollDice.setHeaderText("Roll " + rollDice);
                                    rollDice.setContentText("Choose a number of troops to reinforce " + t.getName());
                                    Optional<Integer> numDice = rollDice.showAndWait();
                                    if(result.isPresent()){
                                        t.addUnits(result.get());
                                    }
                                }
                            }
                        }
                    }
                    
                }
            }
    }*/
    
    public static void move(Player p) {
        Game.setCurrentPhase("move");
        Territory from = new Territory(0, "", null);
        Game.resetLastClickedTerritory();
        while (!from.getController().equals(p) || from.getUnits() < 2) {
            from = Game.getLastClickedTerritory();
        }
        Territory to = new Territory(0, "", null);
        Game.resetLastClickedTerritory();
        while (!from.isAdjacent(to) || !to.getController().equals(p)) {
            to = Game.getLastClickedTerritory();
        }
        moveSingle(from, to);
    }
    
    private static void moveSingle(Territory from, Territory to) {
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
        reinforce(p);
        //attack(p);
       // move(p);
        //Game.setCurrentTurn((Game.getCurrentTurn()+1) % Game.getNumPlayers());
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
