/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.articles;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class ArticleitemuserController implements Initializable {

    UserInterfaceController parentController;
    
    articles article;
        
    @FXML
    private AnchorPane panearticleitem;
    @FXML
    private Label articleItemlabel;
    @FXML
    private Label articleItemlabel1;
    @FXML
    private Label articleItemlabel2;
    @FXML
    private Label articleItemlabel3;
    @FXML
    private Label articleItemlabel4;
    @FXML
    private Label articleItemlabel5;
    @FXML
    private JFXButton btndeletearticle;
    @FXML
    private ImageView imagevi;
    @FXML
    private StackPane interface_container;
    @FXML
    private Hyperlink linkdetails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        interface_container.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    parentController.openArticleDetails(article);
                    
                } catch (Exception ex) {
                    Logger.getLogger(ArticleitemuserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }   
    public void loadArticle(articles article, UserInterfaceController parentController) throws FileNotFoundException{
        this.parentController = parentController;
        this.article = article;
        String sourceimage=article.getImage();
        articleItemlabel.setText(Integer.toString(article.getId()));
        //affectation du nom au label 
        articleItemlabel1.setText(article.getNom());
        // s'il n'a pas d'image
        if(sourceimage.equals("")){
       
            try {
                Image img=new Image((getClass().getResource("/Assets/article.png")).toURI().toString());
                imagevi.setImage(img);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArticleitemuserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // si il a une image
        else{
        Image img=new Image(sourceimage);
        imagevi.setImage(img);
        }
        articleItemlabel2.setText(article.getTaille());
        articleItemlabel3.setText(article.getCouleur());
        articleItemlabel4.setText(Float.toString(article.getPrix()));
        articleItemlabel5.setText(article.getCategorie());
    }

    @FXML
    private void details(ActionEvent event) {
        
        parentController.articleDetailsClick(article);
      
    }
    
    
     public void start(Stage window, String destination) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }
}
