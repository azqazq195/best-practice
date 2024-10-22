package com.moseoh.unio.infrastructure;


import com.moseoh.unio.common.dto.ApiResponse;
import com.moseoh.unio.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    // Custom Api Exception
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Void>> handleApiException(ApiException e) {
        log.warn(e.getMessage());
        return ApiResponse.failedOf(e);
    }

    // ValidException Parsing
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + (fieldError.getDefaultMessage() != null ? fieldError.getDefaultMessage() : ""))
                .collect(Collectors.joining(", "));

        log.warn(message);
        return ApiResponse.failedOf(HttpStatus.BAD_REQUEST, message);
    }

    // Request Not Readable
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<Void>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.warn(e.getMessage());
        return ApiResponse.failedOf(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    // UnHandled Exception
    @Order
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> unHandleException(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResponse.failedOf(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
