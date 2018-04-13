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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author masmo
 */
public class ServiceBoutique implements IserviceBoutique{
    PreparedStatement statement;
    Connection connection = datasource.getinstance().getCnx();

    @Override
    public void insert_boutique(Boutique t) {
        try {
            String req = "insert into boutiques (nom_bout,mail_bout,password_bout,adresse_bout,telephone_bout,activite_bout) values (?,?,?,?,?,?)";
            statement = connection.prepareStatement(req);
            statement.setString(1, t.getNom_bout());
            statement.setString(2, t.getMail_bout());
            statement.setString(3, t.getPassword_bout());
            statement.setString(4, t.getAdresse_bout());
            statement.setInt(5, t.getTelephone_bout());
             statement.setString(6, t.getActivite_bout());
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }    
    }

    @Override
    public void delete_boutique(Boutique t ,int id) {
        String req = "delete from boutiques where id=?";
        try {
            statement = connection.prepareStatement(req);
            statement.setInt(1, t.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }    
    }

    @Override
    public void update_boutique(Boutique t , int id) {
        String req = "update boutiques SET nom_bout=?,mail_bout=?,password_bout=?,adresse_bout=?,telephone_bout=?,activite_bout=? where id_bout='"+id+"'";
       try {
            statement = connection.prepareStatement(req);
            statement = connection.prepareStatement(req);
            statement.setString(1, t.getNom_bout());
            statement.setString(2, t.getMail_bout());
            statement.setString(3, t.getPassword_bout());
            statement.setString(4, t.getAdresse_bout());
            statement.setInt(5, t.getTelephone_bout());
            statement.setString(6, t.getActivite_bout());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    
    public List<Boutique> displayall_boutique() {
         ArrayList<Boutique> listBoutiques = new ArrayList<>();
        String req = "Select * from boutiques";
        try {
            statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
               
                listBoutiques.add(new Boutique(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7)));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return listBoutiques;
    }

    @Override
    public Boutique displayboutique(String mail,String password ) {
        Boutique bout=new Boutique();
        String req = "Select * from boutiques where mail_bout='"+mail+"' and password_bout='"+password+"' ";
        try {
            statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
                
                Boutique bou= new Boutique(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
                bout=bou;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return bout;
    }

    @Override
    public String display_b(String mail,String password) {
        String req= "select * from boutiques where mail_bout='"+mail+"' and password_bout='"+password+"'";
        String ch="";
        try {
            statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery(req);
          while (rs.next()) {
                
                Boutique bou= new Boutique(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
                ch=bou.getMail_bout()+bou.getPassword_bout();
                return ch;
          }
   
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        
            return ch;

}

   
}
