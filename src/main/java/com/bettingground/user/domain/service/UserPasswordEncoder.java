package com.bettingground.user.domain.service;

import com.bettingground.user.domain.entity.User;

public interface UserPasswordEncoder {

    User encode(User user);
}
