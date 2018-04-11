/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soukmedina;

import com.esprit.entite.Boutique;
import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.entite.categorie;
import com.esprit.entite.utilisateur;
import com.esprit.service.PanierService;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.articlesService;
import com.esprit.service.serviceUtilisateur;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author masmo
 */
public class SoukMedina extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/admin.fxml")));
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(SoukMedina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
