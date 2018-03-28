/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.service;


import com.esprit.entite.Boutique;
import com.esprit.entite.articles;
import com.esprit.entite.categorie;
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
public class articlesService implements Iservicearticles{
      private Connection cnx;
    private Statement st;
    private PreparedStatement pst;

    public articlesService() {
        cnx = datasource.getinstance().getCnx();
    }



    @Override
    public void insert_article(articles p) {
        String requete="insert into articles (nom_art,taille_art,couleur_art,prix_art,categorie_fk,boutiques_fk) values ('"+p.getNom()+"','"+p.getTaille()+"','"+p.getCouleur()+"','"+p.getPrix()+ "','"+p.getCategorie_fk().getId_cat()+ "','"+p.getBoutique_fk().getId()+"')";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void delete(int id) {
         String requete="delete from articles where id_art ="+id;
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    public void update(articles p, int id) {
         String requete="update articles set nom_art='"+p.getNom()+"' , taille_art='"+p.getTaille()+"' , couleur_art='" +p.getCouleur()+"' , prix_art='" + p.getPrix()+"' where id_art="+id;

          try {
              
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public List<articles> displayall() {
                List<articles> list=new ArrayList<>();

           String requete="select * from articles";
        ResultSet rs;
         categorie c = new categorie();
 Boutique b= new Boutique();
          try {
              
        
              st=cnx.createStatement();
               rs=st.executeQuery(requete);
             while(rs.next()){
                       c.setId_cat(rs.getInt("categorie_fk"));
                 b.setId(rs.getInt("boutique_fk"));
            articles p=new articles(rs.getInt(1), rs.getString("nom_art") ,rs.getString("taille_art"), rs.getString("couleur_art"), rs.getFloat("prix_art"),c,b);
              list.add(p);
        }
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        return list;
                
    }

  
    
}
