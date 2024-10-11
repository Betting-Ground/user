package com.bettingground.user.app.service;

import com.bettingground.user._common.utils.JwtUtils;
import com.bettingground.user._config.security.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationProvider provider;
    private final JwtUtils jwtUtils;

    @Transactional
    public String login(String username, String password) {
        Authentication authentication =
            provider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        return jwtUtils.generateAccessToken(authDetails);
    }

    public String refresh() {
        return null;
    }

    public void logout() {

    }
    
}
