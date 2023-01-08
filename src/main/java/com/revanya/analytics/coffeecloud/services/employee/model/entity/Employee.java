package com.revanya.analytics.coffeecloud.services.employee.model.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

@Entity
@Data
public class Employee extends PanacheEntity {
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 15)
    private String phone;

    @NotBlank
    @Size(max = 100)
    private String location;

    @NotBlank
    @Size(max = 100)
    private String status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    private LocalDate hireDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PerformanceRating performanceRating;

    @NotNull
    private int salary;

    @Enumerated(EnumType.STRING)
    private EmployeeLevel category;

    @NotNull
    private int age;

    @NotBlank
    @Size(max = 100)
    private String occupation;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;



}
