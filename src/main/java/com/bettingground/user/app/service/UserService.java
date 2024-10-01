package com.bettingground.user.app.service;

import com.bettingground.user.app.dto.*;
import com.bettingground.user.domain.entity.*;
import com.bettingground.user.domain.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStore userStore;

    @Transactional
    public String signup(UserDto.SignupCommand command) {
        User initUser = command.toEntity();
        User user = userStore.store(initUser);
        return user.getUserToken();
    }

}
