package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;


    @GetMapping("/hi")
    public ModelAndView sayHi(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Merhaba");
        mav.addObject("messagebody","I'm a Student Management System");
        mav.setViewName("hi");
        return mav;
    }

    @GetMapping("/new")
    public String sendStudentForm(@ModelAttribute("student")Student student){

        return "studentForm";

    }


    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student){

        service.saveStudent(student);

        return "redirect:/students";
    }






}
