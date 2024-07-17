package com.felipedias.projeto_final_blog_api.service.impl;

import com.felipedias.projeto_final_blog_api.model.Author;
import com.felipedias.projeto_final_blog_api.repository.AuthorRepository;
import com.felipedias.projeto_final_blog_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author searchById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void createAuthor(Author authorObj) {
        //authors must have name
        authorRepository.save(authorObj);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
