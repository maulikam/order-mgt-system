package com.revanya.analytics.coffeecloud.services.order.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class Discount extends PanacheEntity {
    private String code;
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;
    private boolean active;
}

