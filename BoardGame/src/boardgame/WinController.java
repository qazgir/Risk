/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class WinController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView winscreen = new ImageView();
   
    private Image image = new Image("http://65.media.tumblr.com/tumblr_l5jb2svg5Y1qc4y5qo1_500.jpg", 600, 480, false,  true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        winscreen.setImage(image);
    }    
    
}
