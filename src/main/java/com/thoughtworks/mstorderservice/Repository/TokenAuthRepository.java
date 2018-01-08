package com.thoughtworks.mstorderservice.Repository;

public interface TokenAuthRepository {

    String extractAuthorizedPayload(String token);
}