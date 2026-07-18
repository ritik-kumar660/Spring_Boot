package com.mohit.demo.StudentServer.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Student {

    @Id
    private int id;

    private String name;

    private int age;

    private String dep;

    @CreationTimestamp
    @JsonFormat(
            pattern = "dd-MMM-yyyy hh:mm a",
            timezone = "Asia/Kolkata"
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonFormat(
            pattern = "dd-MMM-yyyy hh:mm a",
            timezone = "Asia/Kolkata"
    )
    private LocalDateTime updatedAt;

    public Student() {
    }

    // ===========================
    // Getters
    // ===========================

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDep() {
        return dep;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // ===========================
    // Setters
    // ===========================

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    // No setters for timestamps because Hibernate manages them automatically.
}