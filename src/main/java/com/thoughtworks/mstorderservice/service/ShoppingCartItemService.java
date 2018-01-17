package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.client.GoodsClient;
import com.thoughtworks.mstorderservice.dto.GoodsDTO;
import com.thoughtworks.mstorderservice.dto.ShoppingCartItemDTO;
import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import com.thoughtworks.mstorderservice.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShoppingCartItemService {

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    private GoodsClient goodsClient;

    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemRepository.save(shoppingCartItem);
    }

    public List<ShoppingCartItemDTO> findShoppingCartDTOs(String userName) {
        List<ShoppingCartItem> shoppingCartItems = shoppingCartItemRepository.findAllByUserName(userName);

        List<ShoppingCartItemDTO> shoppingCartItemDTOS = shoppingCartItems
                .stream()
                .map(shoppingCartItem -> ShoppingCartItemDTO.builder()
                        .id(shoppingCartItem.getId())
                        .createdDate(shoppingCartItem.getCreatedDate())
                        .quantity(shoppingCartItem.getQuantity())
                        .goodsId(shoppingCartItem.getGoodsId())
                        .updatedDate(shoppingCartItem.getUpdatedDate())
                        .userName(shoppingCartItem.getUserName())
                        .build())
                .collect(Collectors.toList());
        List<Long> goodIds = shoppingCartItemDTOS.stream().map(item -> item.getGoodsId()).collect(Collectors.toList());
        List<GoodsDTO> goodsDTOS = goodsClient.queryGoods(goodIds);
        Map<Long, GoodsDTO> goodsIdDTOs = goodsDTOS.stream().collect(Collectors.toMap(GoodsDTO::getId, goodsDTO -> goodsDTO));
        shoppingCartItemDTOS.forEach(shoppingCartItemDTO -> {
            GoodsDTO goodsDTO = goodsIdDTOs.get(shoppingCartItemDTO.getGoodsId());
            shoppingCartItemDTO.setGoodsName(goodsDTO.getName());
            shoppingCartItemDTO.setDescription(goodsDTO.getDescription());
            shoppingCartItemDTO.setPrice(goodsDTO.getPrice());
            shoppingCartItemDTO.setStockAmount(goodsDTO.getStockAmount());
        });

        return shoppingCartItemDTOS;
    }

    public ShoppingCartItemDTO addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
        ShoppingCartItem existedCartItem = shoppingCartItemRepository.findOneByUserNameAndGoodsId(shoppingCartItem.getUserName(), shoppingCartItem.getGoodsId());
        if (Objects.isNull(existedCartItem)) {
            existedCartItem = save(shoppingCartItem);
        }
        return ShoppingCartItemDTO.builder()
                .id(shoppingCartItem.getId())
                .userName(existedCartItem.getUserName())
                .goodsId(existedCartItem.getGoodsId())
                .quantity(existedCartItem.getQuantity())
                .createdDate(existedCartItem.getCreatedDate())
                .updatedDate(existedCartItem.getUpdatedDate())
                .build();
    }
}
