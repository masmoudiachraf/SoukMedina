/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;


import com.esprit.entite.Boutique;
import com.esprit.entite.utilisateur;
import com.esprit.utils.datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iskander
 */
public class serviceUtilisateur implements IserviceUtilisateur{
     private Connection cnx;
    private Statement st;
    private PreparedStatement pst;

    public serviceUtilisateur() {
        cnx = datasource.getinstance().getCnx();
    }

    @Override
    public void insert_user(utilisateur usr) {
        String requete="insert into utilisateurs (nom_uti,prenom_uti,mail_uti,password_uti,adresse_uti,telephone_uti,naissance_uti) values ('"+usr.getNom_uti()+"','"+usr.getPrenom_uti()+"','"+usr.getMail_uti()+"','"+usr.getPassword_uti()+"','"+usr.getAdresse_uti()+"','"+usr.getTelephone_uti()+"','"+usr.getNaissance_uti()+"')";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(serviceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void delete_user(String mail, String password) {
        String requete="delete from utilisateurs where mail_uti = '"+mail+"' and password_uti = '"+password+"'   ";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(serviceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void update_user(utilisateur usr, String mail) {
        String requete="update utilisateurs set nom_uti='"+usr.getNom_uti()+"', prenom_uti='"+usr.getPrenom_uti()+"', mail_uti='"+usr.getMail_uti()+"', password_uti='"+usr.getPassword_uti()+"', adresse_uti='"+usr.getAdresse_uti()+"', telephone_uti='"+usr.getTelephone_uti()+"', naissance_uti='"+usr.getNaissance_uti()+"' where mail_uti='"+mail+"' ";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(serviceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public List<utilisateur> displayall() {
        List<utilisateur> list=new ArrayList<>();

           String requete="select * from utilisateurs";
        ResultSet rs;
          try {
              st=cnx.createStatement();
               rs=st.executeQuery(requete);
             while(rs.next()){
            utilisateur usr=new utilisateur(rs.getInt("id_uti"), rs.getString("nom_uti"), rs.getString("prenom_uti"),rs.getString("mail_uti"), rs.getString("password_uti"),rs.getString("adresse_uti"),rs.getInt("telephone_uti"),rs.getString("naissance_uti"));
              list.add(usr);
        }
          } catch (SQLException ex) {
              Logger.getLogger(utilisateur.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        return list;
    }

    @Override
    public void displayutilisateur(String mail) {
        utilisateur u=new utilisateur();
        String requete="select * from utilisateurs where mail_uti= '"+mail+"'";
        ResultSet rs;
          try {
              st=cnx.createStatement();
               rs=st.executeQuery(requete);
             while(rs.next()){
            utilisateur usr=new utilisateur(rs.getInt("id_uti"), rs.getString("nom_uti"), rs.getString("prenom_uti"),rs.getString("mail_uti"), rs.getString("password_uti"), rs.getString("adresse_uti"),rs.getInt("telephone_uti"),rs.getString("naissance_uti"));
                 System.out.println(usr);
             }
          } catch (SQLException ex) {
              Logger.getLogger(utilisateur.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public utilisateur display_u(String mail, String password) {
        String req= "select * from boutiques where mail_uti='"+mail+"' and password_uti='"+password+"'";
    utilisateur util=null;
                 try {
            st = cnx.prepareStatement(req);
            ResultSet rs = st.executeQuery(req);
          while (rs.next()) {
                
               util= new utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
            }
   
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
          return util;
            
           }

   

    
    
    
}
