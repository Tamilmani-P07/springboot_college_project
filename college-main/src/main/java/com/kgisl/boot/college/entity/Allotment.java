package com.kgisl.boot.college.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "allotment")

public class Allotment {
    @Id    
    @Column(name = "ALLOTMENT_ID")
    private int allotment_id;
   
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cs_id", updatable = false, insertable = true)
    private CourseSelection courseSelection;


    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "a_id", updatable = false, insertable = true)
    private Application application;

    public int getAllotment_id() {
        return allotment_id;
    }
    public void setAllotment_id(int allotment_id) {
        this.allotment_id = allotment_id;
    }
   

   

    
}
