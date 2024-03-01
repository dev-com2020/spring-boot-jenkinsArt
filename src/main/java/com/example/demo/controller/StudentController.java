package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/{Id}")
    public ResponseEntity getStudentbyId(@PathVariable int Id){
        return ResponseEntity.ok(
                Objects.requireNonNullElse(studentService.getStudentById(Id),
                        "Resource not found"));
    }

    @GetMapping("/students")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.ok(
                Objects.requireNonNullElse(
                        studentService.getAllStudents(), "No Resource found"));
    }


}
