package com.felipedias.projeto_final_blog_api.service.impl;

import com.felipedias.projeto_final_blog_api.model.Author;
import com.felipedias.projeto_final_blog_api.model.Post;
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
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post searchPostByTitle(String title) {
        var foundPost = postRepository.findByTitle(title).get();
        if(foundPost == null){
            //todo throw an exception
            return null;
        }

        return foundPost;
    }

    @Override
    public void createPost(Post post) {
        //Posts must have title, description and content and reference an author

        var authorId = post.getAuthor().getId();

        if(authorRepository.findById(authorId).isEmpty()){
            //todo throw an exception
            return;
        }



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

        if(post.getFeatured() == true){
            var existingAuthor = authorRepository.findById(authorId).get();
            existingAuthor.addFeaturedPosts(post);
            authorRepository.save(existingAuthor);
        }
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
    public void featureExistingPost(Long id, Boolean isFeatured) {
        var targetPost = postRepository.findById(id).get();
        var existingAuthor = authorRepository.findById(targetPost.getAuthor().getId()).get();

        if(isFeatured == true){
            targetPost.setFeatured(true);
            existingAuthor.addFeaturedPosts(targetPost);
            postRepository.save(targetPost);
            authorRepository.save(existingAuthor);
        }
    }
}
