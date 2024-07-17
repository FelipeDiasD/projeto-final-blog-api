package com.felipedias.projeto_final_blog_api.service.impl;

import com.felipedias.projeto_final_blog_api.model.Author;
import com.felipedias.projeto_final_blog_api.model.Post;
import com.felipedias.projeto_final_blog_api.repository.PostRepository;
import com.felipedias.projeto_final_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post searchPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post searchPostByTitle(String title) {
        return postRepository.findByTitle(title).get();
    }

    @Override
    public void createPost(Post post) {
        //Posts must have title, description and content
        if(post.getTitle() == null || post.getTitle().isEmpty()){
            //todo throw an exception
            return;
        }

        if(post.getDescription() == null || post.getDescription().isEmpty()){
            //todo throw an exception
            return;
        }

        if(post.getContent() == null || post.getContent().isEmpty()){
            //todo throw an exception
            return;
        }

    
        postRepository.save(post);
    }

    @Override
    public void updatePost(Long id, Post post) {

        //Only available to update is the content of the post (title, description and content)
        Post targetPost = postRepository.findById(id).get();
        targetPost.setDescription(post.getDescription());
        targetPost.setContent(post.getContent());
        postRepository.save(targetPost);
    }

    @Override
    public void featurePost(Long id, Boolean isFeatured) {
        Post targetPost = postRepository.findById(id).get();
        if(isFeatured == true){
            targetPost.getAuthor().getFeaturedPosts().add(targetPost);
        }
        targetPost.setFeatured(isFeatured);
    }
}
