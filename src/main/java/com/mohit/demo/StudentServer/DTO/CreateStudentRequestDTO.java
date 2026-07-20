package com.mohit.demo.StudentServer.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStudentRequestDTO {

    @NotNull(message = "Id cannot be null")
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 18, message = "Age should be greater than or equal to 18")
    private int age;

    @NotBlank(message = "Department cannot be empty")
    private String dep;

    public CreateStudentRequestDTO() {
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
}