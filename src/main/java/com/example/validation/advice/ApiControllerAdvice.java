package com.example.exeception.advice;

import com.example.exeception.controller.ApiController;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = ApiController.class)
public class ApiControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


}
