package com.example.spring_sec_demo.controller;

import com.example.spring_sec_demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class studentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Leonardo", "Java"),
            new Student(2, "Pedro", "C#")
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }

    @GetMapping("/token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
