/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Mail;
import com.esprit.service.serviceMail;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class MailItemController implements Initializable {

    @FXML
    private TextField objet;
    @FXML
    private TextArea message;
    @FXML
    private StackPane interface_container;
    String from;
    String to;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void mailInformation(String from , String to){
     this.from=from;
     this.to=to;
    }
    
    @FXML
    private void envoyer_mail(ActionEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXPasswordField password = new JFXPasswordField();
        password.setPromptText("Mot de passe boite email");
        password.setPrefWidth(180);
        JFXButton ok = new JFXButton("ok");
        JFXButton Annuler = new JFXButton("annuler");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                serviceMail  sm=new serviceMail();
                Mail m=new Mail(from, password.getText(), to, objet.getText(), message.getText(), "smtp.gmail.com");
                sm.sendMail(m);
                dialog.close();
                    
                } catch (Exception ex) {
                   Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                });
        Annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.setPrefSize(223, 80);
        content.setBody(password);
        content.setActions(ok,Annuler);
        dialog.show();
        
        
    }
    
}
