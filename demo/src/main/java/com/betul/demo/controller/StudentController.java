package com.betul.demo.controller;

import com.betul.demo.dto.request.StudentRequest;
import com.betul.demo.dto.response.StudentResponse;
import com.betul.demo.entity.Student;
import com.betul.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping ("/create")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest requestDTO) {
        StudentResponse response = studentService.createStudent(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent (@PathVariable Long id){
        studentService.deleteStudent(id);
    }







}
