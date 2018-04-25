/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entite.Mail;

/**
 *
 * @author iskander
 */
public interface IserviceMail {
    void sendMail(Mail m) throws Exception;
}
