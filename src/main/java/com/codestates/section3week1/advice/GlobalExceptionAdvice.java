package com.codestates.section3week1.advice;

import com.codestates.section3week1.exception.BusinessLogicException;
import com.codestates.section3week1.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionAdvice { // 예외처리 클래스

    @ExceptionHandler // 예외 전달해주는 애너테이션
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) { // 유효성 검증에 실패 예외(MethodArgumentNotValidException) 처리 메서드
        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());

        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        /DSDS
    }


    // 핸들러 메서드의 URI 변수인 “/{member-id}”에 0이 넘어올 경우, ConstraintViolationException이 발생
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(
            ConstraintViolationException e) {
        final ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());

        return response;
    }

    @ExceptionHandler
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e) {
        System.out.println(e.getExceptionCode().getStatus());
        System.out.println(e.getMessage());

        final ErrorResponse response = ErrorResponse.of(e.getExceptionCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }

    @ExceptionHandler
    public ResponseEntity handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        final ErrorResponse response = ErrorResponse.of(e);

        return new ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler
    public ResponseEntity handleException(Exception e){
        final ErrorResponse response = ErrorResponse.of(e);

        return new ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
