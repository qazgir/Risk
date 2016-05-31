
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import static boardgame.MainMenuController.fxmlLoader;
import static boardgame.MainMenuController.stage2;
import static boardgame.MainMenuController.twoPlayer;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Paint;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class MapController implements Initializable {
    
@FXML
private Button button1;
@FXML
private Button button2;
@FXML
private Button button3;
@FXML
private Button button4;
@FXML
private Button button5;
@FXML
private Button button6;
@FXML
private Button button7;
@FXML
private Button button8;
@FXML
private Button button9;
@FXML
private Button button10;
@FXML
private Button button11;
@FXML
private Button button12;
@FXML
private Button button13;
@FXML
private Button button14;
@FXML
private Button button15;
@FXML
private Button button16;

private boolean start = false;

    
@FXML
private Text phaseIndic;

@FXML 
private Text playerIndic; 

private boolean victory = false;

private Continent c1 = null;

private Continent c2 = null;

private Continent c3 = null;

private Continent c4 = null;


@FXML
private void handleButtonAction(ActionEvent event) {
    
        Game.setLastClickedTerritory(determineTerritory((Button) event.getSource())); 
    
}

@FXML
private void handleAdvancePhase() {
    Game.advancePhase();
}
private Territory t;

private String startContinent;

private Button startingTerritory;

private Territory startT;

@FXML
public Button advancePhase;

@FXML
//public static Text playerIndic;

private Player temp;


@FXML
private ImageView background;
    private Stage stage3;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void createMVPTerritories(){

        Territory t1 = new Territory(3, "JackyMayo", button1);
        Territory t2 = new Territory(3, "EE-Sama", button2);
        Territory t3 = new Territory(3, "RTZBabyrage", button3);
        Territory t4 = new Territory(3, "EnChuanTress", button4);
        Territory t5 = new Territory(3, "JeraxSpirit", button5);
        Territory t6 = new Territory(3, "ODPixel", button6);
        Territory t7 = new Territory(3, "PEDUR", button7);
        Territory t8 = new Territory(3, "IndianOfflaners", button8);
        Territory t9 = new Territory(3, "i buy bread", button9);
        Territory t10 = new Territory(3, "9000MMRPOINTS", button10);
        Territory t11 = new Territory(3, "HappyLilTree", button11);
        Territory t12 = new Territory(3, "VirtusThrow", button12);
        Territory t13 = new Territory(3, "DondoFace", button13);
        Territory t14 = new Territory(3, "DC>>MemeArrows", button14);
        Territory t15 = new Territory(3, "Keepo", button15);
        Territory t16 = new Territory(3, "SinGSonG", button16);
        
        Territory[] TArray1= {t1, t2, t3, t4};
        Territory[] TArray2= {t5, t6, t7, t8};
        Territory[] TArray3= {t9, t10, t11, t12};
        Territory[] TArray4= {t13, t14, t15, t16};
        Territory[] gameTerritories= {t1, t2, t3, t4,t5, t6, t7, t8,t9, t10, t11, t12,t13, t14, t15, t16};
       
        c1 = new Continent(4, "Continent1",TArray1);
        c2 = new Continent(4, "Continent2",TArray2);
        c3 = new Continent(4, "Continent3",TArray3);
        c4 = new Continent(4, "Continent4",TArray4);
        
        t1.addCornerAdjacent(t2, t6, t5);
        t2.addSideAdjacent(t1, t3, t7, t5, t6);
        t3.addSideAdjacent(t2, t4, t6, t7, t8);
        t4.addCornerAdjacent(t3, t7, t8);
        t5.addSideAdjacent(t1, t2, t6, t9, t10);
        t6.addMiddleAdjacent(t1, t2, t3, t5, t7, t9, t10, t11);
        t7.addMiddleAdjacent(t2, t3, t4, t6, t8, t10, t11, t12);
        t8.addSideAdjacent(t3, t4, t7, t11, t12);
        t9.addSideAdjacent(t5, t6, t10, t13, t14);
        t10.addMiddleAdjacent(t5, t6, t7, t9, t11, t13, t14, t15);
        t11.addMiddleAdjacent(t6, t7, t8, t10, t12, t14, t15, t16);
        t12.addSideAdjacent(t7, t8, t11, t15, t16);
        t13.addCornerAdjacent(t9, t10, t14);
        t14.addSideAdjacent(t13, t15, t9, t10, t11);
        t15.addSideAdjacent(t14, t16, t10, t11, t12);
        t16.addCornerAdjacent(t15, t11, t12);
        Continent[] gameContinents = {c1, c2, c3, c4};
        Game.setContinents(gameContinents);
        Game.setTerritories(gameTerritories);
        initialClaim();
        TurnPhases.takeTurn(Game.getPlayers().get(0));
}

    
    
    public void initialClaim(){
        if(MainMenuController.twoPlayer == true){
            ArrayList<Territory> p1T = new ArrayList<>();
            Player p1 = new Player("Player 1", p1T);
            ArrayList<Territory> p2T = new ArrayList<>();
            Player p2 = new Player("Player 2", p2T);
            ArrayList<Player> p = new ArrayList<Player>();
            p.add(p1);
            p.add(p2);
            Game.setPlayers(p);
            ArrayList<Territory> randomizedTerritories = new ArrayList<>();
            for(Continent c: Game.getContinents()){
                for(Territory t: c.getTerritory()){
                    randomizedTerritories.add(t);
                }
            }
            long randomizer = System.nanoTime();
            Collections.shuffle(randomizedTerritories, new Random(randomizer));
            for(int i = 0; i < randomizedTerritories.size(); i++){
                if(p1.getTerritories().size() < randomizedTerritories.size() / 2){
                    p1.addTerritory(randomizedTerritories.get(i));
                    randomizedTerritories.get(i).setController(p1);
                    randomizedTerritories.get(i).getLinkedButton().setStyle("-fx-background-color:ffb3b3");
                } else {
                    p2.addTerritory(randomizedTerritories.get(i));
                    randomizedTerritories.get(i).setController(p2);
                    randomizedTerritories.get(i).getLinkedButton().setStyle("-fx-background-color:b3b3ff");
                }
            }
        }
    }
    
    
    public void TerritoryAlert(Player p, Continent c){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Territory");
        alert.setHeaderText("Choose the territory");
        alert.setContentText("What territory would you like to start in?");
        ButtonType buttonTypeOne = new ButtonType(c.getTerritory()[0].getName());
        ButtonType buttonTypeTwo = new ButtonType(c.getTerritory()[1].getName());
        ButtonType buttonTypeThree = new ButtonType(c.getTerritory()[2].getName());
        ButtonType buttonTypeFour = new ButtonType(c.getTerritory()[3].getName());
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeFour, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            if("red".equals(startContinent)){
                startingTerritory = button1;
            }else if("pink".equals(startContinent)){
                startingTerritory = button5;
            }else if("blue".equals(startContinent)){
                startingTerritory = button9;
            }else if("green".equals(startContinent)){
                startingTerritory = button13;
            }
        }else if (result.get() == buttonTypeTwo){
            if("red".equals(startContinent)){
                startingTerritory = button2;
            }else if("pink".equals(startContinent)){
                startingTerritory = button6;
            }else if("blue".equals(startContinent)){
                startingTerritory = button10;
            }else if("green".equals(startContinent)){
                startingTerritory = button14;
            }
        }else if (result.get() == buttonTypeThree){
            if("red".equals(startContinent)){
                startingTerritory = button3;
            }else if("pink".equals(startContinent)){
                startingTerritory = button7;
            }else if("blue".equals(startContinent)){
                startingTerritory = button11;
            }else if("green".equals(startContinent)){
                startingTerritory = button15;
            }
        }else if (result.get() == buttonTypeFour){
            if("red".equals(startContinent)){
                startingTerritory = button4;
            }else if("pink".equals(startContinent)){
                startingTerritory = button8;
            }else if("blue".equals(startContinent)){
                startingTerritory = button12;
            }else if("green".equals(startContinent)){
                startingTerritory = button16;
            }
        }else if (result.get() == buttonTypeCancel){
            System.exit(0);
        }
    }
    
    public void TerritoryChecker(Territory t){
        for(Territory d: Game.getTerritories()){
            if(d.getButton().equals(startingTerritory)){
                startT = d;
            }
        }
    }
   
   public void openWinScreen() {
       this.stage3 = BoardGame.stage;
       fxmlLoader = new FXMLLoader(getClass().getResource("Win.fxml"));  
        Parent root = null;
        try {
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.show();
        } catch (IOException ex) {
            Logger.getLogger(TurnPhases.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
   public void victoryCheck() {
       
   }
   
   public Territory determineTerritory(Button b){
       for(Continent c: Game.getContinents()){
           for(Territory t: c.getTerritory()){
               if(t.getLinkedButton() == b){
                   return t;
               }
           }
       }
       return null;
   }
}
