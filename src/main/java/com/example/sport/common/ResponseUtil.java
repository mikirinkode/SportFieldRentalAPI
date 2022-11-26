package com.example.sport.common;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@NoArgsConstructor
public class ResponseUtil {

    public static <T> ResponseEntity<Object> build(boolean isError, String message, T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(build(isError, message, data), httpStatus);
    }

    public static <T>ApiResponse<T> build(boolean isError, String message, T data){
        return ApiResponse.<T>builder()
                .error(isError)
                .message(message)
                .timestamp(LocalDateTime.now())
                .data(data)
                .build();
    }
}