package com.thoughtworks.mstorderservice.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class FeignHeaderInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        template.header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwicm9sZSI6IlNZU1RFTV9BRE1JTiIsInByaXZpbGVnZXMiOlsiQ1JFQVRFX1VTRVIiLCJVUERBVEVfVVNFUiIsIlJFVFJJVkVfVVNFUiIsIkRFTEVURV9VU0VSIl0sImV4cCI6NjE1MTU2NDk1NzZ9.jP7P4c5tRGQfVyFlJA6Ac_mCOGUNXCtz7-iNY0NkdSWhia4g-mnAgEKWlZBDdfcrOD7vStxc9hSrW4i7Dmr9Yw");
    }
}
