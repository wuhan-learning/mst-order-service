package com.thoughtworks.mstorderservice.api;

import com.thoughtworks.mstorderservice.dto.ShoppingCartItemDTO;
import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import com.thoughtworks.mstorderservice.repository.ShoppingCartItemRepository;
import com.thoughtworks.mstorderservice.service.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/shopping-cart-items")
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService shoppingCartItemService;

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingCartItemDTO create(@RequestBody ShoppingCartItem shoppingCartItem) {
        ShoppingCartItem existedCartItem = shoppingCartItemRepository.findOneByUserNameAndGoodsId(shoppingCartItem.getUserName(), shoppingCartItem.getGoodsId());
        if (Objects.isNull(existedCartItem)) {
            existedCartItem = shoppingCartItemService.save(shoppingCartItem);
        }
        return ShoppingCartItemDTO.builder()
                .id(shoppingCartItem.getId())
                .userName(existedCartItem.getUserName())
                .goodsId(existedCartItem.getGoodsId())
                .quantity(existedCartItem.getQuantity())
                .createdAt(existedCartItem.getCreatedAt())
                .updatedAt(existedCartItem.getUpdatedAt())
                .build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingCartItemDTO> get() {
        return shoppingCartItemService.findShoppingCartDTOs("username");
    }

}
