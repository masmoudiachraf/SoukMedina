/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.service;

import com.esprit.entite.articles;
import java.util.List;

/**
 *
 * @author Djoo
 */
public interface Iservicearticles {
    void insert_article(articles p);
    void delete(int id);
     void update(articles p,int id);
    List<articles> displayall(int id_bou);
     //articles displayall(int id_bou);
}
