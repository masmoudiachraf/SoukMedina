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
    
    private int id_panier ;
    private String etat_panier;
    private articles articles_fk;
   
    
    public Panier() {};

    public Panier(int id_panier, String etat_panier, articles articles_fk) {
        this.id_panier = id_panier;
        this.etat_panier = etat_panier;
        this.articles_fk = articles_fk;
    }

    public Panier(String etat_panier, articles articles_fk) {
        this.etat_panier = etat_panier;
        this.articles_fk = articles_fk;
    }

    public int getId_panier() {
        return id_panier;
    }

    public String getEtat_panier() {
        return etat_panier;
    }

    public articles getArticles_fk() {
        return articles_fk;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public void setEtat_panier(String etat_panier) {
        this.etat_panier = etat_panier;
    }

    public void setArticles_fk(articles articles_fk) {
        this.articles_fk = articles_fk;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", etat_panier=" + etat_panier + ", articles_fk=" + articles_fk + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id_panier;
        hash = 71 * hash + Objects.hashCode(this.etat_panier);
        hash = 71 * hash + Objects.hashCode(this.articles_fk);
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
        final Panier other = (Panier) obj;
        if (this.id_panier != other.id_panier) {
            return false;
        }
        if (!Objects.equals(this.etat_panier, other.etat_panier)) {
            return false;
        }
        if (!Objects.equals(this.articles_fk, other.articles_fk)) {
            return false;
        }
        return true;
    }
    
   
    
}
