/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.UserInterfaceController.logedUser;
import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
import com.esprit.service.PanierService;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class PanierInterfaceController implements Initializable {

    PanierService panierService = new PanierService();
    articlesService arService = new articlesService();
    List<Panier> listPanier = new ArrayList<Panier>();
    List<articles> listarticles = new ArrayList<>();
    
    @FXML
    private JFXButton backBtn;
    @FXML
    private Hyperlink linklogout;
    @FXML
    private Hyperlink linksetting;
    @FXML
    private ScrollPane panierInterfaceFloawPaneContainer;
    @FXML
    private FlowPane panierInterfaceFloawPane;
    @FXML
    private JFXButton validerBtn;
    @FXML
    private JFXButton viderBtn;
    @FXML
    private JFXButton historiqueBtn;
    private JFXButton panierBtn1;
    @FXML
    private JFXButton panierBtn;
    @FXML
    private AnchorPane AnchorHeader;
    @FXML
    private StackPane PanierAnchorPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panierInterfaceFloawPane.setHgap(8);
        panierInterfaceFloawPane.setVgap(8);
        try {
            backBtn.setGraphic(new ImageView((getClass().getResource("/Assets/backBtn.png")).toURI().toString()));
        } catch (URISyntaxException ex) {
            Logger.getLogger(PanierInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        panierBtn.setVisible(false);
    }   
    
    public void loadArticlesIntoPanier(){
        panierInterfaceFloawPane.getChildren().clear();
        listPanier = panierService.displayall(UserInterfaceController.logedUser);
        listPanier.forEach((panier) -> {
            if(panier.getEtat_panier()==0)
            {
                articles article = arService.displaySingleArticle(panier.getArticles_fk().getId());
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/PanierItem.fxml"));
                Pane newLoadedPane = loader.load();
                PanierItemController controller = loader.<PanierItemController>getController();
                controller.loadPanier(article, 0, panier, this);
                panierInterfaceFloawPane.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
            

    }

    @FXML
    private void backBtnClick(ActionEvent event) {
        try {
            start((Stage) backBtn.getScene().getWindow(), "/GUI/UserInterface.fxml");
        } catch (Exception ex) {
            Logger.getLogger(ArticleInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void logout(ActionEvent event) {
        try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/LoginGui.fxml"));
            Pane pane = Loader.load();
            PanierAnchorPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(PanierInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void update_profile(ActionEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(PanierAnchorPane, content, JFXDialog.DialogTransition.CENTER);
        JFXTextField nom = new JFXTextField(logedUser.getNom_uti());
        JFXTextField prenom = new JFXTextField(logedUser.getPrenom_uti());
        JFXTextField mail = new JFXTextField(logedUser.getMail_uti());
        JFXTextField password = new JFXTextField(logedUser.getPassword_uti());
        JFXTextField adresse = new JFXTextField(logedUser.getAdresse_uti());
        JFXTextField telephone = new JFXTextField(Integer.toString(logedUser.getTelephone_uti()));
        JFXButton Modifier = new JFXButton("Modifier");
        JFXButton Annuler = new JFXButton("anuuler");
        Modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    serviceUtilisateur su = new serviceUtilisateur();
                    utilisateur u = new utilisateur(nom.getText(), prenom.getText(), mail.getText(), password.getText(), adresse.getText(), Integer.parseInt(telephone.getText()), UserInterfaceController.logedUser.getNaissance_uti());
                    su.update_user(u, UserInterfaceController.logedUser.getId_uti());
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

    @FXML
    private void validerBtnClick(ActionEvent event) {
        listPanier = panierService.displayall(UserInterfaceController.logedUser);
        listPanier.forEach((panier) -> {
            if(panier.getEtat_panier()==0)
            {
                panierService.validerPanier(panier);
                loadArticlesIntoPanier();
                System.out.println(panier);
            }
        });
    }

    @FXML
    private void viderBtnClick(ActionEvent event) {
        listPanier = panierService.displayall(UserInterfaceController.logedUser);
        listPanier.forEach((panier) -> {
            if(panier.getEtat_panier()==0)
            {
                panierService.delete(panier.getArticles_fk());
                loadArticlesIntoPanier();
            }
        });
    }
    
     public void start(Stage window, String destination) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void historiquesBtnClick(ActionEvent event) {
        panierInterfaceFloawPane.getChildren().clear();
        listPanier = panierService.displayall(UserInterfaceController.logedUser);
        listPanier.forEach((panier) -> {
            if(panier.getEtat_panier()!=0)
            {
                articles article = arService.displaySingleArticle(panier.getArticles_fk().getId());
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/PanierItem.fxml"));
                Pane newLoadedPane = loader.load();
                PanierItemController controller = loader.<PanierItemController>getController();
                controller.loadPanier(article, 0, panier, this);
                panierInterfaceFloawPane.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
        validerBtn.setVisible(false);
        viderBtn.setVisible(false);
        panierBtn.setVisible(true);
    }

    @FXML
    private void returnPanierBtnClick(ActionEvent event) {
        panierBtn.setVisible(false);
        loadArticlesIntoPanier();
        validerBtn.setVisible(true);
        viderBtn.setVisible(true);

    }
}
