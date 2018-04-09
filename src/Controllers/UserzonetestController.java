/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class UserzonetestController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private Label labnom;
    @FXML
    private Label labprenom;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfpassword;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tftelephone;
    @FXML
    private TextField tfnaissance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void binvenuerecuperer(String labnom, String labprenom){
        this.labnom.setText(labnom);
        this.labprenom.setText(labprenom);
    }
    public void usercompte(String tfid,String tfnom,String tfprenom,String tfmail,String tfpassword,String tfadresse,String tftelephone,String tfnaissance){
          this.tfid.setText(tfid);
            this.tfnom.setText(tfnom);
          this.tfprenom.setText(tfprenom);
          this.tfmail.setText(tfmail);
          this.tfpassword.setText(tfpassword);
          this.tfadresse.setText(tfadresse);
          this.tftelephone.setText(tftelephone);
          this.tfnaissance.setText(tfnaissance);
          
    }

    
}
