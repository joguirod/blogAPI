package com.gm2.blog.controller;

import com.gm2.blog.service.BlogUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BlogUserController {
    private final BlogUserService blogUserService;
    public BlogUserController(BlogUserService blogUserService){
        this.blogUserService = blogUserService;
    }
}
