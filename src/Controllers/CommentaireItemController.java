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
            editCommentaireIv.setVisible(true);
            DeleteCommentaireIv.setVisible(true);
        }
        CommantaireText.setText(commentaire.getCommentaire());
        parentController = controller;
        this.commentaire = commentaire;
    }

    @FXML
    private void signalerProfileBtn(ActionEvent event) {
        if(user.getId_uti()!=UserInterfaceController.logedUser.getId_uti())
        {
            parentController.signalerProfile(user);
        }
    }
}
