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
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}