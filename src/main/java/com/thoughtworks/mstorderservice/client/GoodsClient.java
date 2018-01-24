package com.thoughtworks.mstorderservice.client;


import com.thoughtworks.mstorderservice.dto.GoodsDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("${goods_service.name}")
public interface GoodsClient {

    @GetMapping("/api/goods")
    List<GoodsDTO> queryGoods(@RequestParam("goods_ids") List<Long> goodsIds);
}
