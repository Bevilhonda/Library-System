package com.teste.implementabiblioteca.Controller.Author.Delete;


import com.teste.implementabiblioteca.Services.Author.ClassServices.DoDeleteAuthor;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.AuthorNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;


@RestController
public class DeleteAuthor {
    @Autowired
    private DoDeleteAuthor service;

    @DeleteMapping("/DeleteAuthor/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        try {
             service.Delete(id);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
