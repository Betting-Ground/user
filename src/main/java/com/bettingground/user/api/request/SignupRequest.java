package com.bettingground.user.api.request;

import com.bettingground.user.app.dto.UserDto.SignupCommand;
import com.bettingground.user.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupRequest {

    private String username;
    private String password;
    private String role;
    private String nickname;

    public SignupCommand toCommand() {
        return SignupCommand.builder()
            .username(this.username)
            .password(this.password)
            .role(Role.valueOf(this.role))
            .nickname(this.nickname)
            .build();
    }
}
