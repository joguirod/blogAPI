package com.gm2.blog.service;

import com.gm2.blog.dto.AuthorDTO;
import com.gm2.blog.entities.Author;
import com.gm2.blog.entities.BlogUser;
import com.gm2.blog.exceptions.AuthorNotFoundException;
import com.gm2.blog.exceptions.BlogUserNotFoundException;
import com.gm2.blog.repositories.AuthorRepository;
import com.gm2.blog.repositories.BlogUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    private final BlogUserRepository blogUserRepository;
    public AuthorService(AuthorRepository authorRepository, BlogUserRepository blogUserRepository){
        this.authorRepository = authorRepository;
        this.blogUserRepository = blogUserRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) throws AuthorNotFoundException {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isEmpty()) throw new AuthorNotFoundException("Author with informed id not found");

        return author.get();
    }

    public Author createAuthor(AuthorDTO authorDTO){
        Author author = new Author();

        Optional<BlogUser> user = blogUserRepository.findById((long) authorDTO.blogUserId());

        author.setUser(user.get());
        author.setName(authorDTO.name());
        author.setBiography(authorDTO.biography());

        return authorRepository.save(author);
    }
    
}
