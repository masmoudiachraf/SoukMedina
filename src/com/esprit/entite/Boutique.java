/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author masmo
 */
public class Boutique {
   private int id;
   private String nom_bout;
   private String adresse_bout;
   private String mail_bout ;
   private String password_bout ;
   private int telephone_bout;
   private String activite_bout ;

    public Boutique(int id) {
        this.id = id;
    }
    

    public Boutique() {
    }

    public Boutique(int id, String nom_bout, String adresse_bout, String mail_bout, String password_bout, int telephone_bout, String activite_bout) {
        this.id = id;
        this.nom_bout = nom_bout;
        this.adresse_bout = adresse_bout;
        this.mail_bout = mail_bout;
        this.password_bout = password_bout;
        this.telephone_bout = telephone_bout;
        this.activite_bout = activite_bout;
    }

    public Boutique(String nom_bout, String adresse_bout, String mail_bout, String password_bout, int telephone_bout, String activite_bout) {
        this.nom_bout = nom_bout;
        this.adresse_bout = adresse_bout;
        this.mail_bout = mail_bout;
        this.password_bout = password_bout;
        this.telephone_bout = telephone_bout;
        this.activite_bout = activite_bout;
    }

    public int getId() {
        return id;
    }

    public String getNom_bout() {
        return nom_bout;
    }

    public String getAdresse_bout() {
        return adresse_bout;
    }

    public String getMail_bout() {
        return mail_bout;
    }

    public String getPassword_bout() {
        return password_bout;
    }

    public int getTelephone_bout() {
        return telephone_bout;
    }

    public String getActivite_bout() {
        return activite_bout;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_bout(String nom_bout) {
        this.nom_bout = nom_bout;
    }

    public void setAdresse_bout(String adresse_bout) {
        this.adresse_bout = adresse_bout;
    }

    public void setMail_bout(String mail_bout) {
        this.mail_bout = mail_bout;
    }

    public void setPassword_bout(String password_bout) {
        this.password_bout = password_bout;
    }

    public void setTelephone_bout(int telephone_bout) {
        this.telephone_bout = telephone_bout;
    }

    public void setActivite_bout(String activite_bout) {
        this.activite_bout = activite_bout;
    }


   

    @Override
    public String toString() {
        return "Boutique{" + "id=" + id + ", nom_bout=" + nom_bout + ", adresse_bout=" + adresse_bout + ", mail_bout=" + mail_bout + ", password_bout=" + password_bout + ", telephone_bout=" + telephone_bout + ", activite_bout=" + activite_bout + '}';
    }
    
    
 


}
