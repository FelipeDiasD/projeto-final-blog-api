package com.felipedias.projeto_final_blog_api.service.impl;

import com.felipedias.projeto_final_blog_api.controller.exception.ResourceNotFoundException;
import com.felipedias.projeto_final_blog_api.model.Author;
import com.felipedias.projeto_final_blog_api.model.Post;
import com.felipedias.projeto_final_blog_api.model.dto.PostDTO;
import com.felipedias.projeto_final_blog_api.repository.AuthorRepository;
import com.felipedias.projeto_final_blog_api.repository.PostRepository;
import com.felipedias.projeto_final_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Post searchPostById(Long id) {
        var foundPost = postRepository.findById(id);
        if(foundPost.isEmpty()){
            throw new ResourceNotFoundException(id);
        }
        return foundPost.get();
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> searchPostByTitle(String title) {
        var foundPosts = postRepository.findByTitle(title);

        return foundPosts;


    }

    @Override
    public void createPost(Post post) {
        //Posts must have title, description and content and reference an author

        var authorId = post.getAuthor().getId();

        if(authorRepository.findById(authorId).isEmpty()){
            throw new ResourceNotFoundException(authorId);
        }

        if(post.getTitle() == null || post.getTitle().isEmpty()){
            throw new IllegalArgumentException("Posts must have a title!");
        }

        if(post.getDescription() == null || post.getDescription().isEmpty()){
            throw new IllegalArgumentException("Posts must have a description!");
        }

        if(post.getContent() == null || post.getContent().isEmpty()){
            throw new IllegalArgumentException("Posts must have content!");
        }

        postRepository.save(post);

        if(post.getFeatured() == true){
            var existingAuthor = authorRepository.findById(authorId).get();
            existingAuthor.addFeaturedPosts(post);
            authorRepository.save(existingAuthor);
        }
    }

    @Override
    public void updatePost(Long id, PostDTO post) {

        if(!postRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        var foundPost = postRepository.findById(id).get();

        if(post.getTitle() != null && !post.getTitle().isEmpty()){
            foundPost.setTitle(post.getTitle());
        }
        if(post.getDescription() != null && !post.getDescription().isEmpty()){
            foundPost.setDescription(post.getDescription());
        }
        if(post.getContent() != null && !post.getContent().isEmpty()){
            foundPost.setContent(post.getContent());
        }

        //Only available to update is the content of the post (title, description and content)

        postRepository.save(foundPost);
    }

    @Override
    public void featureExistingPost(Long id, Boolean isFeatured) {

        if(!postRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        var targetPost = postRepository.findById(id).get();
        var existingAuthor = authorRepository.findById(targetPost.getAuthor().getId()).get();

        if(isFeatured == true){
            targetPost.setFeatured(true);
            existingAuthor.addFeaturedPosts(targetPost);
            postRepository.save(targetPost);
            authorRepository.save(existingAuthor);
        }
    }

    @Override
    public void deleteExistingPost(Long id){

        if(!postRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        postRepository.deleteById(id);

    }
}
