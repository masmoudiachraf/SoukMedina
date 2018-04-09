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

/**
 *
 * @author iskander
 */
public class test {
    public static void main(String[] args) {
        /*serviceUtilisateur su=new serviceUtilisateur();
         utilisateur u=new utilisateur("ahmed", "ben ahmed", "achref@gmail.com", "123456789", "djerba", 20202020, "12/12/12");
         su.update_user(u,4833275);*/
        ServiceBoutique sb=new ServiceBoutique();
        Boutique b=new Boutique("showtime", "gafsa", "showtime@gmail.com", "123456789", 20202020, "artisanat");
        sb.update_boutique(b, 3);
         System.out.println("ok dki");
    }
    
}
