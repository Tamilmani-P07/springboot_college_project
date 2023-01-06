package com.kgisl.boot.college.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
    @Id
    private int id;
    private String u_name;
   
    public String getU_name() {
        return u_name;
    }
    public void setU_name(String u_name) {
        this.u_name = u_name;
    }
    private String pass;
    private String category;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Login [id=" + id + ", u_name=" + u_name + ", pass=" + pass + ", category=" + category + "]";
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    


    
   
   
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
