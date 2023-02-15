/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

//import com.sun.istack.internal.logging.Logger;
import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import utils.MyDB;

/**
 *
 * @author ousse
 */
public class ReclamationService {
    Connection connexion;
    Statement stm;

    public ReclamationService() {
        connexion = MyDB.getInstance().getConnexion();
    }

    public void ajouterp(Reclamation r) throws SQLException {
        String req = "INSERT INTO `reclamation` (`type_rec`, `Description`, `date`) VALUES ( '"
                + r.getType() + "', '" + r.getDescription() + "', '" + r.getDate() + "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);

    }
    public void modifierp(Reclamation r) throws SQLException {
        String req = "UPDATE `reclamation` SET type_rec = ? , Description = ? , Date = ? where id_r = ? ";
        //stm = connexion.createStatement();
        //stm.executeUpdate(req);
        PreparedStatement k=connexion.prepareStatement(req);
k.setString(1, r.getType() );
k.setString(2, r.getDescription() );
k.setDate(3, r.getDate() );
k.setInt(4, r.getId() );
k.executeUpdate();
    }
    public void modifierUser() throws SQLException {
        System.out.println("choisir l id de le user que vous voulez la modifier");
        Scanner sc= new Scanner(System.in);
        int id_r = sc.nextInt();
        sc.nextLine();
        System.out.println("tapez le numero du champ a modifier \n 1 : Type \n 2 : Description \n 2 : Date  ");
        int num_champ = sc.nextInt();
        sc.nextLine();
        switch (num_champ) {
    case 1:{
       
            System.out.println("saisir votre nouveau type");
        String nv_type = sc.nextLine();
        String req = "UPDATE reclamation SET type_rec = ? WHERE id_r = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_type);
         ps.setInt(2,id_r );
        int a= ps.executeUpdate();
        break;}
    case 2:{      
           System.out.println("saisir votre nouveau Description");
        String nv_Description = sc.nextLine();
        String req = "UPDATE reclamation SET Description = ? WHERE id_r = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_Description);
         ps.setInt(2,id_r );
        int a= ps.executeUpdate();
        break;}
        
    case 3:{      
           System.out.println("saisir votre nouveau Date");
        String nv_date = sc.nextLine();
        String req = "UPDATE reclamation SET date = ? WHERE id_r = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_date);
         ps.setInt(2,id_r );
        int a= ps.executeUpdate();
        break;}
        }
        }
     
    public void deletep(Reclamation r) throws SQLException {
  Scanner sc= new Scanner(System.in);
  int id_r=sc.nextInt();
    String query="DELETE FROM `reclamation` WHERE `id_r` =  "+id_r;
    stm = connexion.createStatement();
    stm.executeUpdate(query);
    }
    public void ajouterProduitPs(Reclamation r) throws SQLException {
        String req = "INSERT INTO `reclamation` (`type_rec`, `Description`, `date`) "
                + "VALUES ( ?, ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, r.getType());
        ps.setString(2, r.getDescription());
        ps.setDate(3, r.getDate());
        ps.executeUpdate();
    }

    public List<Reclamation> afficherReclamation() throws SQLException {
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "select * from reclamation";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Reclamation r = new Reclamation (rst.getInt("id_r"),//or rst.getInt(1)
                    rst.getString("type_rec"),
                    rst.getString("Description"),
                    rst.getDate("date"));
            reclamations.add(r);
        }
        return reclamations;
    }

    //private void getDate(String date) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

   
}
