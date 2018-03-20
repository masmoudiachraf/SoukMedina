/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.service;


import com.esprit.entite.Panier;
import com.esprit.entite.articles;
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
public class PanierService implements IservicePanier{
      private Connection cnx;
    private Statement st;
    private PreparedStatement pst;

    public PanierService() {
        cnx = datasource.getinstance().getCnx();
    }

    @Override
    public void insert(Panier p) {
        String requete="insert into panier (id_panier,etat_panier) values ('"+p.getId_panier()+"','"+p.getEtat_panier()+"')";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void delete(int id_panier) {
         String requete="delete from panier where id_panier = '"+id_panier+"'   ";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    public void update(Panier p, int id_panier) {
         String requete="update panier set etat_panier='"+p.getEtat_panier()+"' where id_panier='"+ id_panier +"'  ";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public List<Panier> displayall() {
                List<Panier> list=new ArrayList<>();

           String requete="select * from panier";
        ResultSet rs;
          try {
              st=cnx.createStatement();
               rs=st.executeQuery(requete);
             while(rs.next()){
                 articles article= new articles();
                 article.setId(rs.getInt("id_art"));
            Panier p=new Panier(rs.getInt(1), rs.getString("etat_panier"), article);
              list.add(p);
        }
          } catch (SQLException ex) {
              Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        return list;
                
    }

  
    
}
