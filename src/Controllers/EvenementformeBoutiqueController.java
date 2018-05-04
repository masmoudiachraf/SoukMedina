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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class EvenementformeBoutiqueController implements Initializable {

    @FXML
    private AnchorPane paneeventforme;
    @FXML
    private TextArea TAinfoEvent;
    @FXML
    private ImageView btnsupp;
    @FXML
    private ImageView btnmodifier;
    @FXML
    private TextField tfobjet;
    @FXML
    private TextField tfadresse;
    @FXML
    private DatePicker DPdateDeb;
    @FXML
    private DatePicker DPDateFin;
    @FXML
    private Label labid_bout;
    private int id_event;
    @FXML
    private StackPane interface_container;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void loadevents(Evenements events){
     tfobjet.setText(events.getObject_event());
     TAinfoEvent.setText(events.getDescription_event());
     tfadresse.setText(events.getAdresse_event());
     DPdateDeb.setPromptText(events.getDateDeb_event());
     DPDateFin.setPromptText(events.getDateFin_event());
     id_event=events.getId_event();
    }   

    @FXML
    private void supprimerEvents(MouseEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(new Text("Voullez vous supprimer cet évènement?"));
        JFXButton oui=new JFXButton("Oui");
        JFXButton non=new JFXButton("Non");
        oui.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ServiceEvenements se=new ServiceEvenements();
                      se.delete_events(id_event);
                          paneeventforme.getChildren().clear();
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        non.setOnAction(new EventHandler<ActionEvent>() {
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
        dialog.show();
        content.setActions(oui,non);
        
        
    }

    @FXML
    private void modifierEvents(MouseEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(new Text("Voullez vous modifier cet évènement?"));
        JFXButton oui=new JFXButton("Oui");
        JFXButton non=new JFXButton("Non");
        oui.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ServiceEvenements se=new ServiceEvenements();
                      Evenements e= new Evenements(tfobjet.getText(), TAinfoEvent.getText(), tfadresse.getText(), DPdateDeb.getValue().toString(), DPDateFin.getValue().toString() );
                      se.update_events(e, id_event);
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        non.setOnAction(new EventHandler<ActionEvent>() {
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
        content.setActions(oui,non);
        dialog.show();
        
        
       
    }
}
