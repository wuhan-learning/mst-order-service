package com.thoughtworks.mstorderservice.repository;

import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {

    List<ShoppingCartItem> findAllByUserName(String userName);

    ShoppingCartItem findOneByUserNameAndGoodsId(String userName, long goodsId);
}
