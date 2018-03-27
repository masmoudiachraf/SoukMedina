package com.esprit.entite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Djoo
 */
public class articles {
    
    private int id ;
    private String nom;
    private String taille;
    private String couleur;
    private float prix;
    private categorie categorie_fk;
    private Boutique boutique_fk;
    
    public articles() {};

    public articles(int id, String nom, String taille, String couleur, float prix, categorie categorie_fk,Boutique boutique_fk) {
        this.id = id;
        this.nom = nom;
        this.taille = taille;
        this.couleur = couleur;
        this.prix = prix;
        this.categorie_fk = categorie_fk;
        this.boutique_fk=boutique_fk;
    }
   

    public articles(String nom, String taille, String couleur, float prix, categorie categorie_fk,Boutique boutique_fk) {
        this.nom = nom;
        this.taille = taille;
        this.couleur = couleur;
        this.prix = prix;
        this.categorie_fk = categorie_fk;
        this.boutique_fk=boutique_fk;
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getTaille() {
        return taille;
    }

    public Boutique getBoutique_fk() {
        return boutique_fk;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setBoutique_fk(Boutique boutique_fk) {
        this.boutique_fk = boutique_fk;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public categorie getCategorie_fk() {
        return categorie_fk;
    }

    public void setCategorie_fk(categorie categorie_fk) {
        this.categorie_fk = categorie_fk;
    }
    

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
 /*   public String toString() {
         return  "id=" + id + ", nom=" + nom + ", taille=" + taille +", couleur=" + couleur + ", prix=" + prix ;
    }*/

    
    public String toString() {
        return "articles{" + "id=" + id + ", nom=" + nom + ", taille=" + taille + ", couleur=" + couleur + ", prix=" + prix + ", categorie_fk=" + categorie_fk + ", boutique_fk=" + boutique_fk + '}';
    }
    
    

  
    
}
