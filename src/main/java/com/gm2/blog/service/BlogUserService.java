package com.gm2.blog.service;

import com.gm2.blog.dto.BlogUserDTO;
import com.gm2.blog.entities.Author;
import com.gm2.blog.entities.BlogUser;
import com.gm2.blog.exceptions.BlogUserNotFoundException;
import com.gm2.blog.repositories.BlogUserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BlogUserService {
    private final BlogUserRepository blogUserRepository;
    public BlogUserService(BlogUserRepository blogUserRepository){
        this.blogUserRepository = blogUserRepository;
    }

    public List<BlogUser> getAllBlogUsers(){
        return blogUserRepository.findAll();
    }

    public BlogUser getBlogUserById(Long id) throws BlogUserNotFoundException {
        Optional<BlogUser> blogUser = blogUserRepository.findById(id);
        if(blogUser.isEmpty()) throw new BlogUserNotFoundException("Blog user informed not found");

        return blogUser.get();
    }

    public BlogUser createBlogUser(BlogUserDTO blogUserDTO){
        BlogUser blogUser = new BlogUser(blogUserDTO);
        return blogUserRepository.save(blogUser);
    }
}
