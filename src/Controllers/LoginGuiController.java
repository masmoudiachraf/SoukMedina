/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.service.ServiceBoutique;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
public class LoginGuiController implements Initializable {

    @FXML
    private AnchorPane loginContainer;
    @FXML
    private ImageView LoginImage;
    @FXML
    private AnchorPane loginParent;
    @FXML
    private StackPane interface_container;
    @FXML
    private JFXButton login_btnconnect;
    @FXML
    private JFXTextField login_mailTf;
    @FXML
    private JFXPasswordField login_passTf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void inscrir_tap(ActionEvent event) {
            ServiceBoutique sb= new ServiceBoutique();
            String mail= login_mailTf.getText();
            String password= login_passTf.getText();
            
            
    }

    
}
