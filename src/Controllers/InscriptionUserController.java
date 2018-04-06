/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.utilisateur;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class InscriptionUserController implements Initializable {

    @FXML
    private AnchorPane loginParent;
    @FXML
    private ImageView LoginImage;
    @FXML
    private StackPane interface_container;
    @FXML
    private AnchorPane loginContainer;
    @FXML
    private JFXTextField tfnom;
    @FXML
    private JFXPasswordField tfpassword;
    @FXML
    private JFXTextField tfprenom;
    @FXML
    private JFXTextField tfmail;
    @FXML
    private JFXTextField tfadresse;
    @FXML
    private JFXTextField tftelephone;
    @FXML
    private JFXButton inscription_user;
    @FXML
    private DatePicker tfdaten;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inscription_user_click(ActionEvent event) {
        
        serviceUtilisateur su=new serviceUtilisateur();
        String ch;
        ch=su.displayutilisateur(tfmail.getText());
        if(tfnom.getText().equals("") || tfprenom.getText().equals("") || tfmail.getText().equals("")||tfpassword.getText().equals("")|| tfadresse.getText().equals("")|| tftelephone.getText().equals(""))
            { JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Mode"));
        content.setBody(new Text("Vérifier vos information!"));
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXButton btnalert = new JFXButton("OK");
        btnalert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.setActions(btnalert);
        dialog.show();
            }
        else 
        if(ch.equals(tfmail.getText()) )
            { JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Mode"));
        content.setBody(new Text("votre email est déja existe!\nVérifier si vous ètes déja inscrit"));
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXButton btnalert = new JFXButton("OK");
        btnalert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.setActions(btnalert);
        dialog.show();
            } 
      else{
        utilisateur u=new utilisateur(tfnom.getText(), tfprenom.getText(), tfmail.getText(),tfpassword.getText(), tfadresse.getText(), Integer.parseInt(tftelephone.getText()), tfdaten.getValue().toString());
        su.insert_user(u);
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Mode"));
        content.setBody(new Text("Merci pour votre inscription\t"+tfnom.getText()+" "+tfprenom.getText()+"\nRedirection au page d'authentification "));
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXButton btnalert = new JFXButton("OK");
        btnalert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                 start((Stage) btnalert.getScene().getWindow(), "/GUI/LoginGui.fxml");
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.setActions(btnalert);
        dialog.show();
        }
    }
    public void start(Stage window, String destination) throws Exception {
        Scene scene =  new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }
    
}
