package com.thoughtworks.mstorderservice.configuration;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "local")
@RibbonClients({
        @RibbonClient(name = "${goods_service:goods-service}", configuration = GoodsLocalRibbonConfiguration.class)
})
public class RibbonLocalConfiguration {

}
