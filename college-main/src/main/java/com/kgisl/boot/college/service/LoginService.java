package com.kgisl.boot.college.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.kgisl.boot.college.dto.CollegeDto;
import com.kgisl.boot.college.dto.ApplicationDto;
import com.kgisl.boot.college.dto.RejectedDto;
import com.kgisl.boot.college.dto.SelectedDto;
import com.kgisl.boot.college.dto.StatusDto;
import com.kgisl.boot.college.entity.Course;
import com.kgisl.boot.college.entity.Login;
import com.kgisl.boot.college.entity.Signup;

public interface LoginService {
    public ModelAndView checkUser(String name,String pass);

    public ModelAndView signup(Signup signup);

    public List<Course> courseDetails();

    public List<RejectedDto> rejectedDetails();

    public List<SelectedDto> selectedDetails();

    public List<ApplicationDto> applicationlist();

    public List<Signup> stdApprovallist();

    public void addtheuser(Signup signup);

    public void logintheuser(Login login);

    public List<CollegeDto> collegeSeatList(int c_id, int course_id);

    public List<StatusDto> status(String u_name, String pass);



    
    
}
