/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soukmedina;


import com.esprit.entite.Boutique;
import com.esprit.entite.Utilisateur;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.serviceUtilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author iskander
 */
public class SoukMedina1 {

    /**
     * @param args the command line arguments
     */
    private static Connection cnx;
    private static Statement st;
    private static PreparedStatement pst;
    
    public static void main(String[] args) {
        int x;
        serviceUtilisateur su=new serviceUtilisateur();
        
        //ServiceBoutique sb=new ServiceBoutique();
        Utilisateur user = new Utilisateur();
        //user.setId_uti(1);
        //Boutique b=new Boutique("test","sfax", 12345678,user);
        //sb.insert_boutique(b);
        Utilisateur u=new Utilisateur("iskander","chikhaoui","iskander@gmail.com","123456789","vendeur", "tunis", 123456789,"01/01/2010");
        //su.insert_user(u);
        
        //su.displayall().forEach(System.out::println);
        
        su.delete_user("mejrihajer18@gmail.com", "hajer");
        su.displayutilisateur("iskander@gmail.com");
        //su.update_user(u,"eya@gmail.com");
        System.out.println("Ok!!");
    }
    
}
