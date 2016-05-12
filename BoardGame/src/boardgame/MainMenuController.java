/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

@Override
public void initialize(URL url, ResourceBundle rb) {
    BoardGame.stage.setResizable(false);
    backgroundImage.setImage(riskImage);
}    
    
public void quit(){
    System.exit(0);
}
}

