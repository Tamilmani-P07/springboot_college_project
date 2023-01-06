package com.kgisl.boot.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.kgisl.boot.college.dto.ApplicationDto;
import com.kgisl.boot.college.dto.CollegeDto;
import com.kgisl.boot.college.dto.RejectedDto;
import com.kgisl.boot.college.dto.SelectedDto;
import com.kgisl.boot.college.dto.StatusDto;
import com.kgisl.boot.college.entity.Course;
import com.kgisl.boot.college.entity.Login;
import com.kgisl.boot.college.entity.Signup;
import com.kgisl.boot.college.repository.AllotmentRepository;
import com.kgisl.boot.college.repository.ApplicationRepository;
import com.kgisl.boot.college.repository.CollegeRepository;
import com.kgisl.boot.college.repository.CourseRepository;
import com.kgisl.boot.college.repository.LoginRepository;
import com.kgisl.boot.college.repository.Signuprepository;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
   AllotmentRepository allotmentRepository;
   @Autowired
   ApplicationRepository applicationRepository;
   @Autowired
   Signuprepository signuprepository;
   @Autowired
   CollegeRepository collegeRepository;
 
    @Override
    @Transactional
    public ModelAndView checkUser(String name, String pass) {
        ModelAndView mod = new ModelAndView();
        System.out.println("senthil");

        List<Login> sen = loginRepository.loginValidate(name, pass);
        System.out.println(sen);

        if (sen.size()!=0) {
            for (Login object : sen) {
                
                    if (object.getCategory().equals("ADMIN")) {
                        System.out.println("Admin");
                        mod.setViewName("admin.html");

                    } else {
                        mod.setViewName("student.html");
                    }
                }
            

        } 
        else {
            System.out.println("else");
            mod.setViewName("signup.html");
        }

        return mod;

    }

    @Override
    public ModelAndView signup(Signup signup) {
        Signup s = signuprepository.save(signup);
        System.out.println(s);
        ModelAndView sen=new ModelAndView();
        sen.setViewName("index.html");
        return sen;
    }

    @Override
    public List<Course> courseDetails() {
        List<Course> list = courseRepository.findAll();
        System.out.println(list);
        return list;
    }

    @Override
    public List<RejectedDto> rejectedDetails() {
        List<RejectedDto> rejlist = allotmentRepository.rejectejoin();
        System.out.println(rejlist);
        return  rejlist;
    }

    @Override
    public List<SelectedDto> selectedDetails() {
        List<SelectedDto> sejlist = allotmentRepository.selectedjoin();
        System.out.println(sejlist);
        return  sejlist;
    }

    @Override
    public List<ApplicationDto> applicationlist() {
        List<ApplicationDto>aplist=applicationRepository.applicationjoins();
        return aplist;
    }

    @Override
    public List<Signup> stdApprovallist() {
        List<Signup>alist=signuprepository.findAll();
        return alist;
    }

    @Override
    @Transactional
    public void addtheuser(Signup signup) {
        System.out.println("delete");
      
  signuprepository.deletebyname(signup.getU_name());
      
    }

    @Override
    public void logintheuser(Login signup) {
        System.out.println("senthil");
        loginRepository.save(signup);
        
    }

    @Override
    public List<CollegeDto> collegeSeatList(int c_id, int course_id) {
        System.out.println("seatlist");
        List<CollegeDto> seat = collegeRepository.seatlist(c_id,course_id);
        System.out.println("college seatlist:"+seat);
        return seat;
    }

    @Override
    public List<StatusDto> status(String u_name, String pass) {
        System.out.println("statuslist");
        List<StatusDto> seat = collegeRepository.statuslist1(u_name,pass);
        System.out.println("college statuslist:"+seat);
        return seat;
    }}


