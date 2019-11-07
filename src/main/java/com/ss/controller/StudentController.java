package com.ss.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ss.mapper.StudentMapper;
import com.ss.pojo.Student;
import com.ss.service.StudentService;

@Controller
public class StudentController {
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentMapper studentMapper;
    
    
    @Autowired
    StudentService studentService;

    @RequestMapping("/list")
    public String list(Model model) {
    	LOG.info("list search start ");
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "students";
    }
    
    
    
    
    @RequestMapping("/all")
    public String all(Model model) {
    	LOG.info("list search start ");
        //List<Student> students = studentService.searchAll();
        //model.addAttribute("students", students);
        return "students";
    }
}