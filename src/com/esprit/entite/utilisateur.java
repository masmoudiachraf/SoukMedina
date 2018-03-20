/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

import java.util.List;

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
    private String role_uti;
    private String adresse_uti;
    private int telephone_uti;
    private String naissance_uti;

    public utilisateur() {
    }

    public utilisateur(int id_uti, String nom_uti, String prenom_uti, String mail_uti, String password_uti, String role_uti, String adresse_uti, int telephone_uti, String naissance_uti) {
        this.id_uti = id_uti;
        this.nom_uti = nom_uti;
        this.prenom_uti = prenom_uti;
        this.mail_uti = mail_uti;
        this.password_uti = password_uti;
        this.role_uti = role_uti;
        this.adresse_uti = adresse_uti;
        this.telephone_uti = telephone_uti;
        this.naissance_uti = naissance_uti;
    }

    public utilisateur(String nom_uti, String prenom_uti, String mail_uti, String password_uti, String role_uti, String adresse_uti, int telephone_uti, String naissance_uti) {
        this.nom_uti = nom_uti;
        this.prenom_uti = prenom_uti;
        this.mail_uti = mail_uti;
        this.password_uti = password_uti;
        this.role_uti = role_uti;
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

    public String getRole_uti() {
        return role_uti;
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

    @Override
    public String toString() {
        return "utilisateur " + id_uti + "\n \t nom: " + nom_uti + "\n \t prenom: " + prenom_uti + "\n \t mail: " + mail_uti + "\n \t password : " + password_uti + "\n \t role: " + role_uti + "\n \t adresse: " + adresse_uti + "\n \t telephone: " + telephone_uti + "\n \t naissance: " + naissance_uti ;
    }
    
    

    
    
    
}
