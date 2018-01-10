package com.thoughtworks.mstorderservice.repository;

public interface TokenAuthRepository {

    String extractAuthorizedPayload(String token);
}