package com.bettingground.user.infra;

import com.bettingground.user.domain.entity.*;
import com.bettingground.user.domain.repository.*;
import com.bettingground.user.domain.service.*;
import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

    private final UserRepository userRepository;

    @Override
    public User store(User initUser) {
        return userRepository.save(initUser);
    }

}
