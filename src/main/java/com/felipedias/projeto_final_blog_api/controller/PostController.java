package com.felipedias.projeto_final_blog_api.controller;

import com.felipedias.projeto_final_blog_api.model.Post;
import com.felipedias.projeto_final_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> searchAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> searchPostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.searchPostById(id));
    }

    @GetMapping("/post/{title}")
    public ResponseEntity<Post> searchPostById(@PathVariable String title){
        return ResponseEntity.ok(postService.searchPostByTitle(title));
    }

    @PostMapping("/post")
    public ResponseEntity createPost(@RequestBody Post post){
        postService.createPost(post);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity updatePost(@PathVariable Long id, @RequestBody Post post){
        postService.updatePost(id, post);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/post/feature/{id}")
    public ResponseEntity featureOnePost(@PathVariable Long id, @RequestBody Boolean feature){
        postService.featurePost(id, feature);
        return ResponseEntity.ok("POST FEATURED!");
    }









}
