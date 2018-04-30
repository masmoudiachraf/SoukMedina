/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.service.PanierService;
import com.esprit.service.articlesService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panierInterfaceFloawPane.setHgap(8);
        panierInterfaceFloawPane.setVgap(8);
        try {
            backBtn.setGraphic(new ImageView((getClass().getResource("/Assets/home.png")).toURI().toString()));
        } catch (URISyntaxException ex) {
            Logger.getLogger(PanierInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   
    
    public void loadArticlesIntoPanier(){
        listPanier = panierService.displayall(UserInterfaceController.logedUser);
        listPanier.forEach((panier) -> {
            listarticles.add(arService.displaySingleArticle(panier.getArticles_fk().getId()));
        });
        
        listarticles.forEach((article) -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/PanierItem.fxml"));
                Pane newLoadedPane = loader.load();
                PanierItemController controller = loader.<PanierItemController>getController();
                controller.loadPanier(article, 0);
                panierInterfaceFloawPane.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
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
    }

    @FXML
    private void update_profile(ActionEvent event) {
    }

    @FXML
    private void validerBtnClick(ActionEvent event) {
    }

    @FXML
    private void viderBtnClick(ActionEvent event) {
    }
    
     public void start(Stage window, String destination) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }
}
