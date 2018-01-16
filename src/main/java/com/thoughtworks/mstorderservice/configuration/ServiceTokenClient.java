package com.thoughtworks.mstorderservice.configuration;

public class ServiceTokenClient {
    private String defaultServiceToken = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwicm9sZSI6IlNZU1RFTV9BRE1JTiIsInByaXZpbGVnZXMiOlsiQ1JFQVRFX1VTRVIiLCJVUERBVEVfVVNFUiIsIlJFVFJJVkVfVVNFUiIsIkRFTEVURV9VU0VSIl0sImV4cCI6NjE1MTU2NDk1NzZ9.jP7P4c5tRGQfVyFlJA6Ac_mCOGUNXCtz7-iNY0NkdSWhia4g-mnAgEKWlZBDdfcrOD7vStxc9hSrW4i7Dmr9Yw";

    public String getServiceToken() {
        return defaultServiceToken;
    }
}
