package com.gm2.blog.exceptions;

public class BlogUserNotFoundException extends ApplicationException{
    public BlogUserNotFoundException(String message){
        super(message);
    }
}
