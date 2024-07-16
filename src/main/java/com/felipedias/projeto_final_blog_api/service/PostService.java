package com.felipedias.projeto_final_blog_api.service;

import com.felipedias.projeto_final_blog_api.model.Post;

import java.util.List;

public interface PostService {

    Post searchPostById(Long id);
    List<Post> getAllPosts(Long id);
    Post searchPostByTitle(String title);
    void createPost(Post post);
    void updatePost(Long id, Post post);
    void featurePost(Long id, Boolean isFeatured);


}