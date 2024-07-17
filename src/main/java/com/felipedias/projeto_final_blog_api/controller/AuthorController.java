package com.felipedias.projeto_final_blog_api.controller;

import com.felipedias.projeto_final_blog_api.model.Author;
import com.felipedias.projeto_final_blog_api.service.AuthorService;
import com.felipedias.projeto_final_blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> searchAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> searchAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.searchById(id));
    }

    @PostMapping("/author")
    public ResponseEntity insertAuthor(Author author){
        authorService.createAuthor(author);
        return ResponseEntity.ok("CREATED AUTHOR");
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Long id){
        authorService.deleteById(id);
        return ResponseEntity.ok("DELETED AUTHOR");
    }
}
