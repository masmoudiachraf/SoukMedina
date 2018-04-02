/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    private TextField login_mailTf;
    @FXML
    private TextField login_passTf;
    @FXML
    private Button login_btnconnect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
