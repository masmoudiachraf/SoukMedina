/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.service.ServiceBoutique;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private JFXButton boutique_inscription;
    @FXML
    private JFXTextField nom_bout;
    @FXML
    private JFXPasswordField password_bout;
    @FXML
    private JFXTextField mail_bout;
    @FXML
    private JFXTextField telephone_bout;
    @FXML
    private JFXComboBox<?> activite_bout;
    @FXML
    private JFXTextField adresse_bout;

    List<String> itemList = new ArrayList<String>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        itemList.add("Act1");
        itemList.add("Act2");
        itemList.add("Act3");
        itemList.add("Act4");
        ObservableList obs = FXCollections.observableList(itemList);
        activite_bout.setItems(obs);
    }    

    @FXML
    private void inscription_boutique_click(ActionEvent event) {
        ServiceBoutique sb= new ServiceBoutique();
          String nom=nom_bout.getText();
          String mail= mail_bout.getText();
          String password= password_bout.getText();
          String adresse= adresse_bout.getText();
          String telephone= telephone_bout.getText();
          String activite = activite_bout.getValue().toString();
          Boutique b= new Boutique(nom, adresse, mail, password, Integer.parseInt(telephone), activite);
          sb.insert_boutique(b);
 
      
    }
    
}
