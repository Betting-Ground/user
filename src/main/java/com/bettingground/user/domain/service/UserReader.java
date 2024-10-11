package com.bettingground.user.domain.service;


import com.bettingground.user.domain.entity.User;

public interface UserReader {

    User getUserById(Long userId);

    User getUserByUserToken(String userToken);

    User getUserByUsername(String username);

}
