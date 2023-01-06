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
@Table(name = "course_selection")
public class CourseSelection {
    @Id
    private int cs_id;
    public int getCs_id() {
        return cs_id;
    }

    public void setCs_id(int cs_id) {
        this.cs_id = cs_id;
    }



    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @JoinColumn(name = "cs_id")
   private List<Allotment> all;
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id", updatable = false, insertable = true)
    private College college;

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", updatable = false, insertable = true)
    private Course course;
    
}
