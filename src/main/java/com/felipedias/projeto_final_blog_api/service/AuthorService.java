package com.felipedias.projeto_final_blog_api.service;

import com.felipedias.projeto_final_blog_api.model.Author;
import com.felipedias.projeto_final_blog_api.model.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    Author searchById(Long id);
    List<Author> getAllAuthors();
    void createAuthor(Author authorObj);
    void updateAuthor(Long id, AuthorDTO author);
    void deleteById(Long id);
}
