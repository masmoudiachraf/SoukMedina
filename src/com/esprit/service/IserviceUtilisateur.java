/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;


import com.esprit.entite.Boutique;
import com.esprit.entite.utilisateur;
import java.util.List;

/**
 *
 * @author iskander
 */
public interface IserviceUtilisateur {
 void insert_user(utilisateur usr);
    void delete_user(String mail,String password);
     void update_user(utilisateur usr, String mail);
    List<utilisateur> displayall();
    String displayutilisateur(String mail);
<<<<<<< HEAD
=======
    String display_u(String mail,String password);
>>>>>>> 8d4ba8d58b48de5dcd99d177497c118754d0ad84

}
