/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.articlesService;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class VendeurinterfaceController implements Initializable {

    @FXML
    private Label labnom;
    private Label labprenom;
    @FXML
    private Label labmail;
    @FXML
    private Label labtelephone;
    @FXML
    private Label labadresse;
    private Label labnaissance;
    @FXML
    private Hyperlink linklogout;
    @FXML
    private Hyperlink linksetting;
    @FXML
    private Label labpassword;
    @FXML
    private Label labid;
    @FXML
    private Label labactivite;
    @FXML
    private AnchorPane vendeurguiroot;
    @FXML
    private Pane panesetting;
    private Label articleexmple;
    private ListView<?> articlelv;
    @FXML
    private JFXButton btnajoutarticle;
    @FXML
    private FlowPane listArticleFlowPane;
    @FXML
    private JFXButton btnrefresh;
    @FXML
    private Pane ajoutartpane;
    @FXML
    private StackPane interface_container;
    @FXML
    private TextField vendeurRecherArticleTextField;
    @FXML
    private ScrollPane listArticleFlowPaneContainer;
    @FXML
    private Button addBtn;

    ArrayList<articles> listArticles ;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void boutiqueinformation(String labid, String labnom, String labmail, String labpassword, String labadresse, String labtelephone, String labactivite) {
        this.labid.setText(labid);
        this.labnom.setText(labnom);
        this.labmail.setText(labmail);
        this.labpassword.setText(labpassword);
        this.labtelephone.setText(labtelephone);
        this.labadresse.setText(labadresse);
        this.labactivite.setText(labactivite);

    }

    public void userinformation(String labid) throws IOException {

        articlesService as = new articlesService();
        ArrayList<articles> arraylist = (ArrayList) as.displayall(Integer.parseInt(labid));
        listArticles=arraylist;
        listArticleFlowPane.setPadding(new Insets(5, 5, 8, 8));
        listArticleFlowPane.setVgap(8);
        listArticleFlowPane.setHgap(8);
        for (articles article : arraylist) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ArticleItem.fxml"));
            Pane newLoadedPane = loader.load();
            //newLoadedPane.prefWidthProperty().bind(listArticleFlowPane.prefWidthProperty());
            ArticleItemController controller = loader.<ArticleItemController>getController();
            controller.loadArticle(article, this);
            listArticleFlowPane.getChildren().add(newLoadedPane);
        }

    }

    @FXML
    private void direction_update_profile(ActionEvent event) throws IOException {
        List<String> itemList = new ArrayList<String>();

        itemList.add("Act1");
        itemList.add("Act2");
        itemList.add("Act3");
        itemList.add("Act4");
        ObservableList obs = FXCollections.observableList(itemList);
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXTextField nom = new JFXTextField(labnom.getText());
        JFXTextField mail = new JFXTextField(labmail.getText());
        JFXTextField password = new JFXTextField(labpassword.getText());
        JFXTextField adresse = new JFXTextField(labadresse.getText());
        JFXTextField telephone = new JFXTextField(labtelephone.getText());
        JFXComboBox<?> activite_bout = new JFXComboBox<>();
        activite_bout.setItems(obs);
        activite_bout.setPrefWidth(120);

        JFXButton Modifier = new JFXButton("Modifier");
        JFXButton Annuler = new JFXButton("anuuler");
        Modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ServiceBoutique sb = new ServiceBoutique();
                    Boutique b = new Boutique(nom.getText(), mail.getText(), password.getText(), adresse.getText(), Integer.parseInt(telephone.getText()), activite_bout.getValue().toString());
                    sb.update_boutique(b, Integer.parseInt(labid.getText()));
                    // panesetting.getChildren().clear();

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
        content.setActions(nom, mail, password, adresse, telephone, activite_bout, Modifier, Annuler);
        dialog.show();

        /*FXMLLoader Loader= new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/vendeurSetting.fxml"));
            Pane pane=Loader.load();
            
            ajoutartpane.getChildren().setAll(pane);  
            VendeurSettingController userzone= Loader.getController();
           userzone.userinformation(labid.getText(), labnom.getText(),labmail.getText(),labpassword.getText(),labadresse.getText(),labtelephone.getText(),labactivite.getText());         
         */
    }

    @FXML
    private void ajouter_article_gui(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/ajouterarticle.fxml"));
        Pane pane = Loader.load();
        ajoutartpane.getChildren().setAll(pane);
        AjouterarticleController ajoutzone = Loader.getController();
        ajoutzone.getid_boutique(labid.getText());
    }

    @FXML
    private void refresh(ActionEvent event) throws IOException {
        refreshArticle();
    }

    public void refreshArticle() {
        articlesService as = new articlesService();
        ArrayList<articles> arraylist = (ArrayList) as.displayall(Integer.parseInt(labid.getText()));
        listArticleFlowPane.getChildren().clear();
        listArticles = arraylist;
        for (articles article : arraylist) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ArticleItem.fxml"));
                Pane newLoadedPane = loader.load();
                ArticleItemController controller = loader.<ArticleItemController>getController();
                controller.loadArticle(article, this);
                listArticleFlowPane.getChildren().add(newLoadedPane);
            } catch (Exception ex) {
                Logger.getLogger(VendeurinterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/LoginGui.fxml"));
        Pane pane = Loader.load();

        vendeurguiroot.getChildren().setAll(pane);
    }

    @FXML
    private void rechercheArticleOnKeyPressed(KeyEvent event) {
         ArrayList<articles> searchedArticles = new ArrayList<>();
        searchedArticles.clear();
        listArticleFlowPane.getChildren().clear();
        for (articles article : listArticles) {
            if (article.getNom().contains(vendeurRecherArticleTextField.getText())) {
                searchedArticles.add(article);
            }
        }
        for (articles article : searchedArticles) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ArticleItem.fxml"));
                Pane newLoadedPane = loader.load();
                ArticleItemController controller = loader.<ArticleItemController>getController();
                controller.loadArticle(article, this);
                listArticleFlowPane.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void deleteArticle(String id) {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Mode"));
        content.setBody(new Text("Vous voulez vraiment supprmer cet article ?"));
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXButton oui = new JFXButton("oui");
        JFXButton non = new JFXButton("non");
        oui.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    articlesService as = new articlesService();
                    as.delete(Integer.parseInt(id));
                    refreshArticle();
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

    public void displayDetailsArticle(articles artcle) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        Label taille = new Label(artcle.getTaille());
        Label couleur = new Label(artcle.getCouleur());
        Label categorie = new Label(artcle.getCategorie());
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
        content.setBody(new Text("Taille: " + taille.getText() + "\n\nCouleur: " + taille.getText() + "\n\nCatégorie: " + categorie.getText()));
        content.setActions(annuler);
        dialog.show();
    }

    public void mofiferArticle(articles article) {
        List<String> itemList = new ArrayList<String>();
        itemList.add("cat1");
        itemList.add("cat2");
        itemList.add("cat3");
        itemList.add("cat4");
        ObservableList obs = FXCollections.observableList(itemList);

        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXTextField nom = new JFXTextField(article.getNom());
        JFXTextField taille = new JFXTextField(article.getTaille());
        JFXTextField couleur = new JFXTextField(article.getCouleur());
        JFXTextField prix = new JFXTextField(Float.toString(article.getPrix()));
        JFXComboBox<?> categorie = new JFXComboBox<>();
        categorie.setPrefWidth(130);
        categorie.setItems(obs);

        JFXButton Modifier = new JFXButton("OK");
        JFXButton Annuler = new JFXButton("anuuler");
        Modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    articlesService as = new articlesService();
                    articles art = new articles(nom.getText(), taille.getText(), couleur.getText(), Float.parseFloat(prix.getText()), categorie.getValue().toString());
                    as.update(art, article.getId());
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
        content.setActions(nom, taille, couleur, prix, categorie, Modifier, Annuler);
        dialog.show();

    }

    @FXML
    private void addArticleClick(ActionEvent event) {
        List<String> itemList = new ArrayList<String>();
        itemList.add("cat1");
        itemList.add("cat2");
        itemList.add("cat3");
        itemList.add("cat4");
        ObservableList obs = FXCollections.observableList(itemList);
        
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXTextField nom=new JFXTextField();
        JFXTextField taille=new JFXTextField();
        JFXTextField couleur=new JFXTextField();
        JFXTextField prix=new JFXTextField();
        JFXComboBox<?> categorie =new JFXComboBox<>();
        categorie.setPrefWidth(130);
        categorie.setItems(obs);
        
        JFXButton Modifier = new JFXButton("OK");
        JFXButton Annuler = new JFXButton("anuuler");
        Modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    articlesService as=new articlesService();
                    articles art=new articles(nom.getText(), taille.getText(), couleur.getText(), Float.parseFloat(prix.getText()), categorie.getValue().toString());
                    as.insert_article(art);
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
                content.setActions(nom,taille,couleur,prix,categorie,Modifier,Annuler);
                dialog.show();
    }

}
