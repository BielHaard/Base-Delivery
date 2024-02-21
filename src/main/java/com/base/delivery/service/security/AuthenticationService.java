package com.base.delivery.service.security;

import com.base.delivery.dao.request.SignUpRequest;
import com.base.delivery.dao.request.SigninRequest;
import com.base.delivery.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request) throws Exception;

    JwtAuthenticationResponse signin(SigninRequest request);
}
