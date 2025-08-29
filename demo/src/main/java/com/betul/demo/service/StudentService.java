package com.betul.demo.service;

import com.betul.demo.dto.request.StudentRequest;
import com.betul.demo.dto.response.StudentResponse;
import com.betul.demo.entity.Student;
import com.betul.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public StudentResponse createStudent(StudentRequest studentRequest){
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setPassword(studentRequest.getPassword());

        Student saveStudent = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(saveStudent.getId());
        studentResponse.setName(saveStudent.getName());
        studentResponse.setEmail(saveStudent.getEmail());
        return studentResponse;

    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id,Student updateStudent){
        Student existing = studentRepository.findById(id).orElse(null);
        if(existing != null){
            existing.setName(updateStudent.getName());
            existing.setEmail(updateStudent.getEmail());
            existing.setPassword(updateStudent.getPassword());

            return studentRepository.save(existing);
        }else{
            return null;
        }

    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }


}
