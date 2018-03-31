/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.service;

import com.esprit.entite.Articles;
import java.util.List;

/**
 *
 * @author Djoo
 */
public interface Iservicearticles {
    void insert_article(Articles p);
    void delete(int id);
     void update(Articles p,int id);
    List<Articles> displayall();
}
