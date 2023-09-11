package com.teste.implementabiblioteca.Controller.Author.Insert;

import com.teste.implementabiblioteca.Controller.Author.Insert.DTO.DataAuthorEntity;
import com.teste.implementabiblioteca.Model.Author.Exceptions.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Author.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
public class InsertAuhtor {
    @Autowired
    private ServicesAuthor service;

    @PostMapping("/InsertAuthor")
    public ResponseEntity<?> insert(@RequestBody DataAuthorEntity author) {
        try {
            service.insert(author.toModel());

            return ResponseEntity.status(OK).build();
        } catch (Throwable e) {
            return map(e);
        }
    }
}
