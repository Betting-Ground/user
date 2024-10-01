package com.bettingground.user.domain.service;

import com.bettingground.user.domain.entity.*;

public interface UserStore {
    User store(User initUser);
}
