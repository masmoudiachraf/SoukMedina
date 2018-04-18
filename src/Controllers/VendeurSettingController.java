/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.service.ServiceBoutique;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane panex;
    @FXML
    private JFXButton btnannuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    private void update_user_profil(ActionEvent event) throws IOException {
        ServiceBoutique sb= new ServiceBoutique();
        Boutique b=new Boutique(tfnom.getText(), tfmail.getText(), tfpassword.getText(),tfadresse.getText(),Integer.parseInt(tftelephone.getText()), tfactivite.getText());
        sb.update_boutique(b, Integer.parseInt(labid.getText()));

    }

    
 public void start(Stage window, String destination) throws Exception {
        Scene scene =  new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void annuler(ActionEvent event) {
           panex.setVisible(false);
         panex.setStyle("-fx-background-color:rgba(255, 255, 255, 0);");
    }
}
