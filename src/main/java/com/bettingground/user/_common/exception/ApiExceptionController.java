package com.bettingground.user._common.exception;

import com.bettingground.user._common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionController {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ApiException.class)
    public static ApiResponse apiException(ApiException e) {
        log.error("Api Exception = {}", e.getErrorCode().getMessage());
        return ApiResponse.fail(e.getErrorCode());
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public static ApiResponse exception(Exception e) {
//        log.error("Exception = {}", e.getMessage());
//        return ApiResponse.error(ErrorCode.SERVER_ERROR);
//    }

//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(AuthenticationException.class)
//    public static ApiResponse authenticationException(AuthenticationException e) {
//        return ApiResponse.fail(null);
//    }
//
//    @ExceptionHandler(JwtException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public static ApiResponse jwtException(JwtException e) {
//        log.warn("Jwt Exception = {}", e.getClass());
//        return ApiResponse.fail(null);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public static List<ApiResponse> validError(MethodArgumentNotValidException e) {
//        log.warn("Method Argument Not Valid Exception = {}", e.getClass());
//        List<ApiResponse> errors = new ArrayList<>();
//        if (e.hasFieldErrors()) {
//            e.getFieldErrors().stream()
//                .forEach(error -> {
//                    String message = String.format("%s = %s (%s)",
//                        error.getField(), error.getRejectedValue(), error.getDefaultMessage());
//                    errors.add(ApiResponse.error(null));
//                });
//        } else {
//            errors.add(ApiResponse.error(null));
//        }
//        return errors;
//    }
}
