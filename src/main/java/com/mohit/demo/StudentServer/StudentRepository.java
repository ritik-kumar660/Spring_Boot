package com.mohit.demo.StudentServer;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Repository
public class StudentRepository {
    public Student save(Student student){
        System.out.println("Student data saved ");
        return student;

    }

}
