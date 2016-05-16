/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author csstudent
 */
public class BoardGame extends Application {
  
    public static Stage stage;
    
    public static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root= fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
