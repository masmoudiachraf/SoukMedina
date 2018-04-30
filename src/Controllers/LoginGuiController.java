/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Administator;
import com.esprit.entite.Boutique;
import com.esprit.entite.utilisateur;
import com.esprit.service.ServiceAdmin;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.articlesService;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class LoginGuiController implements Initializable {

    ServiceBoutique sb = new ServiceBoutique();
    serviceUtilisateur su = new serviceUtilisateur();
    articlesService as = new articlesService();
    ServiceAdmin serviceAdmin = new ServiceAdmin();
    Administator admin = null;
    
    public static utilisateur logedUser = null;
    public static Boutique logedBoutique = null;
    public static Administator logedAdmin = null;
    @FXML
    private AnchorPane loginContainer;
    @FXML
    private ImageView LoginImage;
    @FXML
    private AnchorPane loginParent;
    @FXML
    private StackPane interface_container;
    @FXML
    private JFXTextField login_mailTf;
    @FXML
    private JFXPasswordField login_passTf;
    @FXML
    private JFXButton btnauthentifier;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void inscrir_tap(ActionEvent event) {

        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Mode"));
        content.setBody(new Text("Vous réprésentez un boutique ou vous êtes un simple utilisateur ?"));
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXButton btnUser = new JFXButton("Utilisateur");
        JFXButton btnBoutique = new JFXButton("Boutique");
        btnUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    start((Stage) btnUser.getScene().getWindow(), "/GUI/InscriptionUser.fxml");
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnBoutique.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    start((Stage) btnUser.getScene().getWindow(), "/GUI/InscriptionBoutique.fxml");
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        content.setActions(btnBoutique, btnUser);
        dialog.show();
    }

    @FXML
    private void authentification(ActionEvent event) throws IOException {
        
        String mail = login_mailTf.getText();
        String password = login_passTf.getText();

        if (login_mailTf.getText().equals("") || login_passTf.getText().equals("")) {
            JFXDialogLayout content = new JFXDialogLayout();
            content.setHeading(new Text("Mode"));
            content.setBody(new Text("Saisir vos informations! "));
            JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
            JFXButton btnalert = new JFXButton("OK");
            btnalert.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        dialog.close();
                    } catch (Exception ex) {
                        Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            content.setActions(btnalert);
            dialog.show();
        } else if (sb.display_b(mail, password).equals(mail + password)) {
            Boutique boutique = sb.displayboutique(mail, password);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/vendeurinterface.fxml"));
            AnchorPane pane = Loader.load();
            loginParent.getChildren().setAll(pane);
            VendeurinterfaceController boutiquecontroller = Loader.getController();
            boutiquecontroller.logedBoutique = boutique;
            boutiquecontroller.boutiqueinformation(String.valueOf(boutique.getId()), boutique.getNom_bout(), boutique.getMail_bout(),boutique.getPassword_bout(), boutique.getAdresse_bout(), String.valueOf(boutique.getTelephone_bout()), boutique.getActivite_bout());
            boutiquecontroller.userinformation(String.valueOf(boutique.getId()));
        } else if (su.display_u(mail, password).equals(mail + password)) {
            utilisateur user = su.displayall(mail, password);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/UserInterface.fxml"));
            AnchorPane pane = Loader.load();
            loginParent.getChildren().setAll(pane);
            UserInterfaceController userzone = Loader.getController();
            userzone.logedUser = user;
            userzone.userinformation(String.valueOf(user.getId_uti()), user.getNom_uti(), user.getPrenom_uti(), user.getMail_uti(), user.getPassword_uti(), user.getAdresse_uti(), String.valueOf(user.getTelephone_uti()), user.getNaissance_uti());

        }else if (serviceAdmin.loginAdmin(new Administator(mail, password)) != null) {
            Administator admin = serviceAdmin.loginAdmin(new Administator(mail, password));
            logedAdmin = admin;
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/GUI/admin.fxml"));
            Pane pane = Loader.load();
            loginParent.getChildren().setAll(pane);
            AdminController userzone = Loader.getController();
            //userzone.userinformation(String.valueOf(user.getId_uti()), user.getNom_uti(), user.getPrenom_uti(), user.getMail_uti(), user.getPassword_uti(), user.getAdresse_uti(), String.valueOf(user.getTelephone_uti()), user.getNaissance_uti());
        }else {
            JFXDialogLayout content = new JFXDialogLayout();
            content.setHeading(new Text("Mode"));
            content.setBody(new Text("verifier votre mail et password "));
            JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
            JFXButton btnalert = new JFXButton("OK");
            btnalert.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        dialog.close();
                    } catch (Exception ex) {
                        Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            content.setActions(btnalert);
            dialog.show();

        }
    }

    /**
     *
     * @param window
     * @param destination
     * @throws Exception
     */
    public void start(Stage window, String destination) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }
}


/*

 */
