package com.teste.implementabiblioteca.Controller.Author.Delete;

import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.teste.implementabiblioteca.Controller.Author.ExceptionHandler.Handler.map;
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

        } catch (Throwable e) {
            return map(e);
        }
    }
}
