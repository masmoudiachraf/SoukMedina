/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.articles;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class PanierItemController implements Initializable {

    @FXML
    private ImageView panierArticleImage;
    @FXML
    private ImageView panierRemoveArticle;
    @FXML
    private TextField panierQuantiteTF;
    @FXML
    private ImageView panierAddQuantite;
    @FXML
    private ImageView panierRemoveQuantite;
    @FXML
    private Label panierArticleName;
    @FXML
    private Label panierTailleLabel;
    @FXML
    private Label panierCouleurLabel;
    @FXML
    private AnchorPane AnchorContainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void loadPanier(articles article, int quantite) {

        System.out.println(article);
        String sourceimage = article.getImage();
        if (sourceimage.equals("")) {

            try {
                Image img = new Image((getClass().getResource("/Assets/article.png")).toURI().toString());
                panierArticleImage.setImage(img);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArticleitemuserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Image img = new Image(sourceimage);
            panierArticleImage.setImage(img);
        }
        
        panierQuantiteTF.setText(Integer.toString(quantite));
        panierArticleName.setText(article.getNom());
        panierTailleLabel.setText(article.getTaille());
        panierCouleurLabel.setText(article.getCouleur());
    }
}
