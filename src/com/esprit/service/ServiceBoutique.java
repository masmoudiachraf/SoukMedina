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
public class ServiceBoutique implements IService<Boutique>{
    
    PreparedStatement statement;
    Connection connection = datasource.getinstance().getCnx();

    @Override
    public void insert(Boutique t) {
          try {
            String req = "insert into boutiques (nom_bout,adresse_bout,telephone_bout,articles_fk) values (?,?,?,?)";
            statement = connection.prepareStatement(req);
            statement.setString(1, t.getNom());
            statement.setString(2, t.getAdresse());
            statement.setInt(3, t.getTelephone());
            statement.setInt(4, t.getUser().getId_uti());
            statement.executeUpdate();
        } catch (SQLException ex) {
              System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(Boutique t) {
        String req = "delete from boutiques where id=?";
        try {
            statement = connection.prepareStatement(req);
            statement.setInt(1, t.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void update(Boutique t) {
        String req = "update boutiques SET nom_bout=?,adresse_bout=?,telephone_bout=?,articles_fk=?) where id=?";
        try {
            statement = connection.prepareStatement(req);
            statement.setString(1, t.getNom());
            statement.setString(2, t.getAdresse());
            statement.setInt(3, t.getTelephone());
            statement.setInt(4, t.getUser().getId_uti());
            statement.setInt(3, t.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public List<Boutique> SelectAll() {
         ArrayList<Boutique> listBoutiques = new ArrayList<>();
        String req = "Select * from boutiques";
        try {
            statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
                utilisateur  user = new utilisateur();
                user.setId_uti(rs.getInt(5));
                listBoutiques.add(new Boutique(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),user));
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return listBoutiques;
    }

    @Override
    public Boutique SelectSingle(int i) {
        String req = "Select * from personne";
        Boutique boutique = null;
        try {
            statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
                utilisateur  user = new utilisateur();
                user.setId_uti(rs.getInt(5));
                boutique= new Boutique(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return boutique;
    }
    
}
