package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search;

import com.teste.implementabiblioteca.Services.Author.ClassServices.AuthorByDateBirth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateBirth {
    @Autowired
    private AuthorByDateBirth author;

    @GetMapping("/Autor/DateBirth/{startDate}/{finalDate}")
    public ResponseEntity<?> GetAuthorByDateBirth(@PathVariable String startDate,
                                                  @PathVariable String finalDate) {
        return author.GetAuthorByDateBirth(startDate, finalDate);
    }
}
