/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.articles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    private Label articleItemlabel4;
    @FXML
    private Label articleItemlabel5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void loadArticle(articles article){
        articleItemlabel.setText(Integer.toString(article.getId()));
        articleItemlabel1.setText(article.getNom());
        articleItemlabel2.setText(article.getTaille());
        articleItemlabel3.setText(article.getCouleur());
        articleItemlabel4.setText(Float.toString(article.getPrix()));
        articleItemlabel5.setText(article.getCategorie());
    }
    
}
