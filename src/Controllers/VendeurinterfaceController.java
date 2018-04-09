/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class VendeurinterfaceController implements Initializable {

    @FXML
    private Label labnom;
    private Label labprenom;
    @FXML
    private Label labmail;
    @FXML
    private Label labtelephone;
    @FXML
    private Label labadresse;
    private Label labnaissance;
    @FXML
    private Hyperlink linklogout;
    @FXML
    private Hyperlink linksetting;
    @FXML
    private Label labpassword;
    @FXML
    private Label labid;
    @FXML
    private Label labactivite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void userinformation(String labid,String labnom, String labmail,String labpassword ,String labadresse,String labtelephone, String labactivite) {
        this.labid.setText(labid);
        this.labnom.setText(labnom);
        this.labmail.setText(labmail);
        this.labpassword.setText(labpassword);
        this.labtelephone.setText(labtelephone);
        this.labadresse.setText(labadresse);
        this.labactivite.setText(labactivite);
    }

    @FXML
    private void direction_update_profile(ActionEvent event) {
        
    FXMLLoader Loader= new FXMLLoader();
           Loader.setLocation(getClass().getResource("/GUI/vendeurSetting.fxml"));
            try {
                Loader.load();
                
            } catch (IOException e) {
                Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, e);
            }
            Parent p=Loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(p));
            stage.show();
           VendeurSettingController userzone= Loader.getController();
           userzone.userinformation(labid.getText(), labnom.getText(),labmail.getText(),labpassword.getText(),labadresse.getText(),labtelephone.getText(),labactivite.getText());
          
    }
    
    
}
