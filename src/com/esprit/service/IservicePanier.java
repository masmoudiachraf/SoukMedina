/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.service;

import com.esprit.entite.Panier;
import java.util.List;

/**
 *
 * @author Djoo
 */
public interface IservicePanier {
    void insert(Panier p);
    void delete(int id);
     void update(Panier p,int id);
    List<Panier> displayall();
}
