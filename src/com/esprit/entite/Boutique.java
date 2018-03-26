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
   private int id;
   private String nom_bout;
   private String adresse_bout;
   private int telephone_bout;
   private utilisateur user;

    public Boutique(int id) {
        this.id = id;
    }
    

    public Boutique() {
    }

    public Boutique(int id, String nom_bout, String adresse_bout, int telephone_bout, utilisateur user) {
        this.id = id;
        this.nom_bout = nom_bout;
        this.adresse_bout = adresse_bout;
        this.telephone_bout = telephone_bout;
        this.user = user;

    }

    public Boutique(String nom_bout, String adresse_bout, int telephone_bout, utilisateur user) {
        this.nom_bout = nom_bout;
        this.adresse_bout = adresse_bout;
        this.telephone_bout = telephone_bout;
        this.user = user;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_bout() {
        return nom_bout;
    }

    public void setNom_bout(String nom_bout) {
        this.nom_bout = nom_bout;
    }

    public utilisateur getUser() {
        return user;
    }

    public void setUser(utilisateur user) {
        this.user = user;
    }

    public String getAdresse_bout() {
        return adresse_bout;
    }

    public void setAdresse_bout(String adresse_bout) {
        this.adresse_bout = adresse_bout;
    }

    public int getTelephone_bout() {
        return telephone_bout;
    }

    public void setTelephone_bout(int telephone_bout) {
        this.telephone_bout = telephone_bout;
    }
   
    @Override
    public String toString() {
        return "Boutique{" + "id=" +id + ", nom_bout=" + nom_bout + ", adresse_bout=" + adresse_bout + ", telephone_bout=" + telephone_bout + ", userId= "+user.getId_uti()+"}";
    }
   
}
