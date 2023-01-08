package com.revanya.analytics.coffeecloud.services.order.model.entity;

import com.revanya.analytics.coffeecloud.services.product.model.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class OrderProduct  extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product item;
    private int quantity;
}
