package com.kgisl.boot.college.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private int s_id;
    @Column(name = "s_name")
    private String s_name;
    @Column(name = "s_address")
    private String s_address;
    @Column(name = "s_mark")
    private int s_mark;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name ="s_id")
	private List<Application> all;


    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", updatable = false, insertable = true)
    private Location location;


    public int getS_id() {
        return s_id;
    }
    public void setS_id(int s_id) {
        this.s_id = s_id;
    }
    public String getS_name() {
        return s_name;
    }
    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
    public String getS_address() {
        return s_address;
    }
    public void setS_address(String s_address) {
        this.s_address = s_address;
    }
    public int getS_mark() {
        return s_mark;
    }
    public void setS_mark(int s_mark) {
        this.s_mark = s_mark;
    }
   
    
}
