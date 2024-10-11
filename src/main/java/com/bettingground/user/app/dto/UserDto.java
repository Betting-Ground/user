package com.bettingground.user.app.dto;

import com.bettingground.user.domain.entity.Role;
import com.bettingground.user.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

public class UserDto {

    @Getter
    @Builder
    public static class SignupCommand {

        private String username;
        private String password;
        private Role role;
        private String nickname;

        public User toEntity() {
            return User.builder()
                .username(this.username)
                .password(this.password)
                .role(this.role)
                .nickname(this.nickname)
                .build();
        }
    }
}
