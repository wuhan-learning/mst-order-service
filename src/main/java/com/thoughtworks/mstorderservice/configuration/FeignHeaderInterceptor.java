package com.thoughtworks.mstorderservice.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class FeignHeaderInterceptor implements RequestInterceptor {

    @Autowired
    private ServiceTokenClient serviceTokenClient;

    @Value("${headers.request-id}")
    private String requestIdHeader;
    @Value("${headers.client-version}")
    private String clientVersionHeader;

    @Override
    public void apply(RequestTemplate template) {
        template.header(requestIdHeader, getHeader(requestIdHeader));
        template.header(clientVersionHeader, getHeader(clientVersionHeader));
        template.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        template.header(HttpHeaders.AUTHORIZATION, serviceTokenClient.getServiceToken());
    }

    private String getHeader(String header) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return attributes.getRequest().getHeader(header);
    }
}
