package com.felipedias.projeto_final_blog_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String bio;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> featuredPosts;

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

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getFeaturedPosts() {
        return featuredPosts;
    }

    public void setFeaturedPosts(List<Post> featuredPosts) {
        this.featuredPosts = featuredPosts;
    }
}
