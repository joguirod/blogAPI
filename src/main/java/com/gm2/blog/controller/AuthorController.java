package com.gm2.blog.controller;

import com.gm2.blog.dto.AuthorDTO;
import com.gm2.blog.entities.Author;
import com.gm2.blog.exceptions.AuthorNotFoundException;
import com.gm2.blog.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAuthors(){
            return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) throws AuthorNotFoundException {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDTO authorDTO){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
