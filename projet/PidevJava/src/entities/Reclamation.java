/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author macbook
 */
public class Reclamation {
    
    private int id_r;
    private String type_rec;
    private String description;
    private Date date ;

    public Reclamation(String type_rec, String description, Date date) {
        this.type_rec = type_rec;
        this.description = description;
        this.date = date;
    }
    public Reclamation(int id_r,String type_rec, String description, Date date) {
        this.id_r=id_r;
        this.type_rec = type_rec;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id_r;
    }

    public void setId(int id_r) {
        this.id_r = id_r;
    }

    public String getType() {
        return type_rec;
    }

    public void setType(String type_rec) {
        this.type_rec = type_rec;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id_r=" + id_r + ", type_rec=" + type_rec + ", description=" + description + ", date=" + date + '}';
    }
    
    
    
    
}
