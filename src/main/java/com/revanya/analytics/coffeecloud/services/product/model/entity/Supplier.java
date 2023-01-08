package com.revanya.analytics.coffeecloud.services.product.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Supplier extends PanacheEntity {
    private String name;
    private String contactInformation;
    private boolean active;
}
