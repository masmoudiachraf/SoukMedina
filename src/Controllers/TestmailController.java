/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.esprit.entite.Mail;
import com.esprit.entite.utilisateur;
import com.esprit.service.serviceMail;
import com.esprit.service.serviceUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * FXML Controller class
 *
 * @author iskander
 */
public class TestmailController implements Initializable {

    @FXML
    private JFXButton btnsend;
    @FXML
    private JFXTextField tffrom;
    @FXML
    private JFXTextField tfto;
    @FXML
    private JFXTextArea tatext;
    @FXML
    private JFXTextField tfsubject;
    @FXML
    private StackPane interface_container;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tffrom.setText("iskander.chikha@gmail.com");
    }    
    
    @FXML
    private void sendmail(ActionEvent event){
        serviceMail  sm=new serviceMail();
        JFXDialogLayout content = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(interface_container, content, JFXDialog.DialogTransition.CENTER);
        JFXPasswordField password = new JFXPasswordField();
        JFXButton ok = new JFXButton("OK");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    Mail m=new Mail(tffrom.getText(), password.getText(), tfto.getText(), tfsubject.getText(), tatext.getText(), "smtp.gmail.com");
                    sm.sendMail(m);
                    dialog.close();
                } catch (Exception ex) {
                    Logger.getLogger(TestmailController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        );
        content.setPrefSize(120, 200);
                content.setBody(new Text("mot de passe de votre compte Email"));
                content.setActions(password,ok);
                dialog.show();
        /*String smtphost="smtp.gmail.com";
        String from="iskander.chikha@gmail.com";
        String to="iskander.chikha@gmail.com";
        String username="iskander.chikha@gmail.com";
        String password="251681850092907";
        Properties props = new Properties();
        props.put("mail.smtp.host",smtphost);
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.socketFactory.port","465");
                props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                                        props.put("mail.smtp.port","465");

        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("testing javamail");
            message.setText("testing javamail");
            Transport tr=session.getTransport("smtp");
            tr.connect(smtphost, username, password);
            message.saveChanges();
            tr.sendMessage(message, message.getAllRecipients());*/
      /*  Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
                props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                        props.put("mail.smtp.auth","true");
                        props.put("mail.smtp.port","465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentification(){
                        return new javax.mail.PasswordAuthentication("iskander.chikha@gmail.com","251681850092907");
                    }});
        try {
            Message message =new MimeMessage(session);
            message.setFrom(new InternetAddress("iskander.chikha@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("iskander.chikha@gmail.com"));
            message.setSubject("testing javamail");
            message.setText("testing javamail");
            Transport.send(message);
            System.out.println("ok");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }*/

    }
    
}
