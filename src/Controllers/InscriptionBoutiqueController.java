/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class InscriptionBoutiqueController implements Initializable {

    @FXML
    private AnchorPane loginParent;
    @FXML
    private ImageView LoginImage;
    @FXML
    private StackPane interface_container;
    @FXML
    private AnchorPane loginContainer;
    @FXML
    private JFXTextField boutique_tfnom;
    @FXML
    private JFXPasswordField boutique_tfpassword;
    @FXML
    private JFXTextField boutique_tfmail;
    @FXML
    private JFXTextField boutique_tfadresse;
    @FXML
    private JFXTextField boutique_tftelephone;
    @FXML
    private JFXButton boutique_inscription;
    @FXML
    private JFXComboBox<?> boutique_activite_combo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inscription_boutique_click(ActionEvent event) {
    }
    
}
