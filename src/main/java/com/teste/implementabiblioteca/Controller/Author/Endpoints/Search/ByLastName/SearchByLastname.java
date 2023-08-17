package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ByLastName;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ClassServices.AuthorByLastName;
import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.ListEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ByLastName.Response.FormatResponseByLastname.AllAuthors;
import static com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;

@RestController
public class SearchByLastname {
    @Autowired
    private AuthorByLastName author;

    @GetMapping("/Author/LastName/{lastname}")
    public ResponseEntity<?> GetAutorByLastName(@PathVariable String lastname) {
        try {
            List<AuthorEntity> listAuthor = author.GetAuthorByLastName(lastname);
            if (listAuthor.isEmpty()) {
                throw new ListEmpty();
            }
            return AllAuthors(listAuthor);
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }

    }
}
