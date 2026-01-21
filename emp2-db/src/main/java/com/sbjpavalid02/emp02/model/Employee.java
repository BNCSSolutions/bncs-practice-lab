package com.sbjpavalid02.emp02.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(
    name = "bncsemployees01",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employeeId"}),
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"employeeId", "name", "email"})
    }
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Employee ID is required")
    @Column(nullable = false, unique = true)
    private String employeeId;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
    private String mobile;

    @NotBlank(message = "Designation is required")
    private String designation;

    @Min(value = 1000, message = "Salary must be >= 1000")
    private double salary;

    @NotNull(message = "Gender is mandatory")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Date of joining required")
    @PastOrPresent(message = "DOJ cannot be in future")
    private LocalDate doj;

    public Employee() {}

    // Getters & setters

    public int getId() { return id; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public LocalDate getDoj() { return doj; }
    public void setDoj(LocalDate doj) { this.doj = doj; }
}
