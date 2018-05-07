/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.Evenements;
import com.esprit.entite.Mail;
import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.ServiceEvenements;
import com.esprit.service.articlesService;
import com.esprit.service.serviceMail;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.PopupControl;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    articlesService as = new articlesService();
    
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
    private FlowPane listArticleFlowPane;
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

    ArrayList<articles> listArticles;
    @FXML
    private Hyperlink linkcontact;

    public static Boutique logedBoutique;
    @FXML
    private Label labnbr_event;
    @FXML
    private ImageView imageVnotification;
    ArrayList<Evenements> arraylist;
    private int i;
    @FXML
    private Hyperlink linkevent;
    @FXML
    private JFXComboBox<?> CBactivite;
    @FXML
    private Label labid1;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXTextField tftelephone;
    @FXML
    private JFXTextField tfadresse;
    @FXML
    private JFXTextField tfpassword;
    @FXML
    private JFXTextField tfmail;
    @FXML
    private JFXTextField tfnom;
    @FXML
    private AnchorPane interfaceBoutiqueNavBar;
    @FXML
    private Hyperlink linkevent1;
    JFXDialog addArticleDialog;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialnotification();
    }

    public void initialnotification() {
        ServiceEvenements se = new ServiceEvenements();
        arraylist = (ArrayList) se.display_events();
        i = arraylist.size();
        labnbr_event.setText(Integer.toString(i));
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

       
        ArrayList<articles> arraylist = (ArrayList) as.displayall(Integer.parseInt(labid));
        listArticles = arraylist;
        listArticleFlowPane.setPadding(new Insets(5, 5, 8, 8));
        listArticleFlowPane.setVgap(8);
        listArticleFlowPane.setHgap(8);
        for (articles article : arraylist) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ArticleItem.fxml"));
            Pane newLoadedPane = loader.load();
            ArticleItemController controller = loader.<ArticleItemController>getController();
            controller.loadArticle(article, this);
            listArticleFlowPane.getChildren().add(newLoadedPane);
        }

    }

    @FXML
    private void direction_update_profile(ActionEvent event) throws IOException {
        /* FXMLLoader Loader= new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/vendeurSetting.fxml"));
            Pane pane=Loader.load();
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
            VendeurSettingController userzone= Loader.getController();
            userzone.loadboutique(labid.getText(), labnom.getText(),labmail.getText(),labpassword.getText(),labadresse.getText(),labtelephone.getText());         
            content.setBody(pane);
        content.setPrefSize(120, 200);
        dialog.show();
        
       ;*/
        List<String> itemList = new ArrayList<String>();
        itemList.add("Act1");
        itemList.add("Act2");
        itemList.add("Act3");
        itemList.add("Act4");
        ObservableList obs = FXCollections.observableList(itemList);
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        tfnom.setText(labnom.getText());
        tfmail.setText(labmail.getText());
        tfpassword.setText(labpassword.getText());
        tfadresse.setText(labadresse.getText());
        tftelephone.setText(labtelephone.getText());
        CBactivite.setItems(obs);
        content.setBody(ajoutartpane);
        ajoutartpane.setVisible(true);
        content.setPrefSize(180, 350);
        dialog.show();

    }

    @FXML
    private void update_user_profil(ActionEvent event) {
        ServiceBoutique sb = new ServiceBoutique();
        Boutique b = new Boutique(tfnom.getText(), tfmail.getText(), tfpassword.getText(), tfadresse.getText(), Integer.parseInt(tftelephone.getText()), CBactivite.getValue().toString());
        sb.update_boutique(b, Integer.parseInt(labid.getText()));
        labnom.setText(tfnom.getText());
        labmail.setText(tfmail.getText());
        labadresse.setText(tfadresse.getText());
        labtelephone.setText(tftelephone.getText());
        labactivite.setText(CBactivite.getValue().toString());
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(new Text("modifier avec succès "));
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
        content.setPrefSize(120, 200);
        content.setActions(ok);
        dialog.show();
    }

    private void refresh() throws IOException {
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
        content.setHeading(new Text("Suppression"));
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
        Label prix = new Label(Float.toString(artcle.getPrix()));
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
        content.setBody(new Text("Taille: " + taille.getText() + "\n\nCouleur: " + taille.getText() + "\n\nPrix: " + prix.getText() + " DT" + "\n\nCatégorie: " + categorie.getText()));
        content.setActions(annuler);
        dialog.show();
    }

    public void mofiferArticle(articles article) {
        List<String> itemList = new ArrayList<String>();
        itemList.add("T-Shirts");
        itemList.add("Chemises");
        itemList.add("Pantalons");
        itemList.add("Robes");
        itemList.add("Foulardss");
        itemList.add("Lunettes");
        itemList.add("Chaussures");
        itemList.add("Ceintures");
        itemList.add("Boucles_oreilles");
        itemList.add("Collierss");
        itemList.add("Bagues");
        itemList.add("bracelets");
        itemList.add("Sac_main");
        itemList.add("Sac_dos");
        itemList.add("Pochettes");
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
                    refreshArticle();
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
    private void addArticleClick(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/ajouterarticle.fxml"));
        Pane pane = Loader.load();
        AjouterarticleController ajoutzone = Loader.getController();
        ajoutzone.getid_boutique(labid.getText(),this);
        JFXDialogLayout content = new JFXDialogLayout();
         addArticleDialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(pane);
        content.setPrefSize(120, 200);
        addArticleDialog.show();
    }

    @FXML
    private void send_mail(ActionEvent event) {
        serviceMail sm = new serviceMail();
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXTextField from = new JFXTextField();
        JFXTextField to = new JFXTextField();
        JFXTextField object = new JFXTextField();
        JFXTextArea message = new JFXTextArea();
        JFXButton send = new JFXButton("envoyer");
        JFXButton ok = new JFXButton("ok");
        JFXButton Annuler = new JFXButton("annuler");
        send.setPrefWidth(80);
        Annuler.setPrefWidth(80);
        from.setText("De: " + labmail.getText());
        JFXPasswordField password = new JFXPasswordField();
        password.setPromptText("Mot de passe de votre compte");
        password.setPrefWidth(180);
        from.setEditable(false);
        from.setPrefWidth(180);
        to.setPromptText("Destinataire");
        to.setPrefWidth(180);
        object.setPromptText("Objet");
        object.setPrefWidth(180);
        message.setPromptText("Rédigez votre message...");
        message.setPrefSize(180, 200);

        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    JFXDialogLayout content = new JFXDialogLayout();
                    JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
                    ok.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                Mail m = new Mail(from.getText(), password.getText(), to.getText(), object.getText(), message.getText(), "smtp.gmail.com");
                                sm.sendMail(m);
                                dialog.close();

                            } catch (Exception ex) {
                                Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                    content.setPrefSize(200, 80);
                    content.setActions(password, ok);
                    dialog.show();

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
        content.setPrefSize(200, 200);
        content.setActions(from, to, object, message, send, Annuler);
        dialog.show();
    }

    @FXML
    private void notification_evenements(MouseEvent event) throws IOException {
        initialnotification();
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/EvenementItem.fxml"));
        Pane pane = Loader.load();
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(pane);
        content.setPrefSize(500, 210);
        dialog.show();
    }

    @FXML
    private void gestionEvents(ActionEvent event) throws IOException {

        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXButton ajouter = new JFXButton("Créer");
        JFXButton modifier = new JFXButton("Mes Evenements");
        ajouter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                    FXMLLoader Loader = new FXMLLoader();
                    Loader.setLocation(getClass().getResource("/GUI/ajouterevenements.fxml"));
                    Pane pane = Loader.load();
                    JFXDialogLayout content2 = new JFXDialogLayout();
                    JFXDialog dialog2 = new JFXDialog(interface_container, content2, JFXDialog.DialogTransition.CENTER);
                    AjouterevenementsController controller = Loader.<AjouterevenementsController>getController();
                    controller.loadBoutique(labid.getText());
                    content2.setHeading(new Text("Créer un évènement:"));
                    content2.setBody(pane);
                    content2.setPrefSize(120, 200);
                    dialog2.show();

                } catch (Exception ex) {
                    Logger.getLogger(VendeurinterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dialog.close();
                    FXMLLoader Loader = new FXMLLoader();
                    Loader.setLocation(getClass().getResource("/GUI/EvenementItemBoutique.fxml"));
                    Pane pane = Loader.load();

                    JFXDialogLayout content2 = new JFXDialogLayout();
                    JFXDialog dialog2 = new JFXDialog(interface_container, content2, JFXDialog.DialogTransition.CENTER);

                    EvenementItemBoutiqueController controller = Loader.<EvenementItemBoutiqueController>getController();
                    controller.loadboutique(labid.getText());
                    content2.setHeading(new Text("Modifier ou supprimer vos évènements:"));
                    content2.setBody(pane);
                    content2.setPrefSize(120, 200);
                    dialog2.show();
                } catch (Exception ex) {
                    Logger.getLogger(VendeurinterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        content.setBody(new Text("Gestion de vos évènements"));
        content.setActions(ajouter, modifier);
        content.setPrefSize(200, 50);
        dialog.show();
    }

    @FXML
    private void gestionNotifications(ActionEvent event) {
        try {
            initialnotification();
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/EvenementItem.fxml"));
            Pane pane = Loader.load();
            JFXDialogLayout content = new JFXDialogLayout();
            JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
            content.setBody(pane);
            content.setPrefSize(500, 210);
            dialog.show();
        } catch (IOException ex) {
            Logger.getLogger(VendeurinterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
