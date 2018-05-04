/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Evenements;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.ServiceEvenements;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
public class EvenementItemBoutiqueController implements Initializable {

    @FXML
    private StackPane interface_container;
    @FXML
    private ScrollPane scrolpaneEvent;
    @FXML
    private FlowPane flowPEvent;
    ArrayList<Evenements> arraylist;
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             }
    
       public void loadboutique(String id_bout){
    
    ServiceEvenements se=new ServiceEvenements();
        ServiceBoutique sb=new ServiceBoutique();
     arraylist= (ArrayList) se.display_events(Integer.parseInt(id_bout));
     for(Evenements events :arraylist){
         try {   
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/evenementformeBoutique.fxml"));
                Pane newLoadedPane;
                newLoadedPane = loader.load();
                EvenementformeBoutiqueController controller = loader.<EvenementformeBoutiqueController>getController();
                controller.loadevents(events);
                flowPEvent.getChildren().add(newLoadedPane);
                
                } catch (IOException ex) {
                Logger.getLogger(EvenementItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
}
