package com.teste.implementabiblioteca.Controller.Author.Search.AuthorsInTheLibrary;

import com.teste.implementabiblioteca.Controller.Author.Search.AuthorsInTheLibrary.DTO.Response;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.OK;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AllAuthorsRegisteredInTheLibrary {
    @Autowired
    private ServicesAuthor services;

    @GetMapping("/SearchAuthors/{id}")
    public ResponseEntity<?> getAuthorsInLibrary(@PathVariable Integer id) {
        try {
            List<AuthorEntity> listAuthors = services.getAuthorsByNameLibrary(id);

            return ResponseEntity.status(OK).body(Response.from(listAuthors));

        } catch (Throwable e) {
            return map(e);
        }

    }
}
