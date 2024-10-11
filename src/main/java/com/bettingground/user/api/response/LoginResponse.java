package com.bettingground.user.api.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse implements Serializable {

    private String accessToken;
}
