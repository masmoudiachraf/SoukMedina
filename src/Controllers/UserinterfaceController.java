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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author iskander
 */
public class UserinterfaceController implements Initializable {

    @FXML
    private Label labnom;
    @FXML
    private Label labprenom;
    @FXML
    private Label labmail;
    @FXML
    private Label labtelephone;
    @FXML
    private Label labadresse;
    @FXML
    private Label labnaissance;
    @FXML
    private Hyperlink linksetting;
    @FXML
    private Hyperlink linklogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void userinformation(String labnom, String labprenom, String labmail, String labtelephone, String labadresse, String labnaissance) {
        this.labnom.setText(labnom);
        this.labprenom.setText(labprenom);
        this.labmail.setText(labmail);
        this.labtelephone.setText(labtelephone);
        this.labadresse.setText(labadresse);
        this.labnaissance.setText(labnaissance);
    }
    
    
}
