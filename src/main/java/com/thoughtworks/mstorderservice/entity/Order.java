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
    private Integer id;

    @Column(name = "order_detail")
    private String orderDetail;

    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_time;
}
