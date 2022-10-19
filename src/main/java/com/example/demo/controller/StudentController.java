package com.example.demo.controller;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo repository;

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student){
        repository.save(student);
        return "Added Student";
    }

    @GetMapping("/getAll")
    public List<Student> getall(){
        return repository.findAll();
    }
}
