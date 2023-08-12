package com.teste.implementabiblioteca.Controller.Author.Delete;

import com.teste.implementabiblioteca.Services.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeleteAuthor {
    @Autowired
    private Author author;

    @DeleteMapping("/DeleteAuthor/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        return author.Delete(id);
    }
}
