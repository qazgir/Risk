
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import static boardgame.MainMenuController.fxmlLoader;
import static boardgame.MainMenuController.stage2;
import static boardgame.MainMenuController.twoPlayer;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
public Button button1;
@FXML
public Button button2;
@FXML
public Button button3;
@FXML
public Button button4;
@FXML
public Button button5;
@FXML
public Button button6;
@FXML
public Button button7;
@FXML
public Button button8;
@FXML
public Button button9;
@FXML
public Button button10;
@FXML
public Button button11;
@FXML
public Button button12;
@FXML
public Button button13;
@FXML
public Button button14;
@FXML
public Button button15;
@FXML
public Button button16;

private boolean start = false;

    
@FXML
public Text phaseIndic;

@FXML 
public Text playerIndic; 

public boolean victory = false;

public Continent c1 = null;

public Continent c2 = null;

public Continent c3 = null;

public Continent c4 = null;


@FXML
private void handleButtonAction(ActionEvent event) { 
    Game.setLastClickedTerritory(determineTerritory((Button) event.getSource()));    
}

@FXML
private void handleAdvancePhase() {
    Game.activateAdvancePhase();
}
private Territory t;

private String startContinent;

private Button startingTerritory;

private Territory startT;

 private boolean t1 = false;
 private boolean t2 = false;
 private boolean t3 = false;
 private boolean t4 = false;
 private boolean t5 = false;
 private boolean t6 = false;
 private boolean t7 = false;
 private boolean t8 = false;       
 private boolean t9 = false;
 private boolean t10 = false;
 private boolean t11 = false;
 private boolean t12 = false;
 private boolean t13 = false;
 private boolean t14 = false;
 private boolean t15 = false;
 private boolean t16 = false;
 
 private boolean buttonOnePicked = false;
 private boolean buttonTwoPicked = false;
 private boolean buttonThreePicked = false;
 private boolean buttonFourPicked = false;
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
        Territory t1 = new Territory(0, "JackyMayo", button1);
        Territory t2 = new Territory(0, "EE-Sama", button2);
        Territory t3 = new Territory(0, "RTZBabyrage", button3);
        Territory t4 = new Territory(0, "EnChuanTress", button4);
        Territory t5 = new Territory(0, "JeraxSpirit", button5);
        Territory t6 = new Territory(0, "ODPixel", button6);
        Territory t7 = new Territory(0, "PEDUR", button7);
        Territory t8 = new Territory(0, "IndianOfflaners", button8);
        Territory t9 = new Territory(0, "i buy bread", button9);
        Territory t10 = new Territory(0, "9000MMRPOINTS", button10);
        Territory t11 = new Territory(0, "HappyLilTree", button11);
        Territory t12 = new Territory(0, "VirtusThrow", button12);
        Territory t13 = new Territory(0, "DondoFace", button13);
        Territory t14 = new Territory(0, "DC>>MemeArrows", button14);
        Territory t15 = new Territory(0, "Keepo", button15);
        Territory t16 = new Territory(0, "SinGSonG", button16);
        
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
        while(victory == false){
            ArrayList<Player> t = Game.getPlayers();
            for(int i = 0; i < t.size(); i++){
                temp = t.get(i);
                Alert confirm = new Alert(AlertType.CONFIRMATION);
                            confirm.setTitle("Next Turn");
                            confirm.setContentText("It is now " + temp.getpName() + "'s turn!");
                            ButtonType okButton = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                            confirm.getButtonTypes().setAll(okButton);
                            confirm.showAndWait();
                TurnPhases.takeTurn(temp);
                //victoryCheck(temp);
            }
        }
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
            List<Territory> randomizedTerritories = new ArrayList<>();
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
                } else {
                    p2.addTerritory(randomizedTerritories.get(i));
                }
            }
        }
    }
    
    public void victoryCheck(Player p){
        //victory = true;
        for(Continent c: Game.getContinents()){
            if(c.getController() != p){
                victory = false;
            }
        }
        if(victory = true){
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
    }
    
   public void victoryCheck(){
       Player p = new Player("Test", null);
       victoryCheck(p);
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
