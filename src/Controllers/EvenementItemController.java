/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.Evenements;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.ServiceEvenements;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class EvenementItemController implements Initializable {

    
    @FXML
    private StackPane interface_container;
    @FXML
    private ScrollPane scrolpaneEvent;
    @FXML
    private FlowPane flowPEvent;
    ArrayList<Evenements> arraylist;
   
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadevents();
     
    }
    public void loadevents(){
           // TODO
        ServiceEvenements se=new ServiceEvenements();
        ServiceBoutique sb=new ServiceBoutique();
     arraylist= (ArrayList) se.display_events();

     for(Evenements events :arraylist){
         try {   
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/evenementforme.fxml"));
                Pane newLoadedPane;
                newLoadedPane = loader.load();
                EvenementformeController controller = loader.<EvenementformeController>getController();
                controller.loadevents(events,sb.displaySingleboutique(events.getBoutique_fk().getId()));
                flowPEvent.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                Logger.getLogger(EvenementItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
    }
    
    
}
