package com.thoughtworks.mstorderservice.configuration;


import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RibbonClients(@RibbonClient(name = "${goods_service.host}"))
public class RibbonLocalConfiguration {

    @Value("${goods_service.host:localhost:8092}")
    private String localGoodsServer;

    @Bean
    public ServerList<Server> serverList() {
        return new StaticServerList<>(new Server(localGoodsServer));
    }
}
