package com.mohit.demo.StudentServer.Service;

import com.mohit.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.mohit.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.mohit.demo.StudentServer.Entity.Student;
import com.mohit.demo.StudentServer.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // ==========================
    // Create Student
    // ==========================

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO dto) {

        Student student = new Student();

        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDep(dto.getDep());

        Student savedStudent = studentRepository.save(student);

        CreateStudentResponseDTO response = new CreateStudentResponseDTO();

        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setAge(savedStudent.getAge());
        response.setDep(savedStudent.getDep());
        response.setCreatedAt(savedStudent.getCreatedAt());
        response.setUpdatedAt(savedStudent.getUpdatedAt());

        return response;
    }

    // ==========================
    // Get Student By Id
    // ==========================

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // ==========================
    // Get All Students
    // ==========================

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ==========================
    // Update Student
    // ==========================

    public Student updateStudent(int id, CreateStudentRequestDTO dto) {

        Student existingStudent =
                studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setDep(dto.getDep());

        return studentRepository.save(existingStudent);
    }

    // ==========================
    // Delete Student
    // ==========================

    public Student deleteStudentById(int id) {

        Student student =
                studentRepository.findById(id).orElse(null);

        if (student != null) {
            studentRepository.delete(student);
        }

        return student;
    }

}