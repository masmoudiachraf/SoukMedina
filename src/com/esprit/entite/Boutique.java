/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

/**
 *
 * @author masmo
 */
public class Boutique {
    int id;
    String nom;
    String adresse;
    int telephone;
    utilisateur user;

    public Boutique() {
    }

    public Boutique(String nom, String adresse, int telephone, utilisateur user) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.user = user;
    }

    public Boutique(int id, String nom, String adresse, int telephone, utilisateur user) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public utilisateur getUser() {
        return user;
    }

    public void setUser(utilisateur user) {
        this.user = user;
    }

   
    
}
