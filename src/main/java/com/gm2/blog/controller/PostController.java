package com.gm2.blog.controller;

import com.gm2.blog.exceptions.PostNotFoundException;
import com.gm2.blog.service.PostService;
import com.gm2.blog.entities.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) throws PostNotFoundException {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }
    
}
