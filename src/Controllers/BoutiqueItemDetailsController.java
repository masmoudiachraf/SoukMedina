/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.utilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class BoutiqueItemDetailsController implements Initializable {

    @FXML
    private ImageView ivimage_bout;
    @FXML
    private Label labnom_bout;
    @FXML
    private Label labtel_bout;
    @FXML
    private Label labadresse_bout;
    @FXML
    private Label labmail_bout;
    
    @FXML
    private JFXButton btncontact;
    @FXML
    private StackPane interface_container;
    @FXML
    private Label labmail_user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void loadBoutique(Boutique boutique){
       labnom_bout.setText(boutique.getNom_bout());
        labmail_bout.setText(boutique.getMail_bout());
        labadresse_bout.setText(boutique.getAdresse_bout());
        labtel_bout.setText(Integer.toString(boutique.getTelephone_bout()));
        
    }
     public void loaduser(String mail_user){
         labmail_user.setText(mail_user);
     }

    @FXML
    private void send_mail_boutique(ActionEvent event) throws IOException {
         FXMLLoader Loader = new FXMLLoader();
         Loader.setLocation(getClass().getResource("/GUI/MailItem.fxml"));
        Pane pane = Loader.load();
        MailItemController controller = Loader.<MailItemController>getController();
        controller.mailInformation(labmail_user.getText(), labmail_bout.getText());
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.RIGHT);
        content.setBody(pane);
        content.setPrefSize(223, 210);
        dialog.show();
    }
    
}
