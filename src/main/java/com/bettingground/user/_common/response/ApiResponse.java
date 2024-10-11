package com.bettingground.user._common.response;

import static com.bettingground.user._common.response.Result.ERROR;
import static com.bettingground.user._common.response.Result.FAIL;
import static com.bettingground.user._common.response.Result.SUCCESS;
import static lombok.AccessLevel.PRIVATE;

import com.bettingground.user._common.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = PRIVATE)
public class ApiResponse<T> implements Serializable {

    private Result result;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorCode errorCode;

    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.<T>builder()
            .result(SUCCESS)
            .message(message)
            .data(data)
            .build();
    }

    public static <T> ApiResponse<T> success(String message) {
        return ApiResponse.success(message, null);
    }

    public static ApiResponse fail(ErrorCode errorCode) {
        return ApiResponse.builder()
            .result(FAIL)
            .message(errorCode.getMessage())
            .errorCode(errorCode)
            .build();
    }

    public static ApiResponse error(ErrorCode errorCode) {
        return ApiResponse.builder()
            .result(ERROR)
            .message(errorCode.getMessage())
            .errorCode(errorCode)
            .build();
    }
}
