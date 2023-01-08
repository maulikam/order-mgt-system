package com.revanya.analytics.coffeecloud.services.product.model.entity;

import com.revanya.analytics.coffeecloud.services.customer.model.entity.Customer;
import com.revanya.analytics.coffeecloud.services.order.model.entity.Order;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Rating extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private int rating;
    private String comment;
}
