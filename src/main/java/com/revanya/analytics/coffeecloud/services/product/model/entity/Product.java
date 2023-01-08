package com.revanya.analytics.coffeecloud.services.product.model.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Product extends PanacheEntity {
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotBlank
    private String description;

    @NotBlank
    private String image;

    @NotNull
    @Positive
    private int stock;

    @NotNull
    @Positive
    private int minimumStock;

    private String dimensions;
    private String shippingDetails;
    private boolean availability;

    @NotNull
    @Positive
    private double rating;

    @NotNull
    @Positive
    private int reviewCount;

    @ElementCollection
    private List<String> tags;

    @NotNull
    @Positive
    private int quantity;

    @ManyToOne
    private ProductCategory category;

    @NotNull
    @Positive
    private BigDecimal taxRate;

    private String ingredients;
    private String allergens;
    private String nutritionalInformation;

    @NotBlank
    private String brand;

    private String size;

    @NotNull
    @Positive
    private double weight;


}