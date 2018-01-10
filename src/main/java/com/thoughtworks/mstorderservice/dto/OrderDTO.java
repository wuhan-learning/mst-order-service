package com.thoughtworks.mstorderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDTO {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String orderDetail;
}
