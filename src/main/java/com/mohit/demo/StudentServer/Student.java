package com.mohit.demo.StudentServer;

public class Student
{
    int id;
    String name;
    int age;
    String dep;

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDep() {
        return dep;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
