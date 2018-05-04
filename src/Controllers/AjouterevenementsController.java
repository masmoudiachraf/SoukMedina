/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.Evenements;
import com.esprit.service.ServiceEvenements;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class AjouterevenementsController implements Initializable {

    @FXML
    private JFXTextField tfobjetEvent;
    @FXML
    private JFXTextArea TAdescEvent;
    @FXML
    private JFXTextField tfadresseEvent;
    @FXML
    private DatePicker DPdeb_event;
    @FXML
    private DatePicker DPfin_event;
    @FXML
    private JFXButton btnajoutEvent;
    int id_bout;
    @FXML
    private Label labid_bou;
    @FXML
    private StackPane interface_container;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void loadBoutique(String id_bout){
        labid_bou.setText(id_bout);
    }
    @FXML
    private void ajouterEvent(ActionEvent event) {
        ServiceEvenements se= new ServiceEvenements();
        Boutique b =new Boutique(Integer.parseInt(labid_bou.getText()));
        b.setId(Integer.parseInt(labid_bou.getText()));
       Evenements e= new Evenements(tfobjetEvent.getText(), TAdescEvent.getText(),tfadresseEvent.getText(), DPdeb_event.getValue().toString(), DPfin_event.getValue().toString(), b);
       se.insert_events(e);
       
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(new Text("évènement crée avec succès "));
        JFXButton ok=new JFXButton("OK");
       
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        content.setPrefSize(120, 200);
        content.setActions(ok);
        dialog.show();
    }
    
}
