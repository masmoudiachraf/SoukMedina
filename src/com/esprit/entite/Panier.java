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
   private int id;
   private utilisateur utilisateurs_fk;
   private articles articles_fk;
   private int quantite;
   private int etat_panier;
  
   
    public Panier() {};

   public Panier(utilisateur utilisateurs_fk,articles articles_fk,int quantite, int etat_panier)
   {
       this.utilisateurs_fk=utilisateurs_fk;
       this.articles_fk=articles_fk;
       this.quantite=quantite;
       this.etat_panier=etat_panier;
    }

    public Panier(int id, utilisateur utilisateurs_fk, articles articles_fk, int quantite, int etat_panier) {
        this.id = id;
        this.utilisateurs_fk = utilisateurs_fk;
        this.articles_fk = articles_fk;
        this.quantite = quantite;
        this.etat_panier = etat_panier;
    }
   

    public utilisateur getUtilisateurs_fk() {
        return utilisateurs_fk;
    }

    public articles getArticles_fk() {
        return articles_fk;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getEtat_panier() {
        return etat_panier;
    }
    
    @Override
    public String toString() {
        return "Panier{ id="+id + "utilisateurs_fk=" + utilisateurs_fk.getId_uti() + ", articles_fk=" + articles_fk.getId() + ", quantite=" + quantite + ", etat_panier=" + etat_panier + '}';
    }

    public void setUtilisateurs_fk(utilisateur utilisateurs_fk) {
        this.utilisateurs_fk = utilisateurs_fk;
    }

    public void setArticles_fk(articles articles_fk) {
        this.articles_fk = articles_fk;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setEtat_panier(int etat_panier) {
        this.etat_panier = etat_panier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
    

   
  
   
    
}
