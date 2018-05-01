/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
import com.esprit.service.PanierService;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.articlesService;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class UserInterfaceController implements Initializable {

    List<Boutique> listBoutiques = new ArrayList();
    ServiceBoutique serviceBoutique = new ServiceBoutique();
    articlesService as = new articlesService();
    ArrayList<articles> listArticle;
    utilisateur user;

    @FXML
    private AnchorPane paneuserinterface;
    @FXML
    private ScrollPane scrolpaneboutiques;
    @FXML
    private FlowPane flowpaneboutiques;
    @FXML
    private Pane panenavbar;
    @FXML
    private ScrollPane scrolpanearticles;
    @FXML
    public FlowPane flowpanearticles;
    @FXML
    private Label labid;
    @FXML
    private Label labnom;
    @FXML
    private Label labprenom;
    @FXML
    private Label labmail;
    @FXML
    private Label labpassword;
    @FXML
    private Label labadresse;
    @FXML
    private Label labtelephone;
    @FXML
    private Label labnaissance;
    public Label labidbout;
    @FXML
    private Hyperlink linklogout;
    @FXML
    private Hyperlink linksetting;
    @FXML
    private StackPane interface_container;

    private StackPane userInterfaceContainer;
    @FXML
    private Hyperlink linksetting1;
    @FXML
    private TextField recherArticleTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flowpaneboutiques.setVgap(8);
        flowpaneboutiques.setHgap(8);
        flowpanearticles.setVgap(8);
        flowpanearticles.setHgap(8);

        listBoutiques = serviceBoutique.displayall_boutique();
        listBoutiques.forEach((boutique) -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/BoutiqueItemListView.fxml"));
                Pane newLoadedPane = loader.load();
                BoutiqueItemListViewController controller = loader.<BoutiqueItemListViewController>getController();
                controller.loadBoutique(boutique, UserInterfaceController.this);
                flowpaneboutiques.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void userinformation(String labid, String labnom, String labprenom, String labmail, String labpassword, String labadresse, String labtelephone, String labnaissance) throws IOException {
        this.labid.setText(labid);
        this.labnom.setText(labnom);
        this.labprenom.setText(labprenom);
        this.labmail.setText(labmail);
        this.labpassword.setText(labpassword);
        this.labtelephone.setText(labtelephone);
        this.labadresse.setText(labadresse);
        this.labnaissance.setText(labnaissance);
            
        user = new utilisateur(Integer.parseInt(labid), labmail, labprenom, labmail, labpassword, labadresse, Integer.parseInt(labtelephone), labnaissance);
        /* ServiceBoutique sb=new ServiceBoutique();           
        ArrayList<Boutique> arraylist = (ArrayList) sb.displayall_boutique();
                  flowpaneboutiques.setPadding(new Insets(5, 5, 8, 8));
                   flowpaneboutiques.setVgap(10);
                   flowpaneboutiques.setHgap(8);
         for(Boutique boutique : arraylist) {
             
            Label id=new Label(String.valueOf(boutique.getId()));
            id.setVisible(false);
            Label nom=new Label(boutique.getNom_bout());
            Label activite=new Label(boutique.getActivite_bout());
            
             JFXButton b=new JFXButton(nom.getText()+"\n"+activite.getText());
           
           b.setPrefSize(120, 100);
           //b.setStyle("-fx-border-color:black;"+"-fx-border-radius:5em;");
           flowpaneboutiques.getChildren().addAll(b);
           b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                flowpanearticles.getChildren().clear();
                 articlesService as=new articlesService();    
                  flowpanearticles.setPadding(new Insets(5, 5, 8, 8));
                   flowpanearticles.setVgap(10);
                   flowpanearticles.setHgap(8);
                   
                   
                     ArrayList<articles> arraylist2 = (ArrayList) as.displayall(Integer.parseInt(id.getText()));
                    for (articles article : arraylist2) {            
                     try {
                         FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/GUI/articleitemuser.fxml"));
                         Pane newLoadedPane2 = loader2.load();
                         ArticleitemuserController controller2 = loader2.<ArticleitemuserController>getController();
                         controller2.loadArticle(article);
                         newLoadedPane2.setStyle("-fx-border-color:black;"+"-fx-border-radius:1em;");
                         flowpanearticles.getChildren().add(newLoadedPane2);
                     } catch (IOException ex) {
                         Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    
        }   
            }
        }
           
           );
         }      
         */
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/LoginGui.fxml"));
        Pane pane = Loader.load();
        paneuserinterface.getChildren().setAll(pane);
    }

    @FXML
    private void update_profile(ActionEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXTextField nom = new JFXTextField(labnom.getText());
        JFXTextField prenom = new JFXTextField(labprenom.getText());
        JFXTextField mail = new JFXTextField(labmail.getText());
        JFXTextField password = new JFXTextField(labpassword.getText());
        JFXTextField adresse = new JFXTextField(labadresse.getText());
        JFXTextField telephone = new JFXTextField(labtelephone.getText());
        JFXButton Modifier = new JFXButton("Modifier");
        JFXButton Annuler = new JFXButton("anuuler");
        Modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    serviceUtilisateur su = new serviceUtilisateur();
                    utilisateur u = new utilisateur(nom.getText(), prenom.getText(), mail.getText(), password.getText(), adresse.getText(), Integer.parseInt(telephone.getText()), labnaissance.getText());
                    su.update_user(u, Integer.parseInt(labid.getText()));
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
        content.setActions(nom, prenom, mail, password, adresse, telephone, Modifier, Annuler);
        dialog.show();
    }

    public void refresharticleFlowPane(int idBout) {
        flowpanearticles.getChildren().clear();
        listArticle = (ArrayList) as.displayall(idBout);
        for (articles article : listArticle) {
            try {
                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/GUI/articleitemuser.fxml"));
                Pane newLoadedPane2 = loader2.load();
                ArticleitemuserController controller2 = loader2.<ArticleitemuserController>getController();
                controller2.loadArticle(article, this);
                flowpanearticles.getChildren().add(newLoadedPane2);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void detailBoutiquePopup(Boutique boutique) throws IOException{
         FXMLLoader Loader = new FXMLLoader();
         Loader.setLocation(getClass().getResource("/GUI/BoutiqueItemDetails.fxml"));
        Pane pane = Loader.load();
        BoutiqueItemDetailsController controller = Loader.<BoutiqueItemDetailsController>getController();
        controller.loadBoutique(boutique);
        controller.loaduser(labmail.getText());
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(pane);
        content.setPrefSize(500, 210);
        dialog.show();
        
    } 
    
    public void articleDetailsClick(articles article, String quantite) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        Label taille = new Label(article.getTaille());
        Label couleur = new Label(article.getCouleur());
        Label categorie = new Label(article.getCategorie());
        TextField qteTxt = new TextField();

        JFXButton ok = new JFXButton("OK");
        ok.setOnAction(new EventHandler<ActionEvent>() {
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
        JFXButton addPanier = new JFXButton("Ajouter au panier");
        addPanier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (Integer.parseInt(quantite)>0) {
                         Panier panier = new Panier(user, article, Integer.parseInt(quantite), "In Hold");
                        PanierService ps = new PanierService();
                        ps.insert(panier);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        //content.setPrefSize(120, 200);
        content.setBody(new Text("Taille: " + taille.getText() + "\n\nCouleur: " + taille.getText() + "\n\nCatégorie: " + categorie.getText() + "\n\nQuantité: " + quantite));
        content.setActions(ok, addPanier);
        dialog.show();
    }

    @FXML
    private void rechercheArticleOnKeyPressed(KeyEvent event) {
        ArrayList<articles> searchedArticles = new ArrayList<>();
        searchedArticles.clear();
        flowpanearticles.getChildren().clear();
        for (articles article : listArticle) {
            if (article.getNom().contains(recherArticleTextField.getText())) {
                searchedArticles.add(article);
            }
        }
        for (articles article : searchedArticles) {
            try {
                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/GUI/articleitemuser.fxml"));
                Pane newLoadedPane2 = loader2.load();
                ArticleitemuserController controller2 = loader2.<ArticleitemuserController>getController();
                controller2.loadArticle(article, this);
                flowpanearticles.getChildren().add(newLoadedPane2);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
