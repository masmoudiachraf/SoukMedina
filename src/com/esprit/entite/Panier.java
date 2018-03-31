package com.esprit.entite;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Djoo
 */
public class Panier {
   private Utilisateur utilisateurs_fk;
   private Articles articles_fk;
   private int quantite;
   private String etat_panier;
   
   
    
    public Panier() {};

   public Panier(Utilisateur utilisateurs_fk,Articles articles_fk,int quantite, String etat_panier)
   {
       this.utilisateurs_fk=utilisateurs_fk;
       this.articles_fk=articles_fk;
       this.quantite=quantite;
       this.etat_panier=etat_panier;
               }

    public Utilisateur getUtilisateurs_fk() {
        return utilisateurs_fk;
    }

    public Articles getArticles_fk() {
        return articles_fk;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getEtat_panier() {
        return etat_panier;
    }

    @Override
    public String toString() {
        return "Panier{" + "utilisateurs_fk=" + utilisateurs_fk.getId_uti() + ", articles_fk=" + articles_fk.getId() + ", quantite=" + quantite + ", etat_panier=" + etat_panier + '}';
    }

    public void setUtilisateurs_fk(Utilisateur utilisateurs_fk) {
        this.utilisateurs_fk = utilisateurs_fk;
    }

    public void setArticles_fk(Articles articles_fk) {
        this.articles_fk = articles_fk;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setEtat_panier(String etat_panier) {
        this.etat_panier = etat_panier;
    }


    
    

   
  
   
    
}
