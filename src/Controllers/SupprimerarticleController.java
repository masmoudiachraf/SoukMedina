/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class SupprimerarticleController implements Initializable {

    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXButton btnsupprimer;
@FXML
    private Label labid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void getid_boutique(String labid){
        this.labid.setText(labid);
    }
    @FXML
    private void supprimer_article(ActionEvent event) {
        
    }
    
}
