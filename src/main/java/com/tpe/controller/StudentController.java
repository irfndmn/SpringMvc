package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

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


//    @PostMapping("/saveStudent")
//    public String saveStudent(@ModelAttribute Student student){
//
//        service.saveStudent(student);
//
//        return "redirect:/students";
//    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return "studentForm";

        }

        //service de student ı kaydet
        service.saveStudent(student);
        return "redirect:/students";//http://localhost:8080/SpringMvc/students/ bu isteğe yönlendirelim
    }


    //http://localhost:8080/SpringMvc/students/
    // 2-list all

    @GetMapping
    public ModelAndView listAllStudents(){
        List<Student> studentList=service.getAllStudent();
        ModelAndView mav=new ModelAndView();
        mav.addObject("students",studentList);
        mav.setViewName("students");
        return mav;
    }


    // 3 Student Update **************************************************

//    @GetMapping("/update")
//    public String showUpdateForm(@RequestParam("id")Long id, Model model){
//        Student foundStudent=service.getStudentById(id);
//        model.addAttribute("student",foundStudent);
//
//        return "studentForm";
//
//    }

    // 2 yontem
    @GetMapping("/update")
    public ModelAndView showUpdateForm(@RequestParam("id")Long id, Model model){
        Student foundStudent=service.getStudentById(id);
        ModelAndView mav=new ModelAndView();
        mav.addObject("student",foundStudent);
        mav.setViewName("studentForm");

        return mav;

    }

//***************************************************************** ikisi de ayni isi yioyi



    //silme isleminden sonra tum kayitlaeri gosterelim dolayisiyla gene


    @GetMapping("/delete/{id}")
    public String deleteStudents(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return "redirect:/students";
    }




    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleException(Exception ex){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message",ex.getMessage());
        mav.setViewName("notFound");
        return mav;

    }

// Exceptionhandler belirtilen exception sinifi icinn birr method belirlemizi saglar bu method yaklanan exception icin ozel bir islem icerir










}
