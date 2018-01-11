package com.thoughtworks.mstorderservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "t_order_item")
public class OrderItems {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    private double price;

    private long amount;
}
