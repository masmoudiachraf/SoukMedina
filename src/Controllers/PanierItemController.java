/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.service.PanierService;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class PanierItemController implements Initializable {

    PanierService panierService = new PanierService();
    Panier currentPanier = null;
    articles currentArticle = null;
    PanierInterfaceController parentController = null;

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
    @FXML
    private Label etat_livraison;
    @FXML
    private Label quantiteLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panierAddQuantite.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                panierQuantiteTF.setText(Integer.toString(Integer.parseInt(panierQuantiteTF.getText()) + 1));
            }
        });
        panierRemoveQuantite.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (Integer.parseInt(panierQuantiteTF.getText()) > 0) {
                    panierQuantiteTF.setText(Integer.toString(Integer.parseInt(panierQuantiteTF.getText()) - 1));
                }
            }
        });

        panierRemoveArticle.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                panierService.delete(currentArticle);
                parentController.loadArticlesIntoPanier();
            }
        });
    }

    public void loadPanier(articles article, int quantite, Panier panier, PanierInterfaceController controller) {
        currentPanier = panier;
        currentArticle = article;
        parentController = controller;

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

        panierQuantiteTF.setText(Integer.toString(panier.getQuantite()));
        panierArticleName.setText(article.getNom());
        panierTailleLabel.setText(article.getTaille());
        panierCouleurLabel.setText(article.getCouleur());
        if (panier.getEtat_panier() != 0) {
            etat_livraison.setVisible(true);
            panierAddQuantite.setVisible(false);
            panierQuantiteTF.setVisible(false);
            panierRemoveArticle.setVisible(false);
            panierRemoveQuantite.setVisible(false);
            quantiteLabel.setVisible(false);
            if (panier.getEtat_panier() == 1) {
                etat_livraison.setText("En cours de preparation");
                etat_livraison.setTextFill(Color.web("#e17055"));
            } else if (panier.getEtat_panier() == 2){
                etat_livraison.setText("En cours de livraison");
                etat_livraison.setTextFill(Color.web("#e17055"));
            }else if (panier.getEtat_panier() == 3) {
                etat_livraison.setText("Article livré");
                etat_livraison.setTextFill(Color.web("#00b894"));

            }

        }
    }
}
