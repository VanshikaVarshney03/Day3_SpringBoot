package com.example.demo.Controller;

import com.example.demo.Model.StudentModel;
import com.example.demo.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {

    private final StudentService services;


    public StudentController(StudentService services) {
        this.services = services;
    }

    // create function API

    @PostMapping("/add-student")
    public StudentModel addStudent (@RequestBody StudentModel student){
        return services.addStudent(student);
    }


    @GetMapping("/students")
    public List<StudentModel> getStudents() {
        return services.getStudents();
    }
    @PutMapping("/update/{id}")
    public StudentModel updateStudent( @PathVariable String id ,  @RequestBody StudentModel student){
        return services.updateStudent(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        services.deleteStudent(id);
        return "Student deleted successfully";
    }
}
