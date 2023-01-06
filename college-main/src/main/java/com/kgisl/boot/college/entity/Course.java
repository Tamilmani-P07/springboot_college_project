package com.kgisl.boot.college.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
    @Id
    private int  course_id;
    public int getCourse_id() {
        return course_id;
    }
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
    public String getCour_name() {
        return cour_name;
    }
    public void setCour_name(String cour_name) {
        this.cour_name = cour_name;
    }
    public int getTotal_seats() {
        return total_seats;
    }
    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    private String cour_name;
    private int total_seats;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name ="course_id")
	private List<CourseSelection> all;
    
}
