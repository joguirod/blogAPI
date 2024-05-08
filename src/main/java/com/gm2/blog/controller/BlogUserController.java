package com.gm2.blog.controller;

import com.gm2.blog.dto.BlogUserDTO;
import com.gm2.blog.entities.BlogUser;
import com.gm2.blog.exceptions.BlogUserNotFoundException;
import com.gm2.blog.service.BlogUserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BlogUserController {
    private final BlogUserService blogUserService;
    public BlogUserController(BlogUserService blogUserService){
        this.blogUserService = blogUserService;
    }

    @GetMapping()
    public ResponseEntity<List<BlogUser>> getAllBlogUsers(){
        return new ResponseEntity<>(blogUserService.getAllBlogUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogUser> getBlogUserById(@PathVariable Long id) throws BlogUserNotFoundException {
        return new ResponseEntity<>(blogUserService.getBlogUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BlogUser> createBlogUser(@RequestBody BlogUserDTO blogUserDTO){
        return new ResponseEntity<>(blogUserService.createBlogUser(blogUserDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogUser> updateBlogUser(@PathVariable Long id, @RequestBody BlogUserDTO blogUserDTO) throws BlogUserNotFoundException {
        return new ResponseEntity<>(blogUserService.updateBlogUser(id, blogUserDTO), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBlogUser(@PathVariable Long id) throws BlogUserNotFoundException {
        blogUserService.deleteBlogUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
