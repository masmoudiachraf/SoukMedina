/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Boutique;
import com.esprit.entite.Evenements;
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
 * @author iskander
 */
public class ServiceEvenements implements IserviceEvenement{
private Connection cnx;
    private Statement st;
    private PreparedStatement pst;

    public ServiceEvenements() {
        cnx = datasource.getinstance().getCnx();
    }
    
    @Override
    public void insert_events(Evenements events) {
        String requete = "insert into evenements (objet_event,description_event,adresse_event,dateDeb_event,dateFin_event,boutique_fk) values ('" + events.getObject_event() + "','" + events.getDescription_event()+ "','" + events.getAdresse_event()+ "','" + events.getDateDeb_event() + "','" + events.getDateFin_event() + "','" + events.getBoutique_fk().getId() + "')";

        try {
            st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete_events(int id) {
        String requete="delete from evenements where id_event = '"+id+"'   ";
   
          try {
              st=cnx.createStatement();
              st.executeUpdate(requete);
          } catch (SQLException ex) {
              Logger.getLogger(ServiceEvenements.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void update_events(Evenements events, int id) {
        String requete = "update evenements set objet_event='" + events.getObject_event() + "', description_event='" + events.getDescription_event() + "', adresse_event='" + events.getAdresse_event() + "', dateDeb_event='" + events.getDateDeb_event() + "',dateFin_event='" + events.getDateFin_event() + "' where id_event = '" + id+"' ";

        try {
            st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Evenements> display_events(int id_bou) {
        List<Evenements> list = new ArrayList<>();
        String requete = "select * from evenements where boutique_fk='"+id_bou+"' ";
        ResultSet rs;
        Boutique b=new Boutique();
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(requete);
            
            while (rs.next()) {
               b.setId(rs.getInt("boutique_fk"));
                Evenements usr = new Evenements(rs.getInt("id_event"), rs.getString("objet_event"), rs.getString("description_event"), rs.getString("adresse_event"), rs.getString("dateDeb_event"), rs.getString("dateFin_event"),b);
                list.add(usr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenements.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    @Override
    public List<Evenements> display_events() {
        List<Evenements> list = new ArrayList<>();
        String requete = "select * from evenements  ";
        ResultSet rs;
        
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(requete);
            
            while (rs.next()) {
                Boutique b=new Boutique();
               b.setId(rs.getInt("boutique_fk"));
                Evenements usr = new Evenements(rs.getInt("id_event"), rs.getString("objet_event"), rs.getString("description_event"), rs.getString("adresse_event"), rs.getString("dateDeb_event"), rs.getString("dateFin_event"),b);
                //System.out.println("nnnnn "+b);
                list.add(usr);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
