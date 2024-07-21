package com.felipedias.projeto_final_blog_api.service;

import com.felipedias.projeto_final_blog_api.model.Post;
import com.felipedias.projeto_final_blog_api.model.dto.PostDTO;

import java.util.List;

public interface PostService {

    Post searchPostById(Long id);
    List<Post> getAllPosts();
    List<Post> searchPostByTitle(String title);
    void createPost(Post post);
    void updatePost(Long id, PostDTO post);
    void featureExistingPost(Long id, Boolean isFeatured);
    void deleteExistingPost(Long id);


}
