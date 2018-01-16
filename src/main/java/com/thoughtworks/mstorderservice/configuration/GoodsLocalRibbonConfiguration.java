package com.thoughtworks.mstorderservice.configuration;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

public class GoodsLocalRibbonConfiguration {

    @Value("${goods_service.host:localhost:30002}")
    private String localGoodsServer;

    @Bean
    public ServerList<Server> serverList() {
        return new StaticServerList<>(new Server(localGoodsServer));
    }
}
