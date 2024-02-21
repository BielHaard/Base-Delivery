package com.base.delivery.service.security;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface UserDetailsService extends OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    org.springframework.security.core.userdetails.UserDetailsService userDetailsService();

    @Override
    default OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        return null;
    }}


