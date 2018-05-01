/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Mail;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author iskander
 */
public class serviceMail implements IserviceMail{

    @Override
    public void sendMail(Mail m)  throws Exception{
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port","465");

        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(m.getFrom()));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(m.getTo()));
        message.setSubject(m.getObject());
            message.setText(m.getMessage());
            Transport tr=session.getTransport("smtp");
            tr.connect(m.getSmtpHost(), m.getFrom(), m.getPassword());
            message.saveChanges();
            tr.sendMessage(message, message.getAllRecipients());
    }
    
}
