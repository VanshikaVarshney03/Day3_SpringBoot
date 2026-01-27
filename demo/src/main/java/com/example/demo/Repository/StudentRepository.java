package com.example.demo.Repository;

import com.example.demo.Model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <StudentModel,String> {


}
