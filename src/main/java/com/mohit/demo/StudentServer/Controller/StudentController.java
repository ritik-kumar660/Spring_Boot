package com.mohit.demo.StudentServer.Controller;

import com.mohit.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.mohit.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.mohit.demo.StudentServer.Entity.Student;
import com.mohit.demo.StudentServer.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {
    //1. to store the data
    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> storeStudent(
            @RequestBody CreateStudentRequestDTO requestDTO) {

        CreateStudentResponseDTO responseDTO =
                studentService.studentValidate(requestDTO);

        if(responseDTO == null){
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping("/get/{id}")
    public  ResponseEntity<?>  getStudentById(@PathVariable  int id){
        Student student=studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id){
        Student student=studentService.deleteStudentById(id);
        return ResponseEntity.status(200).body("Student  Deleted successfully");



    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Update failed: Student not found or validation failed.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
