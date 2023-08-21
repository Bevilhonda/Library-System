package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ById;

import com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ById.Response.FormatResponseById;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ClassServices.AuthorByID;
import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.AuthorNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;

@RestController
public class SearchById {
    @Autowired
    private AuthorByID author;

    @GetMapping("/Author/{id}")
    public ResponseEntity<?> GetAuthorById(@PathVariable Integer id) {

        try {
            AuthorEntity authorEntity = author.GetAutorById(id);
            if (authorEntity == null) {
                throw new AuthorNotFound(id);
            }
            return FormatResponseById.responseById(authorEntity);
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }

    }
}