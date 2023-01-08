package com.revanya.analytics.coffeecloud.services.order.model.entity;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

@Entity
@Data
public class TrackingInfo extends PanacheEntity {
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String trackingNumber;
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String carrier;
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String status;
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String deliveryDate;
}



