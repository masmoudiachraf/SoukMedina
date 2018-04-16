/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.articles;
import com.esprit.service.articlesService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class VendeurinterfaceController implements Initializable {

    @FXML
    private Label labnom;
    private Label labprenom;
    @FXML
    private Label labmail;
    @FXML
    private Label labtelephone;
    @FXML
    private Label labadresse;
    private Label labnaissance;
    @FXML
    private Hyperlink linklogout;
    @FXML
    private Hyperlink linksetting;
    @FXML
    private Label labpassword;
    @FXML
    private Label labid;
    @FXML
    private Label labactivite;
    @FXML
    private AnchorPane vendeurguiroot;
    @FXML
    private Pane panesetting;
    private Label articleexmple;
    private ListView<?> articlelv;
    @FXML
    private JFXButton btnajoutarticle;
    @FXML
    private FlowPane listArticleFlowPane;
    @FXML
    private JFXButton btnrefresh;
    @FXML
    private Pane ajoutartpane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    public void userinformation(String labid,String labnom, String labmail,String labpassword ,String labadresse,String labtelephone, String labactivite) throws IOException {
        this.labid.setText(labid);
        this.labnom.setText(labnom);
        this.labmail.setText(labmail);
        this.labpassword.setText(labpassword);
        this.labtelephone.setText(labtelephone);
        this.labadresse.setText(labadresse);
        this.labactivite.setText(labactivite);
        
        articlesService as=new articlesService();
        ArrayList<articles> arraylist = (ArrayList) as.displayall(Integer.parseInt(labid));
        System.out.println(labid);
        /*ObservableList obs = FXCollections.observableArrayList(arraylist);
        articlelv.setItems(obs);*/
        for (articles article : arraylist) {            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ArticleItem.fxml"));
                    Pane newLoadedPane = loader.load();
                    //newLoadedPane.prefWidthProperty().bind(listArticleFlowPane.prefWidthProperty());
                    ArticleItemController controller = loader.<ArticleItemController>getController();
                    controller.loadArticle(article);
                    listArticleFlowPane.getChildren().add(newLoadedPane);
                    newLoadedPane.setStyle("-fx-border-color:black");
                    
        }
        
    }
    

    @FXML
    private void direction_update_profile(ActionEvent event) throws IOException {
         FXMLLoader Loader= new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/vendeurSetting.fxml"));
            Pane pane=Loader.load();
            
            ajoutartpane.getChildren().setAll(pane);  
            VendeurSettingController userzone= Loader.getController();
           userzone.userinformation(labid.getText(), labnom.getText(),labmail.getText(),labpassword.getText(),labadresse.getText(),labtelephone.getText(),labactivite.getText());         
    }

    @FXML
    private void ajouter_article_gui(ActionEvent event) throws IOException {
         FXMLLoader Loader= new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/ajouterarticle.fxml"));
            Pane pane=Loader.load();
            ajoutartpane.getChildren().setAll(pane);  
             AjouterarticleController ajoutzone =Loader.getController();
            ajoutzone.getid_boutique(labid.getText());
    }

    @FXML
    private void refresh(ActionEvent event) throws IOException {
      articlesService as=new articlesService();
        ArrayList<articles> arraylist = (ArrayList) as.displayall(Integer.parseInt(labid.getText()));
        listArticleFlowPane.getChildren().clear();
        for (articles article : arraylist) {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ArticleItem.fxml"));
                    Pane newLoadedPane = loader.load();
                    ArticleItemController controller = loader.<ArticleItemController>getController();
                    controller.loadArticle(article);
                    listArticleFlowPane.getChildren().add(newLoadedPane);
                    newLoadedPane.setStyle("-fx-border-color:black");
                    
        }   
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        FXMLLoader Loader= new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/LoginGui.fxml"));
            Pane pane=Loader.load();
            
            vendeurguiroot.getChildren().setAll(pane); 
    }

    

   


    
    
}
