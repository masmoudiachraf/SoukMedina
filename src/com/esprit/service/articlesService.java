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
        String requete="insert into articles (nom_art,image_art,taille_art,couleur_art,prix_art,categorie_art,boutiques_fk) values ('"+p.getNom()+"','"+p.getImage()+"','"+p.getTaille()+"','"+p.getCouleur()+"','"+p.getPrix()+ "','"+p.getCategorie()+ "','"+p.getBoutique_fk().getId()+"')";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void delete(int id) {
         String requete="delete from articles where id_art ='"+id+"'";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

      @Override
    public void update(articles p, int id) {
         String requete="update articles set nom_art='"+p.getNom()+"' ,taille_art='"+p.getTaille()+"' , couleur_art='" +p.getCouleur()+"' , prix_art='" + p.getPrix()+"' ,categorie_art='"+p.getCategorie()+"' where id_art="+id;

          try {
              
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

   @Override
    public List<articles> displayall(int id_bou) {
                List<articles> list=new ArrayList<>();

           String requete="select * from articles where boutiques_fk='"+id_bou+"'";
        ResultSet rs;
         
 Boutique b= new Boutique(id_bou);
          try {
              
        
              st=cnx.createStatement();
               rs=st.executeQuery(requete);
             while(rs.next()){
                 b.setId(rs.getInt("boutiques_fk"));
            articles p=new articles(rs.getInt(1), rs.getString("nom_art") ,rs.getString("image_art"),rs.getString("taille_art"), rs.getString("couleur_art"), rs.getFloat("prix_art"),rs.getString("categorie_art"),b);
              list.add(p);
        }
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        return list;
                
    }
    /*    @Override
    public articles displayall(int id_bou) {
        articles a = null;
           String requete="select * from articles where boutiques_fk='"+id_bou+"'";
        ResultSet rs;
         
            Boutique b= new Boutique(id_bou);
          try {
              
        
              st=cnx.createStatement();
               rs=st.executeQuery(requete);
             while(rs.next()){
                 b.setId(rs.getInt("boutiques_fk"));
            articles p=new articles(rs.getInt(1), rs.getString("nom_art") ,rs.getString("taille_art"), rs.getString("couleur_art"), rs.getFloat("prix_art"),rs.getString("categorie_art"),b);
              a=p;
        }
          } catch (SQLException ex) {
              Logger.getLogger(articlesService.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        return a;
                
    }*/

  
    
}
