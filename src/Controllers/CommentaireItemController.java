/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.Commentaire;
import com.esprit.entite.utilisateur;
import com.esprit.service.ServiceCommentaire;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author masmo
 */
public class CommentaireItemController implements Initializable {

    ArticleInterfaceController parentController;
    Commentaire commentaire;
    utilisateur user;
    serviceUtilisateur serviceUser = new serviceUtilisateur();

    @FXML
    private ImageView editCommentaireIv;
    @FXML
    private ImageView DeleteCommentaireIv;
    @FXML
    private Hyperlink userName;
    @FXML
    private Label CommantaireText;
    @FXML
    private AnchorPane commentaireContainer;
    @FXML
    private ImageView signialimv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         editCommentaireIv.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                parentController.editCommentaire(commentaire);
            }
        });
         
          DeleteCommentaireIv.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                parentController.DeleteCommentaire(commentaire);
            }
        });
    }    
    
      public void loadBoutique(Commentaire commentaire, ArticleInterfaceController controller){
        user = serviceUser.selectSingleUtilisateur(commentaire.getUser().getId_uti());
        userName.setText(user.getNom_uti()+" "+user.getPrenom_uti());
        if(user.getId_uti()==UserInterfaceController.logedUser.getId_uti())
        {
            signialimv.setVisible(false);
        }
        else
            {
            editCommentaireIv.setVisible(false);
            DeleteCommentaireIv.setVisible(false);
        
        }
        CommantaireText.setText(commentaire.getCommentaire());
        parentController = controller;
        this.commentaire = commentaire;
    }



    @FXML
    private void signialer_user_click(MouseEvent event) {
        if(user.getId_uti()!=UserInterfaceController.logedUser.getId_uti())
        {
            parentController.signalerProfile(user);

        }
        signialimv.setVisible(false);
    }
}
