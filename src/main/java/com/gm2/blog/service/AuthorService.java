package com.gm2.blog.service;

import com.gm2.blog.entities.Author;
import com.gm2.blog.exceptions.AuthorNotFoundException;
import com.gm2.blog.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) throws AuthorNotFoundException {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isEmpty()) throw new AuthorNotFoundException("Author with informed id not found");

        return author.get();
    }

}
