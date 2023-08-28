package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears;

import com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO.Response;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.DateBirthNotFound;
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
public class SearchByDateBirth {
    @Autowired
    private ServicesAuthor service;

    @GetMapping("/Autor/DateBirth/{startDate}/{finalDate}")
    public ResponseEntity<?> GetAuthorByDateBirth(@PathVariable String startDate,
                                                  @PathVariable String finalDate) {
        try {
            List<AuthorEntity> authors = service.getauthorbydatebirth(startDate, finalDate);
            if (authors.isEmpty()) {
                throw new DateBirthNotFound(startDate, finalDate);
            }
            return ResponseEntity.status(OK).body(Response.from(authors));
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
