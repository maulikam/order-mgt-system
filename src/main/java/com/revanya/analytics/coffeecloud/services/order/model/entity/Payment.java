package com.revanya.analytics.coffeecloud.services.order.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Payment extends PanacheEntity {
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private PaymentType type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String transactionId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
