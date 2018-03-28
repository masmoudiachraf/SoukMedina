/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soukmedina;

import com.esprit.entite.Boutique;
import com.esprit.entite.Panier;
import com.esprit.entite.articles;
import com.esprit.entite.categorie;
import com.esprit.entite.utilisateur;
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
        
        //serviceUtilisateur su=new serviceUtilisateur();
        //ServiceBoutique sb=new ServiceBoutique();
       // sb.displayall_boutique().forEach(System.out::println);
       PanierService p = new PanierService();
        categorie cat = new categorie();
        Boutique bout = new Boutique();
        cat.setId_cat(1);
        bout.setId(1);
        articles art = new articles(1, "t_shirt","small", "black",40, cat,bout);
        articlesService a= new articlesService();
        a.insert_article(art);
    }
    
}
