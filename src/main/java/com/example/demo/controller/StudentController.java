package com.example.demo.controller;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation(value = "Adds student to the database", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 , message = "Successfully added the student data"),
            @ApiResponse(code=401 , message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403,message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    })
    public String saveStudent(@RequestBody Student student){
        repository.save(student);
        return "Added Student";
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "View all students", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all students"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public List<Student> getall(){
        return repository.findAll();
    }
}
