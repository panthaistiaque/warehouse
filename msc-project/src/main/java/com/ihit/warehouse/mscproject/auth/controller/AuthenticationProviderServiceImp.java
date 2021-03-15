package com.ihit.warehouse.mscproject.auth.controller;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 3/15/2021.
 */
@Component
public class AuthenticationProviderServiceImp implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException   {
        List<GrantedAuthority> grantList = new ArrayList<>();
        String name = authentication.getName();
        String password = ((String) authentication.getCredentials()).trim();
        System.out.println(name +" :: "+password );

        throw new BadCredentialsException("invalid username or password!");
//        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
