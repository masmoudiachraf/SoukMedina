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
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    @FXML
    private AnchorPane paneajoutarticle;
  
    
    public VendeurinterfaceController parent;
    @FXML
    private Label okimage;
        List<String> itemList = new ArrayList<String>();
    @FXML
    private JFXTextField imageURL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemList.add("T-Shirts");
        itemList.add("Chemises");
        itemList.add("Pantalons");
        itemList.add("Robes");
        itemList.add("Foulardss");
        itemList.add("Lunettes");
        itemList.add("Chaussures");
        itemList.add("Ceintures");
        itemList.add("Boucles_oreilles");
        itemList.add("Collierss");
        itemList.add("Bagues");
        itemList.add("bracelets");
        itemList.add("Sac_main");
        itemList.add("Sac_dos");
        itemList.add("Pochettes");
        ObservableList obs = FXCollections.observableList(itemList);
        tfcategorie.setItems(obs);
    }    
    public void getid_boutique(String labid,VendeurinterfaceController controller){
        this.labid.setText(labid);
        parent=controller;
    }

    @FXML
    private void ajouter_article(ActionEvent event) {
        articlesService as=new articlesService();
        Boutique b =new Boutique(Integer.parseInt(labid.getText()));
        b.setId(Integer.parseInt(labid.getText()));
        articles a=new articles(tfnom.getText(),imageURL.getText() ,tftaille.getText(), tfcouleur.getText(), Float.parseFloat(tfprix.getText()), tfcategorie.getValue().toString(), b);
        as.insert_article(a);
        parent.refreshArticle();
        parent.addArticleDialog.close();
        
    }


   
    
   
    
}
