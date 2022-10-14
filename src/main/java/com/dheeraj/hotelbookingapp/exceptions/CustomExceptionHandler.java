package com.dheeraj.hotelbookingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Object> handleHotelNotFoundException(HotelNotFoundException ex, WebRequest webRequest) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();
        return new ResponseEntity<>(errorMessageDescription, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();
        return new ResponseEntity<>(errorMessageDescription, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
