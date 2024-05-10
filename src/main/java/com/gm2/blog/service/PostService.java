package com.gm2.blog.service;

import com.gm2.blog.dto.PostDTO;
import com.gm2.blog.dto.PostEditionDTO;
import com.gm2.blog.entities.Author;
import com.gm2.blog.entities.BlogUser;
import com.gm2.blog.entities.Post;
import com.gm2.blog.exceptions.AuthorNotFoundException;
import com.gm2.blog.exceptions.PostNotFoundException;
import com.gm2.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    // could be @Autowired
    private final PostRepository postRepository;
    private final AuthorService authorService;
    public PostService(PostRepository postRepository, AuthorService authorService) {
        this.postRepository = postRepository;
        this.authorService = authorService;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(Long id) throws PostNotFoundException {
        Optional<Post> postFound = postRepository.findById(id);

        if(postFound.isEmpty()) throw new PostNotFoundException("Looked post not found");

        return postFound.get();
    }

    public Post createPost(PostDTO postDTO) throws AuthorNotFoundException {
        Post post = new Post();
        post.setPostText(postDTO.text());

        Author author = authorService.getAuthorById(postDTO.authorId());

        post.setAuthor(author);

        return postRepository.save(post);
    }

    public Post updatePost(PostEditionDTO postEditionDTO) throws PostNotFoundException {
        Post post = getPostById(postEditionDTO.postId());

        post.setPostText(postEditionDTO.text());

        return postRepository.save(post);
    }

    public void deletePost(Long id) throws PostNotFoundException {
        Post post = getPostById(id);

        postRepository.delete(post);
    }
}
