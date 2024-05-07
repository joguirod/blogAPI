package com.gm2.blog.exceptions;

public class PostNotFoundException extends ApplicationException{

    public PostNotFoundException(String message) {
        super(message);
    }
}
