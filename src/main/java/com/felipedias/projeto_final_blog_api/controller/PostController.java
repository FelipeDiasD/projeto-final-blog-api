package com.felipedias.projeto_final_blog_api.controller;

import com.felipedias.projeto_final_blog_api.model.Post;
import com.felipedias.projeto_final_blog_api.model.dto.PostDTO;
import com.felipedias.projeto_final_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> searchPostById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(postService.searchPostById(id));
    }

    @GetMapping("/post/title/{title}")
    public ResponseEntity<List<Post>> searchPostById(@PathVariable String title){
        return ResponseEntity.status(HttpStatus.OK).body(postService.searchPostByTitle(title));
    }

    @PostMapping("/post")
    public ResponseEntity createPost(@RequestBody Post post){
        postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity updatePost(@PathVariable Long id, @RequestBody PostDTO post){
        postService.updatePost(id, post);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PutMapping("/post/feature/{id}")
    public ResponseEntity featureOnePost(@PathVariable Long id, @RequestBody Boolean feature){
        postService.featureExistingPost(id, feature);
        return ResponseEntity.status(HttpStatus.OK).body("POST FEATURED!");
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity deleteExistingPost(@PathVariable Long id){
        postService.deleteExistingPost(id);
        return ResponseEntity.status(HttpStatus.OK).body("POST DELETED ID:" + id);
    }









}
