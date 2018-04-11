/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.utilisateur;
import com.esprit.service.serviceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class AdminController implements Initializable {

    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?,?> id_uti;
    @FXML
     private TableColumn<?,?> nom_uti;
    @FXML
      private TableColumn<?,?> prenom_uti;
    @FXML
       private TableColumn<?,?> mail_uti;
    @FXML
       private TableColumn<?,?> password_uti;
    @FXML
        private TableColumn<?,?> adresse_uti;
    @FXML
         private TableColumn<?,?> telephone_uti;
    @FXML
         private TableColumn<?,?> naissance_uti;
    @FXML
    private Button Inserer_boutique;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        serviceUtilisateur su = new serviceUtilisateur();
         ArrayList arraylist = (ArrayList) su.displayall();
        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tableview.setItems(obs);
          id_uti.setCellValueFactory(new PropertyValueFactory<>("id_uti"));
        nom_uti.setCellValueFactory(new PropertyValueFactory<>("nom_uti"));
        prenom_uti.setCellValueFactory(new PropertyValueFactory<>("prenom_uti"));
        mail_uti.setCellValueFactory(new PropertyValueFactory<>("mail_uti"));
        password_uti.setCellValueFactory(new PropertyValueFactory<>("password_uti"));
        adresse_uti.setCellValueFactory(new PropertyValueFactory<>("adresse_uti"));
       telephone_uti.setCellValueFactory(new PropertyValueFactory<>("telephone_uti"));
        
          
    }    

    @FXML
    private void Inserer_boutique(ActionEvent event) {
        FXMLLoader Loader= new FXMLLoader();
       Loader.setLocation(getClass().getResource("/GUI/InscriptionBoutique.fxml"));
            try {
                Loader.load();
                
            } catch (IOException e) {
                Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, e);
            }
            Parent p=Loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(p));
            stage.show();
            

    }
   
    
    
}
