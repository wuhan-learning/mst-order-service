package com.thoughtworks.mstorderservice.client;


import com.thoughtworks.mstorderservice.dto.GoodsDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "${good_service.host}")
public interface GoodsClient {

    @GetMapping("/api/goods")
    List<GoodsDTO> queryGoods(@RequestParam List<String> goodsIds);
}
