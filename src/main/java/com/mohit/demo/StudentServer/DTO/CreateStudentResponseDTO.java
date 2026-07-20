package com.mohit.demo.StudentServer.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CreateStudentResponseDTO {

    private int id;
    private String name;
    private int age;
    private String dep;

    @JsonFormat(
            pattern = "dd-MMM-yyyy hh:mm a",
            timezone = "Asia/Kolkata"
    )
    private LocalDateTime createdAt;

    @JsonFormat(
            pattern = "dd-MMM-yyyy hh:mm a",
            timezone = "Asia/Kolkata"
    )
    private LocalDateTime updatedAt;

    public CreateStudentResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}