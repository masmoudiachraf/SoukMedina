/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Boutique;
import java.util.List;

/**
 *
 * @author masmo
 */
public interface IserviceBoutique {
    void insert_boutique(Boutique bou);
    void delete_boutique(Boutique bou,int id);
     void update_boutique(Boutique bou, int id);
    List<Boutique> displayall_boutique();
    Boutique displayboutique(String mail,String password);
    Boutique displaySingleboutique(int id);
      String display_b(String mail,String password);
    //public void ajouterBoutique(Boutique b);
}
