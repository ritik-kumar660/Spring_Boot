package com.mohit.demo.StudentServer.Service;

import com.mohit.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.mohit.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.mohit.demo.StudentServer.Entity.Student;
import com.mohit.demo.StudentServer.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO dto){

        if(dto.getId() < 0 ||
                dto.getAge() < 0 ||
                dto.getName() == null ||
                dto.getDep() == null){

            return null;
        }

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
    public  Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }
    public  Student deleteStudentById(int id){
        Student student=studentRepository.findById(id).orElse(null);
        if(student!=null){
            studentRepository.delete(student);
        }
        return  student;


    }
    public Student updateStudent(int id, Student studentDetails) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(studentDetails.getName());
        existingStudent.setAge(studentDetails.getAge());
        existingStudent.setDep(studentDetails.getDep());

        return studentRepository.save(existingStudent);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
