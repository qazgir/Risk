/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import static boardgame.MainMenuController.fxmlLoader;
import static boardgame.MainMenuController.stage2;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
@FXML
public Text phaseIndic;

@FXML
public Button advancePhase;

@FXML
public Text playerIndic;

@FXML
private ImageView background;
    private Stage stage3;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       int bah = 2;
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
        Continent c1 = new Continent(4, "Continent1",TArray1);
        Continent c2 = new Continent(4, "Continent2",TArray2);
        Continent c3 = new Continent(4, "Continent3",TArray3);
        Continent c4 = new Continent(4, "Continent4",TArray4);
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
        }
    
    public void victoryCheck(Player p){
        boolean victory = true;
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
            } catch (IOException ex) {
                Logger.getLogger(TurnPhases.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.show();
        }
    }
    
   public void victoryCheck(){
       Player p = new Player("Test", null);
       victoryCheck(p);
   }
   
}
