/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Administator;
import java.util.List;

/**
 *
 * @author masmo
 */
public interface IServiceAdmin {
    void insert_admin(Administator admin);
    void delete_admin(Administator admin);
    void update_admin(Administator admin);
    List<Administator> displayall_admin();
    Administator loginAdmin(Administator admin);
}
