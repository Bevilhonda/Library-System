package com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors;


import com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors.DTO.Response;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Author.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
public class AllAuthors {
    @Autowired
    private ServicesAuthor services;

    @GetMapping("/Authors")
    public ResponseEntity<?> getAllAuthors() {
        try {
            List<AuthorEntity> listAuthor = services.getAllAuthors();

            return ResponseEntity.status(OK).body(Response.from(listAuthor));

        } catch (Throwable e) {
            return map(e);
        }
    }
}
