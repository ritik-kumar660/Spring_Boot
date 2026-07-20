package com.mohit.demo.StudentServer.Controller;

import com.mohit.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.mohit.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.mohit.demo.StudentServer.Entity.Student;
import com.mohit.demo.StudentServer.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ==========================
    // Create Student
    // ==========================

    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> createStudent(
            @Valid @RequestBody CreateStudentRequestDTO requestDTO) {

        CreateStudentResponseDTO response =
                studentService.createStudent(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ==========================
    // Get Student By Id
    // ==========================

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    // ==========================
    // Get All Students
    // ==========================

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());

    }

    // ==========================
    // Update Student
    // ==========================

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable int id,
            @Valid @RequestBody CreateStudentRequestDTO requestDTO) {

        Student updatedStudent =
                studentService.updateStudent(id, requestDTO);

        if (updatedStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found");
        }

        return ResponseEntity.ok(updatedStudent);
    }

    // ==========================
    // Delete Student
    // ==========================

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id) {

        Student student = studentService.deleteStudentById(id);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found");
        }

        return ResponseEntity.ok("Student Deleted Successfully");
    }

}