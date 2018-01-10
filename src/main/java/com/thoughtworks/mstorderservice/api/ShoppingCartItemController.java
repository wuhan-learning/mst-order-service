package com.thoughtworks.mstorderservice.api;

import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import com.thoughtworks.mstorderservice.service.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shopping-cart-item")
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService shoppingCartItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingCartItem create(@RequestBody ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemService.save(shoppingCartItem);
    }
}
