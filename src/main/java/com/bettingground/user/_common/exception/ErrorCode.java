package com.bettingground.user._common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    SERVER_ERROR("서버 에러"),
    NOT_FOUND_ENTITY("엔티티를 찾을 수 없음");

    private final String message;
}
