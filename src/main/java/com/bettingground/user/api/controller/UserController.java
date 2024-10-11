package com.bettingground.user.api.controller;

import com.bettingground.user._common.response.ApiResponse;
import com.bettingground.user.api.request.SignupRequest;
import com.bettingground.user.api.response.SignupResponse;
import com.bettingground.user.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/users")
    public ApiResponse<SignupResponse> signup(@RequestBody SignupRequest request) {
        String userToken = userService.signup(request.toCommand());
        return ApiResponse.success("signup", new SignupResponse(userToken));
    }

    @DeleteMapping("/api/v1/users/{userToken}")
    public ApiResponse<String> withdrawal(@PathVariable("userToken") String userToken) {
        userService.withdrawal(userToken);
        return ApiResponse.success("withdrawal");
    }

}
