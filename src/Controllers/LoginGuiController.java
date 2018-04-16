/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.articlesService;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.java.swing.plaf.windows.resources.windows;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class LoginGuiController implements Initializable {

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
        content.setActions(btnBoutique,btnUser);
        dialog.show();
    }
 

    @FXML
    private void authentification(ActionEvent event) throws IOException {
         ServiceBoutique sb= new ServiceBoutique();
           serviceUtilisateur su= new serviceUtilisateur();
           articlesService as=new articlesService();
           String mail= login_mailTf.getText();
            String password= login_passTf.getText();    
               
            if(login_mailTf.getText().equals("") || login_passTf.getText().equals(""))
            {
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
        }
            
           else if(sb.display_b(mail,password).equals(mail+password)){
               FXMLLoader Loader= new FXMLLoader();
               Loader.setLocation(getClass().getResource("/GUI/vendeurinterface.fxml"));
            AnchorPane pane=Loader.load();
            loginParent.getChildren().setAll(pane); 
            VendeurinterfaceController userzone= Loader.getController();
            
            userzone.userinformation(String.valueOf(sb.displayboutique(mail, password).getId()), sb.displayboutique(mail, password).getNom_bout(), sb.displayboutique(mail, password).getMail_bout(),sb.displayboutique(mail, password).getPassword_bout(), sb.displayboutique(mail, password).getAdresse_bout(), String.valueOf(sb.displayboutique(mail, password).getTelephone_bout()), sb.displayboutique(mail, password).getActivite_bout());
            }
        else
        if (su.display_u(mail, password).equals(mail+password))
        {  FXMLLoader Loader= new FXMLLoader();
           Loader.setLocation(getClass().getResource("/GUI/.fxml"));
            try {
                Loader.load();
                
            } catch (IOException e) {
                Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, e);
            }
            Parent p=Loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(p));
            stage.show();
            //VendeurinterfaceController userzone= Loader.getController();
            //userzone.userinformation(String.valueOf(su.displayall(mail, password).getId_uti()),su.displayall(mail, password).getNom_uti(),su.displayall(mail, password).getPrenom_uti(),su.displayall(mail, password).getMail_uti(),su.displayall(mail, password).getPassword_uti(),su.displayall(mail, password).getAdresse_uti(),String.valueOf(su.displayall(mail, password).getTelephone_uti()),su.displayall(mail, password).getNaissance_uti());
          
            
        }
        
        else
        {
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
        Scene scene =  new Scene(FXMLLoader.load(getClass().getResource(destination)));
        window.setScene(scene);
        window.show();
    }
}


/*

*/

