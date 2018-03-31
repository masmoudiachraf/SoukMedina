/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soukmedina;

import com.esprit.entite.Boutique;
import com.esprit.entite.Panier;
import com.esprit.entite.Articles;
import com.esprit.entite.Categorie;
import com.esprit.entite.Utilisateur;
import com.esprit.service.PanierService;
import com.esprit.service.ServiceBoutique;
import com.esprit.service.articlesService;
import com.esprit.service.serviceUtilisateur;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author masmo
 */
public class SoukMedina extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        serviceUtilisateur su=new serviceUtilisateur();
        //ServiceBoutique sb=new ServiceBoutique();
       // sb.displayall_boutique().forEach(System.out::println);
       PanierService p = new PanierService();
       // categorie cat = new categorie();
      //  Boutique bout = new Boutique();
        Utilisateur u= new Utilisateur();
        Articles ar= new Articles();
        u.setId_uti(1);
        ar.setId(1);
       // cat.setId_cat(1);
       // bout.setId(1);
        //articles art = new articles();
        //articlesService a= new articlesService();
       Panier p1= new Panier(u, ar,2 , "In hold");
       // p.insert(p1);
        p.displayall(u).forEach(System.out::println);
    }
    
}
