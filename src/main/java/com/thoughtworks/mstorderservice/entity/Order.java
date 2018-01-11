package com.thoughtworks.mstorderservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


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
}
