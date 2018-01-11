package com.thoughtworks.mstorderservice.api;

import com.thoughtworks.mstorderservice.entity.ShoppingCartItem;
import com.thoughtworks.mstorderservice.helper.APIBaseTest;
import com.thoughtworks.mstorderservice.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShoppingCartItemControllerTest extends APIBaseTest {

    @Test
    void should_get_shopping_cart_item_with_id_when_save_a_new_shopping_cart_item() throws Exception {
        ShoppingCartItem item = ShoppingCartItem.builder()
            .userName("user-name")
            .goodsId(1L)
            .build();

        mockMvc.perform(post("/api/shopping-cart-items")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(JsonUtils.marshal(item)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").isNotEmpty())
            .andExpect(jsonPath("$.user_name").value(item.getUserName()))
            .andExpect(jsonPath("$.goods_id").value(item.getGoodsId()));
    }
}