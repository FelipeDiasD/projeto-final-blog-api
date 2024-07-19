package com.felipedias.projeto_final_blog_api.controller.exception;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id){
        super("RECURSO NÃO ENCONTRADO. ID: " + id);
    }

    public ResourceNotFoundException (String title){
        super("RECURSO NÃO ENCONTRADO. ID: " + title);
    }
}
