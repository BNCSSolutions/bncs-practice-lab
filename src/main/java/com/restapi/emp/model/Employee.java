package com.restapi.emp.model;
import java.time.LocalDate;

public class Employee {

    private final int id;
    private String name;
    private String designation;
    private double salary;
    private Gender gender;
    private LocalDate doj;

    public Employee(int id, String name, String designation, double salary,
                    Gender gender, LocalDate doj) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.gender = gender;
        this.doj = doj;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDoj() {
        return doj;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                ", doj=" + doj +
                '}';
    }
}