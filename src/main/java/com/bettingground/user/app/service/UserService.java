package com.bettingground.user.app.service;

import com.bettingground.user.app.dto.UserDto.SignupCommand;
import com.bettingground.user.domain.entity.User;
import com.bettingground.user.domain.service.UserPasswordEncoder;
import com.bettingground.user.domain.service.UserReader;
import com.bettingground.user.domain.service.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReader userReader;
    private final UserStore userStore;
    private final UserPasswordEncoder userPasswordEncoder;

    @Transactional
    public String signup(SignupCommand command) {
        User initUser = command.toEntity();
        userPasswordEncoder.encode(initUser);
        User user = userStore.store(initUser);
        return user.getUserToken();
    }

    @Transactional
    public void withdrawal(String userToken) {
        User user = userReader.getUserByUserToken(userToken);
        user.delete();
    }

}
