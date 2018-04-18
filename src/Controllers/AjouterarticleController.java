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
    private JFXButton annuler;
    @FXML
    private AnchorPane paneajoutarticle;
  
    
    public VendeurinterfaceController parent;
    @FXML
    private Button btnfile;
    @FXML
    private Label okimage;
        List<String> itemList = new ArrayList<String>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         itemList.add("cat1");
        itemList.add("cat2");
        itemList.add("cat3");
        itemList.add("cat4");
        ObservableList obs = FXCollections.observableList(itemList);
        tfcategorie.setItems(obs);
    }    
    public void getid_boutique(String labid){
        this.labid.setText(labid);
    }
    String filename="";
     @FXML
    private String addimage() {
        
        FileChooser fc=new FileChooser();
        fc.setTitle("select your image");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image","*.JPG","*.PNG"));
        File selectedfile =fc.showOpenDialog(new Stage());
        if(selectedfile != null){
            filename=selectedfile.getPath();
            okimage.setVisible(true);
            okimage.setText("ok");
            return filename;
        }
        return filename;
    }
    @FXML
    private void ajouter_article(ActionEvent event) {
        articlesService as=new articlesService();
        Boutique b =new Boutique(Integer.parseInt(labid.getText()));
        b.setId(Integer.parseInt(labid.getText()));
    articles a=new articles(tfnom.getText(),filename.replace("\\", "/") ,tftaille.getText(), tfcouleur.getText(), Float.parseFloat(tfprix.getText()), tfcategorie.getValue().toString(), b);
       as.insert_article(a);
       // System.out.println(filename);
        
    }

  @FXML
    private void annuler_eta_initial(ActionEvent event) throws IOException {
         //this.parent.etaInitial();
         paneajoutarticle.setVisible(false);
         paneajoutarticle.setStyle("-fx-background-color:rgba(255, 255, 255, 0);");

          
            
    }

   
    
   
    
}
