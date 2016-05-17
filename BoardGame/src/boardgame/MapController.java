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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author csstudent
 */
public class MapController implements Initializable {
    
private final Image backgroundImage = new Image("4x4.gif", 580, 450, true, true);     
    
@FXML
public Text phaseIndic;

@FXML
public Button advancePhase;

@FXML
public Text playerIndic;

@FXML
private ImageView background;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Territory t1 = new Territory(0, "JackyMayo");
        Territory t2 = new Territory(0, "EE-Sama");
        Territory t3 = new Territory(0, "RTZBabyrage");
        Territory t4 = new Territory(0, "EnChuanTress");
        Territory t5 = new Territory(0, "JeraxSpirit");
        Territory t6 = new Territory(0, "ODPixel");
        Territory t7 = new Territory(0, "PEDUR");
        Territory t8 = new Territory(0, "IndianOfflaners");
        Territory t9 = new Territory(0, "brb i go buy bread");
        Territory t10 = new Territory(0, "9000MMRPOINTS");
        Territory t11 = new Territory(0, "HappyLilTree");
        Territory t12 = new Territory(0, "VirtusThrow");
        Territory t13 = new Territory(0, "DondoFace");
        Territory t14 = new Territory(0, "DC>>MemeArrows");
        Territory t15 = new Territory(0, "Keepo");
        Territory t16 = new Territory(0, "SinGSonGPinGPonG");
        Territory[] TArray1= {t1, t2, t3, t4};
        Territory[] TArray2= {t5, t6, t7, t8};
        Territory[] TArray3= {t9, t10, t11, t12};
        Territory[] TArray4= {t13, t14, t15, t16};
        Continent c1 = new Continent(4, "Continent1",TArray1);
        Continent c2 = new Continent(4, "Continent2",TArray2);
        Continent c3 = new Continent(4, "Continent3",TArray3);
        Continent c4 = new Continent(4, "Continent4",TArray4);
        background.setImage(backgroundImage);
    }    
    
}
