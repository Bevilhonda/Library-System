package com.teste.implementabiblioteca.Controller.Author.Update;

import com.teste.implementabiblioteca.Controller.Author.Update.DTO.DataAuthorUpdate;
import com.teste.implementabiblioteca.Model.Author.TypeExceptions.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;
import static org.springframework.http.HttpStatus.*;

@RestController
public class UpdateAuthor {
    @Autowired
    private ServicesAuthor service;

    @PutMapping("/UpdateAuthor/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody DataAuthorUpdate novoautor) {
        try {
            service.updateAuthor(id, novoautor.toModel());

            return ResponseEntity.status(OK).build();

        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
