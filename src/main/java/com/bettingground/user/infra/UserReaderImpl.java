package com.bettingground.user.infra;

import com.bettingground.user._common.exception.ApiException;
import com.bettingground.user._common.exception.ErrorCode;
import com.bettingground.user.domain.entity.User;
import com.bettingground.user.domain.repository.UserRepository;
import com.bettingground.user.domain.service.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
            () -> new ApiException(ErrorCode.NOT_FOUND_ENTITY)
        );
    }

    @Override
    public User getUserByUserToken(String userToken) {
        return userRepository.findByUserToken(userToken).orElseThrow(
            () -> new ApiException(ErrorCode.NOT_FOUND_ENTITY)
        );
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
            () -> new ApiException(ErrorCode.NOT_FOUND_ENTITY)
        );
    }
}
