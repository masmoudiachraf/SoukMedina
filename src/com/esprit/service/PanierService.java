/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
import com.esprit.utils.datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djoo
 */
public class PanierService implements IservicePanier {

    private Connection cnx;
    private Statement st;
    private PreparedStatement pst;

    public PanierService() {
        cnx = datasource.getinstance().getCnx();
    }

    @Override
    public void insert(Panier p) {
        String requete = "insert into panier (utilisateurs_fk,articles_fk,quantite,etat) values ('" + p.getUtilisateurs_fk().getId_uti() + "','" + p.getArticles_fk().getId() + "','" + p.getQuantite() + "'," + p.getEtat_panier() + ")";
        try {
            st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(articles articles_fk) {
        String requete = "delete from panier where articles_fk = '" + articles_fk.getId() + "'   ";

        try {
            st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Panier> displayall(utilisateur utilisateur_fk) {
        List<Panier> list = new ArrayList<>();

        String requete = "select * from panier where utilisateurs_fk=" + utilisateur_fk.getId_uti();
        ResultSet rs;
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(requete);
            while (rs.next()) {
                articles article = new articles();
                utilisateur user = new utilisateur();
                article.setId(rs.getInt("articles_fk"));
                user.setId_uti(rs.getInt("utilisateurs_fk"));
                Panier p = new Panier(rs.getInt("id"),user, article, rs.getInt("quantite"), rs.getInt("etat"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    @Override
    public Panier displayaSinglePanierEnAttente(utilisateur utilisateur_fk, articles articleDisplayed) {
        Panier p = null;

        String requete = "select * from panier where utilisateurs_fk=" + utilisateur_fk.getId_uti()
                + " AND articles_fk=" + articleDisplayed.getId() + " AND etat=0";
        ResultSet rs;
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(requete);
            while (rs.next()) {
                articles article = new articles();
                utilisateur user = new utilisateur();
                article.setId(rs.getInt("articles_fk"));
                user.setId_uti(rs.getInt("utilisateurs_fk"));
                p = new Panier(rs.getInt("id"),user, article, rs.getInt("quantite"), rs.getInt("etat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public void editQuantitePanier(Panier panier) {
        String req = "update panier SET quantite=" + panier.getQuantite() + " where id='" + panier.getId() + "'";
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void validerPanier(Panier panier) {
                String req = "update panier SET etat=1 where id='" + panier.getId() + "'";
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

}
