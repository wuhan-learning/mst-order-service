package com.thoughtworks.mstorderservice.configuration.security;

import com.thoughtworks.mstorderservice.repository.TokenAuthRepository;
import com.thoughtworks.mstorderservice.util.StringUtils;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class JWTAuthRepositoryImpl implements TokenAuthRepository {

    @Value("${security.jwt.secret:_SEMS_JWT_SECRET_201801080808888}")
    private String jwtSecret;

    @Value("${security.jwt.expiration-in-seconds}")
    private long expirationInSeconds;

    @Override
    public String extractAuthorizedPayload(String jwtToken) {
        return StringUtils.writeObjectAsJsonString(Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(jwtToken)
                .getBody());
    }
}
