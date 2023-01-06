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
@Table(name = "application")
public class Application {
    @Id
     private int a_id;
   

 
    @Column(name = "A_FEES")
    private int a_fees;
  
  
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "a_id")
	private List<Allotment> all;

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "s_id", updatable = false, insertable = true)
    private Student student;
   
    public int getA_id() {
        return a_id;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setA_id(int a_id) {
       this.a_id = a_id;
    }
    public int getA_fees() {
        return a_fees;
    }
    public void setA_fees(int a_fees) {
        this.a_fees = a_fees;
    }
 
 

    


}
