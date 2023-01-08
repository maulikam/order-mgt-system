package com.revanya.analytics.coffeecloud.services.employee.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Shift extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
}
