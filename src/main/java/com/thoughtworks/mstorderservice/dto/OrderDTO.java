package com.thoughtworks.mstorderservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderDTO {
    private long id;
    private String number;
    private List<String> goodsIds;
}
