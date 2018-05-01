/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;


import com.esprit.entite.utilisateur;
import java.util.List;

/**
 *
 * @author iskander
 */
public interface IserviceUtilisateur {
 void insert_user(utilisateur usr);
    void delete_user(utilisateur usr);
     void update_user(utilisateur usr, int id);
     void update_user_signial(utilisateur usr, int id);
    utilisateur displayall(String mail,String password);
    List<utilisateur> display_user_signial();
    String displayutilisateur(String mail);
    String display_u(String mail,String password);
    utilisateur selectSingleUtilisateur(int id);
}
