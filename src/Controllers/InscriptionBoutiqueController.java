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
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    @FXML
    private JFXButton registerBoutiqueBackBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        itemList.add("Sport");
        itemList.add("Habillé");
        itemList.add("Casual");
        itemList.add("Chaussure");
        ObservableList obs = FXCollections.observableList(itemList);
        activite_bout.setItems(obs);
        try {
            registerBoutiqueBackBtn.setGraphic(new ImageView((getClass().getResource("/Assets/backBtn.png")).toURI().toString()));
        } catch (URISyntaxException ex) {
            Logger.getLogger(InscriptionBoutiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void inscription_boutique_click(ActionEvent event) {
        ServiceBoutique sb = new ServiceBoutique();
        String nom = nom_bout.getText();
        String mail = mail_bout.getText();
        String password = password_bout.getText();
        String adresse = adresse_bout.getText();
        String telephone = telephone_bout.getText();
        String activite = activite_bout.getValue().toString();
        System.out.println("nom" + nom + "mail" + mail + "password" + password + "adress" + adresse + "act" + activite);
        Boutique b = new Boutique(nom, mail, password, adresse, Integer.parseInt(telephone), activite);
        sb.insert_boutique(b);
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Mode"));
        content.setBody(new Text("Merci pour votre inscription\t" + nom + "\nRedirection au page d'authentification "));
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXButton btnalert = new JFXButton("OK");
        btnalert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    start((Stage) btnalert.getScene().getWindow(), "/GUI/LoginGui.fxml");
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.setActions(btnalert);
        dialog.show();
    }

    public void start(Stage window, String destination) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void backBtnClick(ActionEvent event) {
        try {
            start((Stage) registerBoutiqueBackBtn.getScene().getWindow(), "/GUI/LoginGui.fxml");
        } catch (Exception ex) {
            Logger.getLogger(InscriptionBoutiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
