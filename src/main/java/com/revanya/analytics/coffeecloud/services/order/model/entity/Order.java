package com.revanya.analytics.coffeecloud.services.order.model.entity;

import com.revanya.analytics.coffeecloud.services.customer.model.entity.Customer;
import com.revanya.analytics.coffeecloud.services.product.model.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order  extends PanacheEntity {
    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Product> items = new ArrayList<>();

    @NotNull
    private LocalDateTime date;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Positive
    private BigDecimal totalValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_id")
    private ShippingDetails shippingDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tracking_id")
    private TrackingInfo trackingInfo;


}