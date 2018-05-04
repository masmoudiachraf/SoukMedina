/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Evenements;
import java.util.List;

/**
 *
 * @author iskander
 */
public interface IserviceEvenement {
    void insert_events(Evenements events);
    void delete_events(int id);
     void update_events(Evenements events, int id);
     List<Evenements> display_events();
  List<Evenements> display_events(int id_bou);
  
}
