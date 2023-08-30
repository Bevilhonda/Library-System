package com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors;


import com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors.DTO.ListAllAuthors;
import com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors.DTO.Response;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import com.teste.implementabiblioteca.Model.Author.Exceptions.TypeExceptions.AuthorExceptions;
import com.teste.implementabiblioteca.Model.Author.Exceptions.TypeExceptions.ListEmpty;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Model.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;
import static org.springframework.http.HttpStatus.*;

@RestController
public class SearchAllAuthors {
    @Autowired
    private ServicesAuthor services;

    @GetMapping("/Authors")
    public ResponseEntity<?> GetAll_Authors() {
        try {
            List<AuthorEntity> listAuthor = services.getAllAuthor();

            if (listAuthor.isEmpty()) {
                throw new ListEmpty();
            }
            return ResponseEntity.status(OK).body(ListAllAuthors.from(listAuthor));

        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
