package com.revanya.analytics.coffeecloud.services.product.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;

@Entity
public class ProductCategory extends PanacheEntity {

    @NotBlank
    private String name;


    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
