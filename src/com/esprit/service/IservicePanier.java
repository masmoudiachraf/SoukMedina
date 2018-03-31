/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.service;

import com.esprit.entite.Panier;
import com.esprit.entite.Articles;
import com.esprit.entite.Utilisateur;
import java.util.List;

/**
 *
 * @author Djoo
 */
public interface IservicePanier {
    void insert(Panier p);
    void delete(Articles articles_fk);
    List<Panier> displayall(Utilisateur utilisateur_fk);
}
