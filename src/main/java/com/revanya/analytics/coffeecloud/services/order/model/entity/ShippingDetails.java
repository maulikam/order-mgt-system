package com.revanya.analytics.coffeecloud.services.order.model.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

@Entity
@Data
public class ShippingDetails extends PanacheEntity {
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String address;
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String city;
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String state;
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String country;
    @NotNull
    @NotBlank
    @Size(max = 10)
    private String zipCode;
}
