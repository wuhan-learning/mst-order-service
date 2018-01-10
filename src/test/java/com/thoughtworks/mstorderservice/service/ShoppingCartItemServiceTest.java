package com.thoughtworks.mstorderservice.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import com.thoughtworks.mstorderservice.helper.MockitoExtension;
import com.thoughtworks.mstorderservice.repository.ShoppingCartItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
class ShoppingCartItemServiceTest {

    @InjectMocks
    ShoppingCartItemService shoppingCartItemService;

    @Mock
    ShoppingCartItemRepository shoppingCartItemRepository;

    @Test
    void should_call_shopping_cart_item_repository_when_save() {
        shoppingCartItemService.save(ShoppingCartItem.builder().build());

        verify(shoppingCartItemRepository).save(any(ShoppingCartItem.class));
    }
}