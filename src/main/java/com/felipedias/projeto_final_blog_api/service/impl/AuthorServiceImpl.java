package com.felipedias.projeto_final_blog_api.service.impl;

import com.felipedias.projeto_final_blog_api.controller.exception.ResourceNotFoundException;
import com.felipedias.projeto_final_blog_api.model.Author;
import com.felipedias.projeto_final_blog_api.model.dto.AuthorDTO;
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
        var foundAuthor = authorRepository.findById(id);
        if(foundAuthor.isEmpty()){
            throw new ResourceNotFoundException(id);
        }
        return foundAuthor.get();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void createAuthor(Author authorObj) {
        //authors must have name and email
        if(authorObj.getName() == null || authorObj.getName().isEmpty()){
            throw new IllegalArgumentException("Author must have a name!");
        }

        if(authorObj.getEmail() == null || authorObj.getEmail().isEmpty()){
            throw new IllegalArgumentException("Author must have a email!");
        }
        authorRepository.save(authorObj);
    }

    @Override
    public void updateAuthor(Long id, AuthorDTO authorObj){

        //Only updates name, email and bio fields in existing authors
        if(!authorRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        var foundAuthor = authorRepository.findById(id).get();

        if(authorObj.getName() != null && !authorObj.getName().isEmpty()){
            foundAuthor.setBio(authorObj.getBio());
        }
        if(authorObj.getEmail() != null && !authorObj.getEmail().isEmpty()){
            foundAuthor.setBio(authorObj.getBio());
        }
        if(authorObj.getBio() != null && !authorObj.getBio().isEmpty() ){
            foundAuthor.setBio(authorObj.getBio());
        }
        authorRepository.save(foundAuthor);
    }

    @Override
    public void deleteById(Long id) {
        if(!authorRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        authorRepository.deleteById(id);
    }
}
