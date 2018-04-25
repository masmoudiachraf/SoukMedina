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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;

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

    VendeurinterfaceController parentController;
    articles article;

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
    private ImageView btnmodifierarticle;
    @FXML
    private AnchorPane panearticleitem;
    @FXML
    private ImageView imagevi;
    @FXML
    private StackPane interface_containe;
    @FXML
    private Hyperlink linkdetails;
    @FXML
    private ImageView deleteArticleIv;
    @FXML
    private ImageView articleDetails;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        btnmodifierarticle.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                parentController.mofiferArticle(article);
            }
        });

        deleteArticleIv.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                parentController.deleteArticle(articleItemlabel.getText());
            }
        });

        articleDetails.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                parentController.displayDetailsArticle(article);
            }
        });
    }

    public void loadArticle(articles article, VendeurinterfaceController parentController) throws FileNotFoundException {
        this.article = article;
        this.parentController = parentController;
        String sourceimage = article.getImage();
        articleItemlabel.setText(Integer.toString(article.getId()));
        articleItemlabel1.setText(article.getNom());
        if (sourceimage.equals("")) {

            try {
                Image img = new Image((getClass().getResource("/Assets/article.png")).toURI().toString());
                imagevi.setImage(img);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArticleitemuserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Image img = new Image(sourceimage);
            imagevi.setImage(img);
        }
        articleItemlabel2.setText(article.getTaille());
        articleItemlabel3.setText(article.getCouleur());
        articleItemlabel4.setText(Float.toString(article.getPrix()));
        articleItemlabel5.setText(article.getCategorie());
    }

}
