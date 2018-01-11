package com.thoughtworks.mstorderservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceTokenConfiguration {

    @Value("${serviceTokenKey}")
    private String serviceTokenKey;

    @Bean
    @ConditionalOnMissingBean(ServiceTokenClient.class)
    public ServiceTokenClient getLocalServiceTokenClient() {
        return new ServiceTokenClient();
    }
}