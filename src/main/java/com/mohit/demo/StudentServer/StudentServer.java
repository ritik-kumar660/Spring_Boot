package com.mohit.demo.StudentServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    //make methods for crud operations


    //1. to store the data
    @PostMapping("/create")
    public String storeStudent(@RequestBody Student student){

      int id= student.getId();
      String name= student.getName();
      int age= student.getAge();
      String dep= student.getDep();

        return "id:- "+id+", name:- "+name+", age:- "+age+", Dep:- "+dep;
    }
}
