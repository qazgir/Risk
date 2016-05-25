/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import static boardgame.MainMenuController.fxmlLoader;
import static boardgame.MainMenuController.helpStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class HelpWindowController implements Initializable {
    static Stage stage;
    
    @FXML TextArea helpText;
    @FXML Button back;
    /**
     * Initializes the controller class.
     */
@FXML
public void handleBack(MouseEvent m1) throws IOException{
    HelpWindowController.stage = BoardGame.stage;
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
    Parent root = fxmlLoader.load();
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("mainmenu.css").toExternalForm());
    helpStage.setScene(scene);
    MainMenuController bigBoy = fxmlLoader.getController();
    helpStage.setResizable(false);
    helpStage.show();
}
    @Override
public void initialize(URL url, ResourceBundle rb) {
}    
    
}
