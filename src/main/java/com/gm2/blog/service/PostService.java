package com.gm2.blog.service;

import com.gm2.blog.entities.Post;
import com.gm2.blog.exceptions.PostNotFoundException;
import com.gm2.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    // could be @Autowired
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(Long id) throws PostNotFoundException {
        Optional<Post> postFound = postRepository.findById(id);

        if(postFound.isEmpty()) throw new PostNotFoundException("Looked post not found");

        return postFound.get();
    }
}
