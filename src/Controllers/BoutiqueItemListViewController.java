
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
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
public class BoutiqueItemListViewController implements Initializable {

    UserInterfaceController parentController;
    
    @FXML
    private ImageView boutiqueItemImageView;
    @FXML
    private Label boutiqueItemLabel;
    @FXML
    private AnchorPane boutiqueItemAnchorContainer;
    @FXML
    private AnchorPane AnchorContainerItem;

    Boutique boutique;
    @FXML
    private ImageView boutiqueDetails;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AnchorContainerItem.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                parentController.refresharticleFlowPane(boutique.getId());
            }
        });
        
    }    
    
    public void loadBoutique(Boutique boutique, UserInterfaceController controller){
        boutiqueItemLabel.setText(boutique.getNom_bout());
        parentController = controller;
        this.boutique = boutique;
    }


    @FXML
    private void details_boutiques(MouseEvent event) throws IOException {
        parentController.detailBoutiquePopup(boutique);
    }

    
    
}
