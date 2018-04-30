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
public class Commentaire {
    
    int id;
    utilisateur user;
    articles article;
    String commentaire;

    public Commentaire(int id, utilisateur user, articles article, String commentaire) {
        this.id = id;
        this.user = user;
        this.article = article;
        this.commentaire = commentaire;
    }

    public Commentaire(utilisateur user, articles article, String commentaire) {
        this.user = user;
        this.article = article;
        this.commentaire = commentaire;
    }

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public utilisateur getUser() {
        return user;
    }

    public void setUser(utilisateur user) {
        this.user = user;
    }

    public articles getArticle() {
        return article;
    }

    public void setArticle(articles article) {
        this.article = article;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
}
