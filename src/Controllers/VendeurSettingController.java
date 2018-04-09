/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.utilisateur;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class VendeurSettingController implements Initializable {

    @FXML
    private JFXTextField tfnom;
    private JFXTextField tfprenom;
    @FXML
    private JFXTextField tfmail;
    @FXML
    private JFXTextField tfpassword;
    @FXML
    private JFXTextField tfadresse;
    @FXML
    private JFXTextField tftelephone;
    private JFXTextField tfnaissance;
    @FXML
    private JFXButton modifier;
    @FXML
    private Label labid;
    @FXML
    private JFXTextField tfactivite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void userinformation(String labid, String tfnom, String tfmail,String tfpassword ,String tfadresse,String tftelephone, String tfactivite) {
       this.labid.setText(labid);
        this.tfnom.setText(tfnom);
        this.tfmail.setText(tfmail);
        this.tfpassword.setText(tfpassword);
        this.tftelephone.setText(tftelephone);
        this.tfadresse.setText(tfadresse);
        this.tfactivite.setText(tfactivite);
    }
    @FXML
    private void update_user_profil(ActionEvent event) {
        ServiceBoutique sb= new ServiceBoutique();
        Boutique b=new Boutique(tfnom.getText(),tfadresse.getText(), tfmail.getText(), tfpassword.getText(),Integer.parseInt(tftelephone.getText()), tfactivite.getText());
        sb.update_boutique(b, Integer.parseInt(labid.getText()));
        FXMLLoader Loader= new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/LoginGui.fxml"));
            try {
                Loader.load();
                
            } catch (IOException e) {
                Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, e);
            }
            Parent p=Loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(p));
            stage.show();
    }

    

}
