/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.articles;
import com.esprit.service.articlesService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class AjouterarticleController implements Initializable {

    @FXML
    private JFXTextField tfnom;
    @FXML
    private JFXTextField tftaille;
    @FXML
    private JFXTextField tfcouleur;
    @FXML
    private JFXTextField tfprix;
    @FXML
    private JFXComboBox<?> tfcategorie;
    @FXML
    private JFXButton btnajouterarticle;
    @FXML
    private Label labid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void getid_boutique(String labid){
        this.labid.setText(labid);
    }
    @FXML
    private void ajouter_article(ActionEvent event) {
        articlesService as=new articlesService();
        Boutique b =new Boutique(Integer.parseInt(labid.getText()));
        b.setId(Integer.parseInt(labid.getText()));
        articles a=new articles(tfnom.getText(), tftaille.getText(), tfcouleur.getText(), Float.parseFloat(tfprix.getText()), "sacs", b);
        as.insert_article(a);
    }
    
}
