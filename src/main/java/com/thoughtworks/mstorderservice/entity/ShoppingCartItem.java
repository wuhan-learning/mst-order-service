package com.thoughtworks.mstorderservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_shopping_cart_item")
public class ShoppingCartItem {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "goods_id")
    private long goodsId;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "created_at")
    private long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;
}
