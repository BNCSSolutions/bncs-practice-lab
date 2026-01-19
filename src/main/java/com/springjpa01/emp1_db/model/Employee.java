package com.springjpa01.emp1_db.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bncsemployees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private double salary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate doj;

    public Employee() {
    }

    public Employee(String name, String designation, double salary, Gender gender, LocalDate doj) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.gender = gender;
        this.doj = doj;
    }

    // Getters and setters

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public LocalDate getDoj() { return doj; }
    public void setDoj(LocalDate doj) { this.doj = doj; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                ", doj=" + doj +
                '}';
    }
}
