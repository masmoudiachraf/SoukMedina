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
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class ArticleitemuserController implements Initializable {

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
    private void details(ActionEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        Label taille=new Label(articleItemlabel2.getText());
        Label couleur=new Label(articleItemlabel3.getText());
        Label categorie=new Label(articleItemlabel5.getText());
        JFXButton annuler = new JFXButton("OK");
        annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        );
         content.setPrefSize(120, 200);
         content.setBody(new Text("Taille: "+taille.getText()+"\n\nCouleur: "+taille.getText()+"\n\nCatégorie: "+categorie.getText()));
                content.setActions(annuler);
                dialog.show();
        
    }
    
    
}
