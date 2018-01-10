package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import com.thoughtworks.mstorderservice.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartItemService {

    @Autowired
    ShoppingCartItemRepository shoppingCartItemRepository;

    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemRepository.save(shoppingCartItem);
    }
}
