package com.bettingground.user._config.security;

import com.bettingground.user.domain.entity.User;
import com.bettingground.user.domain.service.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserReader userReader;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userReader.getUserByUsername(username);
        return AuthDetails.of(user);
    }
}
