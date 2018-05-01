/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

/**
 *
 * @author iskander
 */
public class Mail {
    private String from;
    private String password;
    private String to;
    private String object;
    private String message;
    private String smtpHost;

    public Mail() {
    }

    public Mail(String from, String password, String to, String object, String message, String smtpHost) {
        this.from = from;
        this.password = password;
        this.to = to;
        this.object = object;
        this.message = message;
        this.smtpHost=smtpHost;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    @Override
    public String toString() {
        return "Mail{" + "from=" + from + ", password=" + password + ", to=" + to + ", object=" + object + ", message=" + message + ", smtpHost=" + smtpHost + '}';
    }
    
    
    
    
    
   
    
}
