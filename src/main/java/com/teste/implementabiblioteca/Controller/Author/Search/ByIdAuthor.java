package com.teste.implementabiblioteca.Controller.Author.Search;

import com.teste.implementabiblioteca.Controller.Author.FormatterResponse.Body;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.AuthorNotFound;
import com.teste.implementabiblioteca.Services.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByIdAuthor {
    @Autowired
    private Author author;

    @GetMapping("/Author/{id}")
    public ResponseEntity<?> GetAuthorById(@PathVariable Integer id) throws AuthorNotFound {

        AuthorEntity authorEntity = author.GetAutorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Body.from(authorEntity));
    }
}
