/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Administator;
import com.esprit.entite.Boutique;
import com.esprit.utils.datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author masmo
 */
public class ServiceAdmin implements IServiceAdmin{
    PreparedStatement statement;
    Connection connection = datasource.getinstance().getCnx();

    @Override
    public void insert_admin(Administator admin) {
        try {
            String req = "insert into administateurs (nom,prnom,mail) values (?,?,?)";
            statement = connection.prepareStatement(req);
            statement.setString(1, admin.getNom());
            statement.setString(2, admin.getPrenom());
            statement.setString(3, admin.getMail());
            statement.setString(4, admin.getPassword());            
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }    
    }

    @Override
    public void delete_admin(Administator admin) {
        String req = "delete from administateurs where id=?";
        try {
            statement = connection.prepareStatement(req);
            statement.setInt(1, admin.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }    
    }

    @Override
    public void update_admin(Administator admin) {
        String req = "update administateurs SET nom=?,prnom=?,mail=?,password=? where id='"+admin.getId()+"'";
       try {
            statement = connection.prepareStatement(req);
            statement = connection.prepareStatement(req);
            statement.setString(1, admin.getNom());
            statement.setString(2, admin.getPrenom());
            statement.setString(3, admin.getMail());
            statement.setString(4, admin.getPassword());
            statement.setInt(5, admin.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public List<Administator> displayall_admin() {
        ArrayList<Administator> listAdministrators = new ArrayList<>();
        String req = "Select * from administateurs";
        try {
            statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                listAdministrators.add(new Administator(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return listAdministrators;
    }

    @Override
    public Administator loginAdmin(Administator admin) {
        Administator administrator = null;
        String req = "Select * from administateurs where mail='"+admin.getMail()+"' and password='"+admin.getPassword()+"' ";
        try {
            statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
                
                administrator = new Administator(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return administrator;

    }
    
}
