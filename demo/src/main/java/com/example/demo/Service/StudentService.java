package com.example.demo.Service;

import com.example.demo.Model.StudentModel;
import com.example.demo.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {

    private   StudentRepository repository;
    public StudentService(StudentRepository repository){ this.repository=repository;}
    public StudentModel addStudent(StudentModel student){return repository.save(student);}
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    public StudentModel updateStudent(String id ,StudentModel student){
        StudentModel existingStudent =repository.findById(id)
                .orElseThrow(()-> new RuntimeException("No Student Found"));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());


        return repository.save(existingStudent);
    }
    public void deleteStudent(String id) {
        repository.deleteById(id);
    }
}
