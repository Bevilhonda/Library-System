package com.teste.implementabiblioteca.Controller.Author.Insert;

import com.teste.implementabiblioteca.Controller.Author.Insert.DTO.DataAuthorEntity;
import com.teste.implementabiblioteca.Model.Author.TypeExceptions.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;
import static org.springframework.http.HttpStatus.*;

@RestController
public class InsertAuhtor {
    @Autowired
    private ServicesAuthor service;

    @PostMapping("/InsertAuthor")
    public ResponseEntity<?> Insert(@RequestBody DataAuthorEntity author) {
        try {
            service.insert(author.toModel());

            return ResponseEntity.status(OK).build();
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
