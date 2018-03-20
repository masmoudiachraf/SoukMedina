/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.categorie;
import java.util.List;

/**
 *
 * @author Hajer
 */
public interface Icategorieservice {
    void insert(categorie c);
    void delete(int id);
    void update (categorie c,int id);
   List<categorie> displayall();
 
}
