/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ousse
 * @param <T>
 */
public interface IReclamation<T> {
  
    public void ajouterp(T r) throws SQLException;
    public void deletep(T r) throws SQLException;
    public void modifierp(T r) throws SQLException;
    public void modifierUser() throws SQLException;
    public List<T> afficherReclamation() throws SQLException;
    
    
}
