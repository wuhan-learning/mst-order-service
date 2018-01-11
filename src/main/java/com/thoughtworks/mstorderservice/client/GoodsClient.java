package com.thoughtworks.mstorderservice.client;


import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${good_service.host}")
public interface GoodsClient {

}
