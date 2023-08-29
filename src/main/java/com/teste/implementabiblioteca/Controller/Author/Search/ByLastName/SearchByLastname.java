package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName;

import com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO.Response;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Author.TypeExceptions.AuthorExceptions;
import com.teste.implementabiblioteca.Model.Author.TypeExceptions.ListEmpty;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;
import static org.springframework.http.HttpStatus.*;

@RestController
public class SearchByLastname {
    @Autowired
    private ServicesAuthor services;

    @GetMapping("/Author/LastName/{lastname}")
    public ResponseEntity<?> GetAutorByLastName(@PathVariable String lastname) {
        try {
            List<AuthorEntity> listAuthor = services.getAuthorByLastName(lastname);
            if (listAuthor.isEmpty()) {
                throw new ListEmpty();
            }
            return ResponseEntity.status(OK).body(Response.from(listAuthor));
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }

    }
}
