/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
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

private int startingUnits;
    
public static FXMLLoader fxmlLoader;

@Override
public void initialize(URL url, ResourceBundle rb) {
    BoardGame.stage.setResizable(false);
    backgroundImage.setImage(riskImage);
}    
    
public void quit(){
    System.exit(0);
}

public void startGame() throws IOException{
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Number of Players");
    alert.setHeaderText("Choose the players");
    alert.setContentText("How many people are playing?");

    ButtonType buttonTypeTwo = new ButtonType("Two");
    ButtonType buttonTypeThree = new ButtonType("Three");
    ButtonType buttonTypeFour = new ButtonType("Four");
    ButtonType buttonTypeFive = new ButtonType("Five");
    ButtonType buttonTypeSix = new ButtonType("Six");
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
    ButtonType buttonTypeOne;

    alert.getButtonTypes().setAll(buttonTypeTwo, buttonTypeThree, buttonTypeFour, buttonTypeFive, buttonTypeSix, buttonTypeCancel);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == buttonTypeTwo){
        this.startingUnits = 40;
    } else if (result.get() == buttonTypeThree) {
       this.startingUnits = 35;
    } else if (result.get() == buttonTypeFour) {
        this.startingUnits = 30;
    } else if (result.get() == buttonTypeFour) {
        this.startingUnits = 25;
    }else if (result.get() == buttonTypeFour) {
        this.startingUnits = 20;
    }else if (result.get() == buttonTypeCancel){
        System.exit(0);
    }
    MainMenuController.stage2 = BoardGame.stage;
    fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));  
    Parent root = fxmlLoader.load();
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("map.css").toExternalForm());
    stage2.setScene(scene);
    MapController terrtoryCreater = fxmlLoader.getController();
    terrtoryCreater.createMVPTerritories();
    stage2.setResizable(true);
    stage2.show();
    
}

}

