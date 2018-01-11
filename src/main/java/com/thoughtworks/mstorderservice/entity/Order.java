package com.thoughtworks.mstorderservice.entity;

import com.thoughtworks.mstorderservice.enums.OrderStatus;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "t_order")
public class Order{
    @Id
    @GeneratedValue
    private long id;

    private String number;

    private long createdDate;

    private long updatedDate;

    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
