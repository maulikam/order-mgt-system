package com.revanya.analytics.coffeecloud.services.customer.model.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
public class Customer extends PanacheEntity {


    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @Email
    @NotBlank
    @Size(max = 50)
    private String email;

    @Size(max = 50)
    private String phone;

    @Size(max = 50)
    private String location;

    @NotNull
    private Integer loyaltyPoints;

    private Boolean isVIP;

    @Size(max = 50)
    private String status;

    @NotNull
    private LocalDate registrationDate;

    private LocalDate lastVisitDate;

    @NotNull
    private Integer rating;

    @NotNull
    private Integer loyaltyLevel;

    @Size(max = 50)
    private String category;

    @Size(max = 50)
    private String preference;

    private Integer age;

    @Size(max = 50)
    private String gender;

    @Size(max = 50)
    private String occupation;

    private Integer income;

    @Size(max = 50)
    private String maritalStatus;

}

