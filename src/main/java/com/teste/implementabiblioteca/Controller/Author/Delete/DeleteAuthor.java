package com.teste.implementabiblioteca.Controller.Author.Delete;


import com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;


@RestController
public class DeleteAuthor {
    @Autowired
    private Services service;

    @DeleteMapping("/DeleteAuthor/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        try {
             service.delete(id);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
