package com.thoughtworks.mstorderservice.api;

import com.thoughtworks.mstorderservice.dto.ShoppingCartItemDTO;
import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import com.thoughtworks.mstorderservice.service.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart-items")
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService shoppingCartItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingCartItemDTO create(@RequestBody ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemService.addShoppingCartItem(shoppingCartItem);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingCartItemDTO> get() {
        return shoppingCartItemService.findShoppingCartDTOs("username");
    }

}
