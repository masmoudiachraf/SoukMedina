/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

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
    }
    
}
