package com.gm2.blog.exceptions;

public class AuthorNotFoundException extends ApplicationException{
    public AuthorNotFoundException(String message){
        super(message);
    }
}
