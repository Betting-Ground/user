package com.bettingground.user.api.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupResponse implements Serializable {

    private String userToken;
}
