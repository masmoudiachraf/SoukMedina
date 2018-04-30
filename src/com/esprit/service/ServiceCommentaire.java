/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Administator;
import com.esprit.entite.Commentaire;
import com.esprit.entite.articles;
import com.esprit.entite.utilisateur;
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
public class ServiceCommentaire implements IServiceCommentaire{
    PreparedStatement statement;
    Connection connection = datasource.getinstance().getCnx();

    @Override
    public void insertCommentaire(Commentaire commentaire) {
         try {
            String req = "insert into commentaires (id_article,id_user,commentaire) values (?,?,?)";
            statement = connection.prepareStatement(req);
            statement.setInt(1, commentaire.getArticle().getId());
            statement.setInt(2, commentaire.getUser().getId_uti());
            statement.setString(3, commentaire.getCommentaire());
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }    
    }

    @Override
    public void deleteCommentaire(Commentaire commentaire) {
        String req = "delete from commentaires where id=?";
        try {
            statement = connection.prepareStatement(req);
            statement.setInt(1, commentaire.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }    
    }

    @Override
    public void updateCommentaire(Commentaire commentaire) {
                String req = "update commentaires SET commentaire=? where id='"+commentaire.getId()+"'";
       try {
            statement = connection.prepareStatement(req);
            statement = connection.prepareStatement(req);
            statement.setString(1, commentaire.getCommentaire());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    @Override
    public List<Commentaire> displayallCommentaire(articles article) {
        ArrayList<Commentaire> listCommentaires = new ArrayList<>();
        String req = "Select * from commentaires Where id_article="+article.getId();
        try {
            statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                articles articl =  new articles();
                utilisateur user = new utilisateur();
                articl.setId(rs.getInt(2));
                user.setId_uti(rs.getInt(3));
                listCommentaires.add(new Commentaire(rs.getInt(1), user, articl,rs.getString(4)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return listCommentaires;

    }
    
}
