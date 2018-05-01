/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Administator;
import com.esprit.entite.Commentaire;
import com.esprit.entite.articles;
import java.util.List;

/**
 *
 * @author masmo
 */
public interface IServiceCommentaire {
    void insertCommentaire(Commentaire commentaire);
    void deleteCommentaire(Commentaire commentaire);
    void updateCommentaire(Commentaire commentaire);
    List<Commentaire> displayallCommentaire(articles article);
}
