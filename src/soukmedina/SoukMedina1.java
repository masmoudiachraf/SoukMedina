/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soukmedina;


import com.esprit.entite.Boutique;
import com.esprit.entite.utilisateur;
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
        /*serviceUtilisateur su=new serviceUtilisateur();
        
        ServiceBoutique sb=new ServiceBoutique();
        utilisateur user = new utilisateur();
        user.setId_uti(1);
        Boutique b=new Boutique("test","sfax", 12345678,user);
        sb.insert_boutique(b);
        utilisateur u=new utilisateur("hajer","mejri","hajer@gmail.com","123456789","vendeur", "sfax", 77777777,"01/01/2010",1);
        su.insert_user(u);
        
        //su.displayall().forEach(System.out::println);
        
        //su.delete_user("mohamed@gmail.com", "aaaaaaaaa");
        su.displayutilisateur("hajer    @gmail.com");
        //su.update_user(u,"eya@gmail.com");
        System.out.println("Ok!!");*/
    }
    
}
