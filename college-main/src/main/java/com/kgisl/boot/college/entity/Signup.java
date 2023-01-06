package com.kgisl.boot.college.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Signup
 */
@Entity
@Table(name = "signup")
public class Signup {
    @Id
    int id;
    String u_name;
    String pass;
     String category;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getU_name() {
        return u_name;
    }
    public void setU_name(String u_name) {
        this.u_name = u_name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
        
    }
    @Override
    public String toString() {
        return "Signup [id=" + id + ", u_name=" + u_name + ", pass=" + pass + ", category=" + category + "]";
    }

    
}