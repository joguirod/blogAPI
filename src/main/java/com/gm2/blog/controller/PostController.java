package com.gm2.blog.controller;

import com.gm2.blog.dto.PostDTO;
import com.gm2.blog.dto.PostEditionDTO;
import com.gm2.blog.exceptions.AuthorNotFoundException;
import com.gm2.blog.exceptions.PostNotFoundException;
import com.gm2.blog.service.PostService;
import com.gm2.blog.entities.Post;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) throws PostNotFoundException {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO) throws AuthorNotFoundException {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody PostEditionDTO postEditionDTO) throws PostNotFoundException {
        return new ResponseEntity<Post>(postService.updatePost(postEditionDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Long id) throws PostNotFoundException {
        postService.deletePost(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity upVotePost(@PathVariable Long id) throws PostNotFoundException {
        postService.addUpVoteToPost(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
