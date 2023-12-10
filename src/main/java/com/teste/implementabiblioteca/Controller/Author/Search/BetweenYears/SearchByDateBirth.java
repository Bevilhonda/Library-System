package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears;

import com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO.Response;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Author.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SearchByDateBirth {
    @Autowired
    private ServicesAuthor service;

    @GetMapping("/Autor/DateBirth/{startDate}/{finalDate}")
    public ResponseEntity<?> byDateBirth(@PathVariable String startDate,
                                         @PathVariable String finalDate) {
        try {
            List<AuthorEntity> authors = service.getByDateBirth(startDate, finalDate);

            return ResponseEntity.status(OK).body(Response.from(authors));
        } catch (Throwable e) {
            return map(e);
        }
    }
}
