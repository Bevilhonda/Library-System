package com.teste.implementabiblioteca.Controller.Author.Search.ById;

import com.teste.implementabiblioteca.Controller.Author.Search.ById.DTO.Response;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Author.Exceptions.TypeExceptions.AuthorExceptions;
import com.teste.implementabiblioteca.Model.Author.Exceptions.TypeExceptions.AuthorNotFound;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Model.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;
import static org.springframework.http.HttpStatus.*;

@RestController
public class SearchById {
    @Autowired
    private ServicesAuthor services;

    @GetMapping("/Author/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Integer id) {

        try {
            AuthorEntity authorEntity = services.getAutorById(id);
            if (authorEntity == null) {
                throw new AuthorNotFound(id);
            }
            return ResponseEntity.status(OK).body(Response.from(authorEntity));
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
