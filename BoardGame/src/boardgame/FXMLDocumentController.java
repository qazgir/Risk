/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author csstudent
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleClickTerritory(MouseEvent event) {
        if (Game.getCurrentPhase().equals("reinforce")) {
            Game.setClickedTerritory(event.getButton());
        } else if (Game.getCurrentPhase().equals("attack")) {
            
        } else if (Game.getCurrentPhase().equals("move")) {
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
