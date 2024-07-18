package com.felipedias.projeto_final_blog_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String bio;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> featuredPosts = new ArrayList<>();

    public Long getId(){
        return id;

    }

    public void setId(Long id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public List<Post> getFeaturedPosts() {
        return featuredPosts;
    }

    public void addFeaturedPosts(Post featurePost) {
        this.featuredPosts.add(featurePost);
    }
}
