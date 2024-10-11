package com.bettingground.user.api.controller;

import com.bettingground.user._common.response.ApiResponse;
import com.bettingground.user.api.request.LoginRequest;
import com.bettingground.user.api.response.LoginResponse;
import com.bettingground.user.app.service.AuthService;
import com.bettingground.user.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/api/v1/auth/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        String accessToken = authService.login(request.getUsername(), request.getPassword());
        return ApiResponse.success("login", new LoginResponse(accessToken));
    }

    @PostMapping("/api/v1/auth/refresh")
    public ApiResponse<String> refresh() {
        return ApiResponse.success("refresh");
    }

    @PostMapping("/api/v1/auth/logout")
    public ApiResponse<String> logout() {
        return ApiResponse.success("logout");
    }

}
