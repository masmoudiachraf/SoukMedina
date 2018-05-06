/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.UserInterfaceController.logedUser;
import com.esprit.entite.Commentaire;
import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
import com.esprit.service.PanierService;
import com.esprit.service.ServiceCommentaire;
import com.esprit.service.articlesService;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class ArticleInterfaceController implements Initializable {

    @FXML
    private ImageView articleImage;
    @FXML
    private Label articleName;
    @FXML
    private Label articleTaille;
    @FXML
    private Label articleCouleur;
    @FXML
    private Label articlePrix;
    @FXML
    private JFXButton articleAjouterPanier;
    @FXML
    private Label tailleLabel;
    @FXML
    private Label couleurLabel;
    @FXML
    private Label prixLabel;
    private Button backBtn;
    @FXML
    private FlowPane commentairesFlowPane;

    articles article;
    
    ServiceCommentaire serviceCommentaire = new ServiceCommentaire();
            
    @FXML
    private ImageView articleImage1;
    @FXML
    private ScrollPane commentairesFlowPaneContainer;
    @FXML
    private Hyperlink addCommentaire;
    @FXML
    private StackPane stackContainer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        commentairesFlowPane.setVgap(5);
        commentairesFlowPane.setHgap(5);
        // backBtn.setGraphic(new ImageView((getClass().getResource("/Assets/backBtn.png")).toURI().toString()));
    }    

    public void loadVariables(){
        articleName.setText(article.getNom()); 
        couleurLabel.setText(article.getCouleur());
        prixLabel.setText(Float.toString(article.getPrix()));
        tailleLabel.setText(article.getTaille());
        String sourceimage=article.getImage();
        if (sourceimage.equals("")) {
            try {
                Image img = new Image((getClass().getResource("/Assets/article.png")).toURI().toString());
                articleImage.setImage(img);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArticleitemuserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Image img = new Image(sourceimage);
            articleImage.setImage(img);
        }
        loadCommentaires();
        
    }
    
    public void loadCommentaires(){
        commentairesFlowPane.getChildren().clear();
        List<Commentaire> commentairesList = serviceCommentaire.displayallCommentaire(article);
        commentairesList.forEach((commentaire) -> {
             try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/CommentaireItem.fxml"));
                Pane newLoadedPane = loader.load();
                CommentaireItemController controller = loader.<CommentaireItemController>getController();
                controller.loadBoutique(commentaire, ArticleInterfaceController.this);
                commentairesFlowPane.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void AjouterPanierAction(ActionEvent event) {
        Panier panier = new Panier(UserInterfaceController.logedUser, article, 1, 0);
        PanierService ps = new PanierService();
        if (ps.displayaSinglePanierEnAttente(logedUser, article)==null) {
           ps.insert(panier); 
        }else{
            Panier foundPanier = ps.displayaSinglePanierEnAttente(logedUser, article);
            foundPanier.setQuantite(foundPanier.getQuantite()+1);
            System.out.println(foundPanier);
            ps.editQuantitePanier(foundPanier);
        }
        
    }


    /*private void backBtnClick(ActionEvent event) {
        try {
            start((Stage) backBtn.getScene().getWindow(), "/GUI/UserInterface.fxml");
        } catch (Exception ex) {
            Logger.getLogger(ArticleInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
     public void start(Stage window, String destination) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }
     
     public void DeleteCommentaire(Commentaire commentaire){
         JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Suppression"));
        content.setBody(new Text("Vous voulez vraiment supprmer ce commentaire ?"));
        JFXDialog dialog = new JFXDialog(stackContainer, content, JFXDialog.DialogTransition.CENTER);
        JFXButton oui = new JFXButton("oui");
        JFXButton non = new JFXButton("non");
        oui.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    serviceCommentaire.deleteCommentaire(commentaire);
                    loadCommentaires();
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        non.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.setActions(oui, non);
        dialog.show();

     }
     
     public void editCommentaire(Commentaire commentaire){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Modification"));
        JFXTextField commentaireText = new JFXTextField(commentaire.getCommentaire());
        content.setBody(commentaireText);
        JFXDialog dialog = new JFXDialog(stackContainer, content, JFXDialog.DialogTransition.CENTER);
        JFXButton modifier = new JFXButton("Modifier");
        JFXButton annuler = new JFXButton("Annuler");
        modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    commentaire.setCommentaire(commentaireText.getText());
                    serviceCommentaire.updateCommentaire(commentaire);
                    loadCommentaires();
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        content.setActions(modifier,annuler);
        dialog.show();

     }
     
     
     public void ajouterCommentaire(){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Ajouter commentaire"));
        JFXTextField commentaireText = new JFXTextField();
        content.setBody(commentaireText);
        JFXDialog dialog = new JFXDialog(stackContainer, content, JFXDialog.DialogTransition.CENTER);
        JFXButton modifier = new JFXButton("Ajouter");
        JFXButton annuler = new JFXButton("Annuler");
        modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(!commentaireText.getText().isEmpty()){
                        Commentaire commentaire = new Commentaire(UserInterfaceController.logedUser,article,commentaireText.getText());
                        serviceCommentaire.insertCommentaire(commentaire);
                        loadCommentaires();
                    }
                   
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        content.setActions(modifier,annuler);
        dialog.show();
     }

    @FXML
    private void ajouterCommentaireAction(ActionEvent event) {
        ajouterCommentaire();
    }
    
    public void signalerProfile(utilisateur user){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Signalisation"));
        content.setBody(new Text("Vous voulez vraiment signaler ce compte ?"));
        JFXDialog dialog = new JFXDialog(stackContainer, content, JFXDialog.DialogTransition.CENTER);
        JFXButton oui = new JFXButton("oui");
        JFXButton non = new JFXButton("non");
        oui.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    serviceUtilisateur su=new serviceUtilisateur();
                    su.update_user_signial(user, user.getId_uti());
                    
                    dialog.close();
                    
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        non.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.setActions(oui, non);
        dialog.show();

    }
}
