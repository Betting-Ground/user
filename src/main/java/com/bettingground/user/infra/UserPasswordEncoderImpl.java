package com.bettingground.user.infra;

import com.bettingground.user.domain.entity.User;
import com.bettingground.user.domain.service.UserPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPasswordEncoderImpl implements UserPasswordEncoder {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User encode(User user) {
        user.updatePassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

}
