/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Categorie;
import com.esprit.utils.DataSource;
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
 * @author Hajer
 */
public class servicecategorie implements Icategorieservice{
private  Connection cnx;
          private  Statement st;
      private  PreparedStatement pst;
    private int id_cat;
public servicecategorie()
{
      {
          cnx=DataSource.getinstance().getCnx();
      }
}
    @Override
    public void insert(Categorie c) {
          try {
            String requete="insert into categories (id_cat,nom_cat) values ('"+c.getId_cat()+"','"+c.getNom_cat()+"')";
            st=cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(servicecategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @Override
    public void delete(int id) {
        String requete="delete from categories where id_cat=?";
        try {
            pst=cnx.prepareStatement(requete);
            pst.setInt(1,id);
            pst.executeUpdate();
           // System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(servicecategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Categorie c, int id) {
     String requete ="update categories set nom_cat='"+c.getNom_cat()+"' where id_cat='"+id+"'";
        try {
            st=cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(servicecategorie.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<Categorie> displayall() {
           List<Categorie> liste=new ArrayList<>();
        String requete="select * from categories ";      
          ResultSet rs  ;
        try {       
            st=cnx.createStatement();
            rs= st.executeQuery(requete);
            while(rs.next())
    {
        Categorie c =new Categorie(rs.getInt(1), rs.getString("nom_cat"));
    liste.add(c);
    }
        } catch (SQLException ex) {
            Logger.getLogger(servicecategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
      return liste;  
       }
    
}
