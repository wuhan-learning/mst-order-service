package com.thoughtworks.mstorderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItemDTO {

    private long  id;

    @JsonProperty("user_name")
    private String userName;

    private long quantity;

    @JsonProperty("goods_id")
    private long goodsId;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private Long updatedAt;
}
