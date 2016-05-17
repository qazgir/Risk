/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author csstudent
*/



public class MainMenuController implements Initializable {

@FXML
private Button quit;

@FXML
private Button play;

@FXML
private ImageView backgroundImage;

private final Image riskImage = new Image("http://screenrant.com/wp-content/uploads/Risk-board-game-movie-being-scripted-by-Shield-writer.jpg", 580, 450, true, true);     

public static Stage stage2;
    
public static FXMLLoader fxmlLoader;

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

@Override
public void initialize(URL url, ResourceBundle rb) {
    BoardGame.stage.setResizable(false);
    backgroundImage.setImage(riskImage);
}    
    
public void quit(){
    System.exit(0);
}

public void startGame() throws IOException{
    MainMenuController.stage2 = BoardGame.stage;
    fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));  
    Parent root = fxmlLoader.load();
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("map.css").toExternalForm());
    stage2.setScene(scene);
    stage2.show();
    Territory t1 = new Territory(0, "JackyMayo", button1);
        Territory t2 = new Territory(0, "EE-Sama", button2);
        Territory t3 = new Territory(0, "RTZBabyrage", button3);
        Territory t4 = new Territory(0, "EnChuanTress", button4);
        Territory t5 = new Territory(0, "JeraxSpirit", button5);
        Territory t6 = new Territory(0, "ODPixel", button6);
        Territory t7 = new Territory(0, "PEDUR", button7);
        Territory t8 = new Territory(0, "IndianOfflaners", button8);
        Territory t9 = new Territory(0, "brb i go buy bread", button9);
        Territory t10 = new Territory(0, "9000MMRPOINTS", button10);
        Territory t11 = new Territory(0, "HappyLilTree", button11);
        Territory t12 = new Territory(0, "VirtusThrow", button12);
        Territory t13 = new Territory(0, "DondoFace", button13);
        Territory t14 = new Territory(0, "DC>>MemeArrows", button14);
        Territory t15 = new Territory(0, "Keepo", button15);
        Territory t16 = new Territory(0, "SinGSonGPinGPonG", button16);
        Territory[] TArray1= {t1, t2, t3, t4};
        Territory[] TArray2= {t5, t6, t7, t8};
        Territory[] TArray3= {t9, t10, t11, t12};
        Territory[] TArray4= {t13, t14, t15, t16};
        Continent c1 = new Continent(4, "Continent1",TArray1);
        Continent c2 = new Continent(4, "Continent2",TArray2);
        Continent c3 = new Continent(4, "Continent3",TArray3);
        Continent c4 = new Continent(4, "Continent4",TArray4);
        t1.addAdjacent(t2);
}

}

