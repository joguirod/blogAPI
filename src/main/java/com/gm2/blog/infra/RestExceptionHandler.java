package com.gm2.blog.infra;

import com.gm2.blog.exceptions.ApplicationException;
import com.gm2.blog.exceptions.AuthorNotFoundException;
import com.gm2.blog.exceptions.BlogUserNotFoundException;
import com.gm2.blog.exceptions.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    private ResponseEntity<RestExceptionMessage> ApplicationExceptionHandler(ApplicationException exception){
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    private ResponseEntity<RestExceptionMessage> AuthorNotFoundExceptionHandler(AuthorNotFoundException exception){
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(BlogUserNotFoundException.class)
    private ResponseEntity<RestExceptionMessage> BlogUserNotFoundExceptionHandler(BlogUserNotFoundException exception){
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(PostNotFoundException.class)
    private ResponseEntity<RestExceptionMessage> BlogUserExceptionHandler(PostNotFoundException exception){
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
