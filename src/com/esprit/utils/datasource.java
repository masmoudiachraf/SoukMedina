/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import soukmedina.SoukMedina;

/**
 *
 * @author Hajer
 */
public class datasource {
      private static final String login="root";
     private static final String pwd="";
      private static final String url="jdbc:mysql://127.0.0.1:3306/soukmedina";
      private static Connection cnx;
      private static Statement st;
      private static PreparedStatement pst;
      private static datasource instance;
      private datasource()
      {
               try {
            // TODO code application logic here
            cnx=DriverManager.getConnection(url, login, pwd);      
         
            
        } catch (SQLException ex) {
            Logger.getLogger(SoukMedina.class.getName()).log(Level.SEVERE, null, ex);
        
        }
      }
       public static datasource getinstance(){
          if(instance == null)
              instance=new datasource();
          return instance;
          
      }

    public static Connection getCnx() {
        return cnx;
    }

    
}
