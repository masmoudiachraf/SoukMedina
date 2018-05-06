/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.service;

import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
import java.util.List;

/**
 *
 * @author Djoo
 */
public interface IservicePanier {
    void insert(Panier p);
    void delete(articles articles_fk);
    List<Panier> displayall(utilisateur utilisateur_fk);
    public Panier displayaSinglePanierEnAttente(utilisateur utilisateur_fk, articles articleDisplayed) ;
    public void editQuantitePanier(Panier panier);
    public void validerPanier(Panier panier);
}
