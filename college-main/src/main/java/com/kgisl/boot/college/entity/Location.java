package com.kgisl.boot.college.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name ="location_id")
   private int location_id;
   @Column(name ="location_name")
   private String location_name;
   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinColumn(name = "location_id")
   private List<Student> all;
   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinColumn(name = "location_id")
   private List<College> sen;
  
   public List<College> getSen() {
    return sen;
}
public void setSen(List<College> sen) {
    this.sen = sen;
}
public int getLocation_id() {
        return location_id;
    }
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
    public String getLocation_name() {
        return location_name;
    }
    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }
    public List<Student> getAll() {
        return all;
    }
    public void setAll(List<Student> all) {
        this.all = all;
    }

}
