/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Boutique;
import com.esprit.entite.utilisateur;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.serviceUtilisateur;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.FileOutputStream;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class AdminController implements Initializable {
      List<utilisateur> arraylist;
      List<Boutique> arraylist1;
      List<utilisateur> arraylist2;

    @FXML
    private TableView<?> tableview;
   
    @FXML
     private TableColumn<?,?> nom_uti;
    @FXML
      private TableColumn<?,?> prenom_uti;
    @FXML
       private TableColumn<?,?> mail_uti;      
    @FXML
        private TableColumn<?,?> adresse_uti;
    @FXML
         private TableColumn<?,?> telephone_uti;
    @FXML
         private TableColumn<?,?> naissance_uti;
   
    @FXML
    private TableView<?> tableview1;
    @FXML   
  
    private TableColumn<?, ?> nom_bout;
    @FXML
    private TableColumn<?, ?> mail_bout;
    
    @FXML
    private TableColumn<?, ?> adresse_bout;
    @FXML
    private TableColumn<?, ?> telephone_bout;
    @FXML
    private TableColumn<?, ?> activite_bout;
    @FXML
    private AnchorPane barSide;
    @FXML
    private AnchorPane anchorHeader;
    @FXML
    private Hyperlink linklogout;
    @FXML
    private Hyperlink linklogout1;
    @FXML
    private JFXButton userBtn;
    @FXML
    private JFXButton boutiqueBtn;
    @FXML
    private StackPane stackPaneContainer;
    @FXML
    private Button Export_to_pdf;
    @FXML
    private JFXButton userBtn2;
    @FXML
    private TableView<?> tableview2;
    @FXML
    private TableColumn<?, ?> nom_uti2;
    @FXML
    private TableColumn<?, ?> prenom_uti2;
    @FXML
    private TableColumn<?, ?> mail_uti2;
    @FXML
    private TableColumn<?, ?> adresse_uti2;
    @FXML
    private TableColumn<?, ?> telephone_uti2;
    @FXML
    private TableColumn<?, ?> naissance_uti2;
    @FXML
    private Button btnsupp;
    
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnsupp.setVisible(false);
        serviceUtilisateur su = new serviceUtilisateur();
          arraylist = (ArrayList) su.displayall1();
        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tableview.setItems(obs);
        nom_uti.setCellValueFactory(new PropertyValueFactory<>("nom_uti"));
        prenom_uti.setCellValueFactory(new PropertyValueFactory<>("prenom_uti"));
        mail_uti.setCellValueFactory(new PropertyValueFactory<>("mail_uti"));
        adresse_uti.setCellValueFactory(new PropertyValueFactory<>("adresse_uti"));
        telephone_uti.setCellValueFactory(new PropertyValueFactory<>("telephone_uti"));
        naissance_uti.setCellValueFactory(new PropertyValueFactory<>("naissance_uti"));
       
        ServiceBoutique sb = new ServiceBoutique();
        arraylist1 = (ArrayList) sb.displayall_boutique();
           ObservableList obs1 = FXCollections.observableArrayList(arraylist1);
           tableview1.setItems(obs1);
           nom_bout.setCellValueFactory(new PropertyValueFactory<>("nom_bout"));
           mail_bout.setCellValueFactory(new PropertyValueFactory<>("mail_bout"));
          adresse_bout.setCellValueFactory(new PropertyValueFactory<>("adresse_bout"));
        telephone_bout.setCellValueFactory(new PropertyValueFactory<>("telephone_bout"));
          activite_bout.setCellValueFactory(new PropertyValueFactory<>("activite_bout"));
          
        
          arraylist2 = (ArrayList) su.display_user_signial();
        ObservableList obs2 = FXCollections.observableArrayList(arraylist2);
        tableview2.setItems(obs2);
        nom_uti2.setCellValueFactory(new PropertyValueFactory<>("nom_uti"));
        prenom_uti2.setCellValueFactory(new PropertyValueFactory<>("prenom_uti"));
        mail_uti2.setCellValueFactory(new PropertyValueFactory<>("mail_uti"));
        adresse_uti2.setCellValueFactory(new PropertyValueFactory<>("adresse_uti"));
        telephone_uti2.setCellValueFactory(new PropertyValueFactory<>("telephone_uti"));
        naissance_uti2.setCellValueFactory(new PropertyValueFactory<>("naissance_uti"));
    } 
    @FXML
    private void diplayUsers(ActionEvent event) {
        tableview.setVisible(true);
        tableview1.setVisible(false);
        tableview2.setVisible(false);
        btnsupp.setVisible(false);
      
    }

    @FXML
    private void displayBoutiqe(ActionEvent event) {
        tableview2.setVisible(false);
        tableview.setVisible(false);
        tableview1.setVisible(true);
        btnsupp.setVisible(false);
   
    }
    @FXML
    private void diplayUsers_signialer(ActionEvent event) {
        tableview.setVisible(false);
        tableview1.setVisible(false);
        tableview2.setVisible(true);
        btnsupp.setVisible(true);
    }
    @FXML
    private void supprimer_signialer_users(ActionEvent event) {
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(stackPaneContainer, content, JFXDialog.DialogTransition.CENTER);
        content.setBody(new Text("Voullez vous supprimer les utilisateurs signialer?"));
        JFXButton oui=new JFXButton("oui");
        JFXButton non=new JFXButton("non");
        oui.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    serviceUtilisateur su = new serviceUtilisateur();
                      for(utilisateur users:arraylist2){
                        su.delete_user(users);
        }
        tableview2.getColumns().clear();
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        non.setOnAction(
                new EventHandler<ActionEvent>() {
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
        content.setActions(oui,non);
        dialog.show();
        
    }

    @FXML
    private void Export_to_pdf(ActionEvent event) throws Exception {
        
        int u=arraylist.size();
        int b=arraylist1.size();
        
        String path="";
        JFileChooser J = new JFileChooser();
        J.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
          int x=  J.showSaveDialog(J);
         if (x==JFileChooser.APPROVE_OPTION)
            {
              path = J.getSelectedFile().getPath();
            }   
      
      
        Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
        Font bf12 = new Font(FontFamily.TIMES_ROMAN, 10);       
       Document doc = new Document();
       PdfWriter.getInstance(doc,new FileOutputStream(path+".pdf"));
            doc.open();
            Paragraph paragraph = new Paragraph("Le ......./......./..................\n\n\nLes nombres d'utilisateurs: "+u+"\nLes nombres des boutiques: "+b);
            float[] columnWidths = {2f, 2f, 4f, 2f, 2f, 2f};
            PdfPTable table= new PdfPTable(columnWidths);
            table.setWidthPercentage(100f);
            insertCell(table, "Les utilisateurs:", Element.ALIGN_CENTER, 6, bfBold12);
            insertCell(table, "Nom", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Prénom", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Email", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Adresse", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Téléphone", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Date de Naissnce", Element.ALIGN_LEFT, 1, bfBold12);
            for( utilisateur usrs :arraylist){
            insertCell(table,usrs.getNom_uti() , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table,usrs.getPrenom_uti() , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table,usrs.getMail_uti() , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table, usrs.getAdresse_uti(), Element.ALIGN_LEFT, 1, bf12);
            insertCell(table,Integer.toString(usrs.getTelephone_uti()) , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table,usrs.getNaissance_uti() , Element.ALIGN_LEFT, 1, bf12);       
           
            }
            insertCell(table, "Les Boutiques:", Element.ALIGN_CENTER, 6, bfBold12);
            insertCell(table, "Nom", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Email", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Adresse", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Téléphone", Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, "Activité", Element.ALIGN_LEFT, 2, bfBold12);
            for( Boutique bouts :arraylist1){
            insertCell(table,bouts.getNom_bout() , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table,bouts.getMail_bout() , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table,bouts.getAdresse_bout() , Element.ALIGN_LEFT, 1, bf12);
            insertCell(table,Integer.toHexString(bouts.getTelephone_bout()), Element.ALIGN_LEFT, 1, bf12);
            insertCell(table,bouts.getActivite_bout() , Element.ALIGN_LEFT, 2, bf12);
           
            }
            paragraph.add(table);
            doc.add(paragraph);
            doc.close();
           
   
    }
    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
            PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
            cell.setHorizontalAlignment(align);
            cell.setColspan(colspan);
            if(text.trim().equalsIgnoreCase("")){
            cell.setMinimumHeight(10f);
                }
            table.addCell(cell);
    }        

    

    
}


