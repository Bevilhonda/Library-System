package com.teste.implementabiblioteca.Controller.Author.Delete;


import com.teste.implementabiblioteca.Model.Author.TypeExceptions.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;
import static org.springframework.http.HttpStatus.*;


@RestController
public class DeleteAuthor {
    @Autowired
    private ServicesAuthor service;

    @DeleteMapping("/DeleteAuthor/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        try {
             service.delete(id);

            return ResponseEntity.status(OK).build();
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
