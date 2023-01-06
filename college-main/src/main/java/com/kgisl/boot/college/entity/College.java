package com.kgisl.boot.college.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class College {
    @Id
    private int c_id;
    private String c_name;
    public int getC_id() {
        return c_id;
    }
    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public String getC_address() {
        return c_address;
    }
    public void setC_address(String c_address) {
        this.c_address = c_address;
    }
    public int getC_ratings() {
        return c_ratings;
    }
    public void setC_ratings(int c_ratings) {
        this.c_ratings = c_ratings;
    }
    public int getC_fees() {
        return c_fees;
    }
    public void setC_fees(int c_fees) {
        this.c_fees = c_fees;
    }
    public List<CourseSelection> getAll() {
        return all;
    }
    public void setAll(List<CourseSelection> all) {
        this.all = all;
    }
    private String c_address;
    private int c_ratings;
    private int c_fees;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @JoinColumn(name = "c_id")
   private List<CourseSelection> all;
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", updatable = false, insertable = true)
    private Location location;
}
