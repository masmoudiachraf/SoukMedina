/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

import java.util.Objects;

/**
 *
 * @author Hajer
 */
public class Categorie {
    int id_cat;
    String nom_cat;
 
     public Categorie()
    {
     
    }
    public Categorie(int id_cat,String nom_cat)
    {
        this.id_cat=id_cat;
        this.nom_cat=nom_cat;
    }
        public Categorie(int id_cat)
    {
        this.id_cat=id_cat;
       
    }
 
     
  public Categorie(String nom_cat)
    {
       
        this.nom_cat=nom_cat;
    }
    public int getId_cat() {
        return id_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

  

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }


    @Override
    public String toString() {
        return "categorie{" + "id_cat=" + id_cat + ", nom_cat=" + nom_cat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        if (this.id_cat != other.id_cat) {
            return false;
        }
        if (!Objects.equals(this.nom_cat, other.nom_cat)) {
            return false;
        }
        return true;
    }
    
    
}
