/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.articles;
import com.esprit.service.articlesService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class ArticleItemController implements Initializable {

    @FXML
    private Label articleItemlabel;
    @FXML
    private Label articleItemlabel1;
    @FXML
    private Label articleItemlabel2;
    @FXML
    private Label articleItemlabel3;
         @FXML
    private JFXButton btndeletearticle;
    
         @FXML
    private Label articleItemlabel4;
    @FXML
    private Label articleItemlabel5;
    @FXML
    private JFXButton btnmodifierarticle;
    @FXML
    private AnchorPane panearticleitem;
    @FXML
    private ImageView imagevi;
    @FXML
    private StackPane interface_containe;

    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void loadArticle(articles article) throws FileNotFoundException{
        String sourceimage=article.getImage();
        articleItemlabel.setText(Integer.toString(article.getId()));
        articleItemlabel1.setText(article.getNom());
        if(sourceimage.equals("")){
        FileInputStream inputstream=new FileInputStream("C:\\Users\\iskander\\Desktop\\setting.png");
        Image img=new Image(inputstream);
        imagevi.setImage(img);
        }
        else{
        FileInputStream inputstream=new FileInputStream(sourceimage);
        Image img=new Image(inputstream);
        imagevi.setImage(img);
        }
        articleItemlabel2.setText(article.getTaille());
        articleItemlabel3.setText(article.getCouleur());
        articleItemlabel4.setText(Float.toString(article.getPrix()));
        articleItemlabel5.setText(article.getCategorie());
    }

    @FXML
    private void supprimer_article(ActionEvent event) {
        articlesService as=new articlesService();
        as.delete(Integer.parseInt(articleItemlabel.getText()));    
        panearticleitem.setVisible(false);
         panearticleitem.setStyle("-fx-background-color:rgba(255, 255, 255, 0);");
    }

  
      @FXML
    private void modifier_article(ActionEvent event) {
        List<String> itemList = new ArrayList<String>();
     itemList.add("cat1");
        itemList.add("cat2");
        itemList.add("cat3");
        itemList.add("cat4");
        ObservableList obs = FXCollections.observableList(itemList);
        
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_containe, content, JFXDialog.DialogTransition.CENTER);
        JFXTextField nom=new JFXTextField(articleItemlabel1.getText());
        JFXTextField taille=new JFXTextField(articleItemlabel2.getText());
        JFXTextField couleur=new JFXTextField(articleItemlabel3.getText());
        JFXTextField prix=new JFXTextField(articleItemlabel4.getText());
        JFXComboBox<?> categorie =new JFXComboBox<>();
        categorie.setPrefWidth(130);
        categorie.setItems(obs);
        
        JFXButton Modifier = new JFXButton("OK");
        JFXButton Annuler = new JFXButton("anuuler");
        Modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    articlesService as=new articlesService();
                    articles art=new articles(nom.getText(), taille.getText(), couleur.getText(), Float.parseFloat(prix.getText()), categorie.getValue().toString());
                    as.update(art,Integer.parseInt(articleItemlabel.getText() ));
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        content.setPrefSize(120, 200);
                content.setBody();
                content.setActions(nom,taille,couleur,prix,categorie,Modifier,Annuler);
                dialog.show();
           
        
    }

  
}
