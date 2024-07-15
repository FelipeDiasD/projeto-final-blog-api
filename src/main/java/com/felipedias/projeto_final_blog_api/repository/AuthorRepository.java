package com.felipedias.projeto_final_blog_api.repository;

import com.felipedias.projeto_final_blog_api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
