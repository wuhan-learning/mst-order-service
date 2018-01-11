package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.dto.ShoppingCartItemDTO;
import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import com.thoughtworks.mstorderservice.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartItemService {

    @Autowired
    ShoppingCartItemRepository shoppingCartItemRepository;

    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemRepository.save(shoppingCartItem);
    }

    public List<ShoppingCartItemDTO> findShoppingCartDTOs(String userName) {
        List<ShoppingCartItem> shoppingCartItems = shoppingCartItemRepository.findAllByUserName(userName);

        return shoppingCartItems
                .stream()
                .map(shoppingCartItem -> ShoppingCartItemDTO.builder()
                        .id(shoppingCartItem.getId())
                        .createdAt(shoppingCartItem.getCreatedAt())
                        .quantity(shoppingCartItem.getQuantity())
                        .goodsId(shoppingCartItem.getGoodsId())
                        .updatedAt(shoppingCartItem.getUpdatedAt())
                        .userName(shoppingCartItem.getUserName())
                        .build())
                .collect(Collectors.toList());
    }
}
