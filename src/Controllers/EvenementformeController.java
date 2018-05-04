/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.Evenements;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class EvenementformeController implements Initializable {

    @FXML
    private AnchorPane paneeventforme;
    @FXML
    private Label labnom_bout;
    @FXML
    private TextArea TAinfoEvent;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    public void loadevents(Evenements events,Boutique b){
        labnom_bout.setText(b.getNom_bout());
        String info="Object : "+events.getObject_event()+"\nDescription : "+events.getDescription_event()+"\nà : "+events.getAdresse_event()+"\nDate Début: "+events.getDateDeb_event()+" jusqua : "+events.getDateFin_event();
        TAinfoEvent.setText(info);
    }
    
}
