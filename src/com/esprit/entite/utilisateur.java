/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author iskander
 */
public class utilisateur {
    private int id_uti;
    private String nom_uti;
    private String prenom_uti;
    private String mail_uti;
    private String password_uti;
    private String adresse_uti;
    private int telephone_uti;
    private String naissance_uti;

    public utilisateur() {
    }

    public utilisateur(int id_uti, String nom_uti, String prenom_uti, String mail_uti, String password_uti, String adresse_uti, int telephone_uti, String naissance_uti) {
        this.id_uti = id_uti;
        this.nom_uti = nom_uti;
        this.prenom_uti = prenom_uti;
        this.mail_uti = mail_uti;
        this.password_uti = password_uti;
        this.adresse_uti = adresse_uti;
        this.telephone_uti = telephone_uti;
        this.naissance_uti = naissance_uti;
    }

    public utilisateur(String nom_uti, String prenom_uti, String mail_uti, String password_uti, String adresse_uti, int telephone_uti, String naissance_uti) {
        this.nom_uti = nom_uti;
        this.prenom_uti = prenom_uti;
        this.mail_uti = mail_uti;
        this.password_uti = password_uti;
        this.adresse_uti = adresse_uti;
        this.telephone_uti = telephone_uti;
        this.naissance_uti = naissance_uti;
    }
    
    
    
    public int getId_uti() {
        return id_uti;
    }

    public String getNom_uti() {
        return nom_uti;
    }

    public String getPrenom_uti() {
        return prenom_uti;
    }

    public String getMail_uti() {
        return mail_uti;
    }

    public String getPassword_uti() {
        return password_uti;
    }



    public String getAdresse_uti() {
        return adresse_uti;
    }

    public int getTelephone_uti() {
        return telephone_uti;
    }

    public String getNaissance_uti() {
        return naissance_uti;
    }

    public void setId_uti(int id_uti) {
        this.id_uti = id_uti;
    }

    public void setNom_uti(String nom_uti) {
        this.nom_uti = nom_uti;
    }

    public void setPrenom_uti(String prenom_uti) {
        this.prenom_uti = prenom_uti;
    }

    public void setMail_uti(String mail_uti) {
        this.mail_uti = mail_uti;
    }

    public void setPassword_uti(String password_uti) {
        this.password_uti = password_uti;
    }


    public void setAdresse_uti(String adresse_uti) {
        this.adresse_uti = adresse_uti;
    }

    public void setTelephone_uti(int telephone_uti) {
        this.telephone_uti = telephone_uti;
    }

    public void setNaissance_uti(String naissance_uti) {
        this.naissance_uti = naissance_uti;
    }

    @Override
    public String toString() {
        return id_uti +" "+ nom_uti +" "+  prenom_uti +" "+ mail_uti +" "+password_uti +" "+ adresse_uti +" "+ telephone_uti +" "+  naissance_uti ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_uti;
        hash = 97 * hash + Objects.hashCode(this.nom_uti);
        hash = 97 * hash + Objects.hashCode(this.prenom_uti);
        hash = 97 * hash + Objects.hashCode(this.mail_uti);
        hash = 97 * hash + Objects.hashCode(this.password_uti);
        hash = 97 * hash + Objects.hashCode(this.adresse_uti);
        hash = 97 * hash + this.telephone_uti;
        hash = 97 * hash + Objects.hashCode(this.naissance_uti);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final utilisateur other = (utilisateur) obj;
        if (this.id_uti != other.id_uti) {
            return false;
        }
        if (this.telephone_uti != other.telephone_uti) {
            return false;
        }
        if (!Objects.equals(this.nom_uti, other.nom_uti)) {
            return false;
        }
        if (!Objects.equals(this.prenom_uti, other.prenom_uti)) {
            return false;
        }
        if (!Objects.equals(this.mail_uti, other.mail_uti)) {
            return false;
        }
        if (!Objects.equals(this.password_uti, other.password_uti)) {
            return false;
        }
        if (!Objects.equals(this.adresse_uti, other.adresse_uti)) {
            return false;
        }
        if (!Objects.equals(this.naissance_uti, other.naissance_uti)) {
            return false;
        }
        return true;
    }

    

    
    

    
    
    
}
