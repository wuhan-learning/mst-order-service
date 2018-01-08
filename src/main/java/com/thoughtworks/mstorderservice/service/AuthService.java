package com.thoughtworks.mstorderservice.service;


import com.thoughtworks.mstorderservice.configuration.security.JWTUser;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    JWTUser getAuthorizedJWTUser(HttpServletRequest request);

    boolean hasJWTToken(HttpServletRequest request);

    boolean isTokenInBlackList(HttpServletRequest request);

}
