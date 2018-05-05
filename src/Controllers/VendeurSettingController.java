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
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
    private AnchorPane panex;
    @FXML
    private JFXComboBox<?> CBactivite;
    @FXML
    private StackPane interface_container;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> itemList = new ArrayList<String>();

        itemList.add("Act1");
        itemList.add("Act2");
        itemList.add("Act3");
        itemList.add("Act4");
        ObservableList obs = FXCollections.observableList(itemList);
        CBactivite.setItems(obs);
    }    

    public void loadboutique(String labid, String tfnom, String tfmail,String tfpassword ,String tfadresse,String tftelephone) {
       this.labid.setText(labid);
        this.tfnom.setText(tfnom);
        this.tfmail.setText(tfmail);
        this.tfpassword.setText(tfpassword);
        this.tftelephone.setText(tftelephone);
        this.tfadresse.setText(tfadresse);
    }
    @FXML
    private void update_user_profil(ActionEvent event) throws IOException {
        
        ServiceBoutique sb= new ServiceBoutique();
        Boutique b=new Boutique(tfnom.getText(), tfmail.getText(), tfpassword.getText(),tfadresse.getText(),Integer.parseInt(tftelephone.getText()), CBactivite.getValue().toString());
        sb.update_boutique(b, Integer.parseInt(labid.getText()));
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(new Text("modifier avec succès "));
        JFXButton ok=new JFXButton("OK");
       
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        content.setPrefSize(120, 200);
        content.setActions(ok);
        dialog.show();
    }
  
    

}
