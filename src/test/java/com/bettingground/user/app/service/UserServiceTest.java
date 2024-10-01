package com.bettingground.user.app.service;

import com.bettingground.user.app.dto.*;
import com.bettingground.user.domain.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void signup() throws Exception {
        // given
        UserDto.SignupCommand command = new UserDto.SignupCommand("panjun", "1234", Role.PLAYER);

        // when
        String userToken = userService.signup(command);

        // then
        System.out.println("userToken = " + userToken);
    }

}