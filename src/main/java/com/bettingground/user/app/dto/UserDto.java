package com.bettingground.user.app.dto;

import com.bettingground.user.domain.entity.*;
import lombok.*;

public class UserDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignupCommand {

        private String username;
        private String password;
        private Role role;

        public User toEntity() {
            return User.builder()
                    .username(this.username)
                    .password(this.password)
                    .role(this.role)
                    .build();
        }
    }
}
