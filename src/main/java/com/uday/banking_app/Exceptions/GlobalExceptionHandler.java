package com.uday.banking_app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice // by using this anotation we can use this class in
// all controllers and it will be global exception handler class
public class GlobalExceptionHandler {

    //Handle specific exception - account exception
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetails> handleAccountException(AccountException accountException, WebRequest webRequest)
    {
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
                accountException.getMessage(),
                webRequest.getDescription(false),
                "ACCOUNT_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    //other than account exception all exceptions are caught here
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGeneralException(Exception exception,WebRequest webRequest)
    {
        ErrorDetails errorDetails= new ErrorDetails(LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL SERVER ERROR");
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
