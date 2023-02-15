/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevjava;

import entities.Reclamation;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ReclamationService;


/**
 *
 * @author macbook
 */
public class PidevJava {

    /**
     * @param args the command lineou arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        Date dateR = new Date(21/02/2020);
        Reclamation r = new Reclamation("Technique","test1",dateR);
        Reclamation r1 = new Reclamation("Livraison","test2",dateR);
        //Reclamation p2 = new Reclamation("mahjoubi","oussema");
        //Reclamation p3 = new Reclamation("badreddine","ala");
        ReclamationService sp = new ReclamationService();
        
        try {
            sp.modifierp(new Reclamation("Technique","test1",dateR));
            sp.modifierp(new Reclamation("Livraison","test2",dateR));
            System.out.println("modification avec succes");
           //sp.ajouterp(r);
           //sp.ajouterp(r1);
           //sp.ajouterp(r2);
           //sp.ajouterp(p3);
           //System.out.println("ajout avec succes");
           //System.out.println(sp.afficherReclamation());
           //System.out.println("voulez vous supprimer quelqu'un ?");
           //Scanner sc= new Scanner(System.in);
            //String a=sc.nextLine();
            //String s1="oui";
            //if(a.equals(s1)){
              //  System.out.println("donner son id : ");
           //sp.deletep(r);
            //System.out.println("suppression avec succes");}
            sp.modifierUser();
            
           
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            System.out.println(sp.afficherReclamation());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
